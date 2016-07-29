package org.opendaylight.subawa.impl;

import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import org.opendaylight.controller.md.sal.binding.api.*;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.md.sal.common.api.data.OptimisticLockFailedException;
import org.opendaylight.controller.md.sal.common.api.data.TransactionCommitFailedException;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.Flow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.statistics.rev130819.FlowStatisticsData;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.NodesSubscriberInfo;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.NodeBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.NodeKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.Subscriber;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.SubscriberBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.SubscriberKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeaturesBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeaturesKey;
import org.opendaylight.yangtools.concepts.ListenerRegistration;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * Created by odldev on 7/14/16.
 */
public class CountListener implements DataTreeChangeListener<FlowStatisticsData>, AutoCloseable{
    private static final Logger LOG = LoggerFactory.getLogger(CountListener.class);

    private final ListenerRegistration<CountListener> countReg;
    private DataBroker db;
    private InstanceIdentifier<Flow> path;
    private NodeId nodeId;
    private long subId;

    public CountListener(DataBroker dataBroker, InstanceIdentifier<Flow> path, NodeId nodeId, Long subId) {
        InstanceIdentifier<FlowStatisticsData> countPath = path.augmentation(FlowStatisticsData.class);
        this.db = dataBroker;
        this.path = path;
        this.nodeId = nodeId;
        this.subId = subId;
        countReg = db.registerDataTreeChangeListener(
                new DataTreeIdentifier<FlowStatisticsData>(
                        LogicalDatastoreType.OPERATIONAL, countPath), this);
        LOG.info("Count listener registered for path"+path.toString());
    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public void onDataTreeChanged(Collection<DataTreeModification<FlowStatisticsData>> changes) {
        try {
            LOG.info("onDataTreeChanged, change {}", changes);
            for (DataTreeModification<FlowStatisticsData> change : changes) {
                DataObjectModification<FlowStatisticsData> root = change.getRootNode();
                DataObjectModification.ModificationType modType = root.getModificationType();
                LOG.info("onDataTReeChanged, modType {}", modType);
                switch (modType) {
                    case SUBTREE_MODIFIED: {
                        break;
                    }

                    case WRITE:{
                        FlowStatisticsData newData = root.getDataAfter();
                        FlowStatisticsData oldData = root.getDataBefore();
                        Long byteCount = newData.getFlowStatistics().getByteCount().getValue().longValue();
                        Long oldbyteCount = oldData.getFlowStatistics().getByteCount().getValue().longValue();

                        if (byteCount>0 && byteCount>oldbyteCount) {
                            final int tries = 10;
                            doWrite(tries, byteCount);
                        }
                        break;
                    }
                    case DELETE:
                    {
                        LOG.info("delete change");
                        break;
                    }
                    default:
                        LOG.error("unknown modification type {}", modType);
                }
            }
        } catch (Exception e){
            LOG.error("Exception caught while listening to policy changes", e);
        }

    }

    private void doWrite(final int tries, final Long byteCount) {
        WriteTransaction writeTx = db.newWriteOnlyTransaction();
        InstanceIdentifier<Node> node_path = InstanceIdentifier.create(NodesSubscriberInfo.class)
                .child(Node.class, new NodeKey(nodeId.getValue()));
        final InstanceIdentifier<Subscriber> sub_path = node_path.child(Subscriber.class, new SubscriberKey(subId));
        InstanceIdentifier<FlowFeatures> feature_path = sub_path.child(FlowFeatures.class, new FlowFeaturesKey(subId));

        Node node = new NodeBuilder().setNodeId(nodeId.getValue()).build();
        Subscriber subscriber = new SubscriberBuilder().setSubId(subId).build();
        FlowFeatures features = new FlowFeaturesBuilder().setId(subId).setCount(byteCount).build();

        writeTx.merge(LogicalDatastoreType.OPERATIONAL, node_path, node);
        writeTx.merge(LogicalDatastoreType.OPERATIONAL, sub_path, subscriber);
        writeTx.merge(LogicalDatastoreType.OPERATIONAL, feature_path, features);

        CheckedFuture<Void, TransactionCommitFailedException> future_entry = writeTx.submit();
        Futures.addCallback(future_entry, new FutureCallback<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        LOG.info("Succeeded to update Node subscriber Info for subscriber "+subId );
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        if (throwable instanceof OptimisticLockFailedException){
                            LOG.warn("failed due to OptimisticLockFailedException, do retries for subscriber "+subId);
                            if ((tries-1)>0){
                                doWrite(tries - 1, byteCount);
                            } else {
                                LOG.warn("run out of retries for subscriber "+subId);
                            }
                        } else {
                            LOG.warn("failed due to non OptimisticLockFailedException ");
                        }
                    }
                }
        );
    }


}
