package org.opendaylight.subawa.impl;

import com.google.common.base.Optional;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.Futures;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.ReadTransaction;
import org.opendaylight.controller.md.sal.binding.api.WriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.md.sal.common.api.data.ReadFailedException;
import org.opendaylight.controller.md.sal.common.api.data.TransactionCommitFailedException;

import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Prefix;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv6Prefix;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Uri;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.IpVersion;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.IpPrefix;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.PortNumber;

import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.DecNwTtlCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.DropActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.OutputActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.dec.nw.ttl._case.DecNwTtl;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.dec.nw.ttl._case.DecNwTtlBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.drop.action._case.DropAction;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.drop.action._case.DropActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.output.action._case.OutputActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.Action;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.ActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.ActionKey;

import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNode;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.Table;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.TableKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.Flow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.FlowBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.FlowKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.flow.InstructionsBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.flow.MatchBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.instruction.ApplyActionsCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.instruction.apply.actions._case.ApplyActionsBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.list.Instruction;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.list.InstructionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.list.InstructionKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;

import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.l2.types.rev130827.EtherType;

import org.opendaylight.yang.gen.v1.urn.opendaylight.model.match.types.rev131026.ethernet.match.fields.EthernetTypeBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.match.types.rev131026.match.EthernetMatchBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.match.types.rev131026.match.layer._3.match.Ipv4MatchBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.match.types.rev131026.match.layer._3.match.Ipv6MatchBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.match.types.rev131026.match.layer._4.match.TcpMatchBuilder;

import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.*;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.greeting.registry.GreetingRegistryEntry;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.greeting.registry.GreetingRegistryEntryBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.greeting.registry.GreetingRegistryEntryKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.NodeKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.Subscriber;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntryBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntryKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntryBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntryKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.subscriber.flow.info.entry.FlowFeatures;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.subscriber.flow.info.entry.FlowFeaturesBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.subscriber.flow.info.entry.FlowFeaturesKey;

import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;


/**
 * Created by odldev on 7/7/16.
 */
public class SubawaImp implements SubawaService {
    private static final Logger LOG = LoggerFactory.getLogger(SubawaImp.class);
    private DataBroker db;
    
    public SubawaImp(DataBroker db){
        this.db = db;
        initializeDataTree();
    }




    private void initializeDataTree() {
        LOG.info("Preparing to initialize the data tree");

        WriteTransaction writeTx = db.newWriteOnlyTransaction();
        InstanceIdentifier<SubscriberBasicInfo> iid_basic = InstanceIdentifier.create(SubscriberBasicInfo.class);
        SubscriberBasicInfo subscriberBasicInfo = new SubscriberBasicInfoBuilder().build();
        writeTx.put(LogicalDatastoreType.OPERATIONAL, iid_basic, subscriberBasicInfo);

        InstanceIdentifier<GreetingRegistry> iid = InstanceIdentifier.create(GreetingRegistry.class);
        GreetingRegistry greetingRegistry = new GreetingRegistryBuilder()
                .build();
        writeTx.put(LogicalDatastoreType.OPERATIONAL, iid, greetingRegistry);

        InstanceIdentifier<SubscriberFlowInfo> iid_flow = InstanceIdentifier.create(SubscriberFlowInfo.class);
        SubscriberFlowInfo subscriberFlowInfo = new SubscriberFlowInfoBuilder().build();
        writeTx.put(LogicalDatastoreType.OPERATIONAL, iid_flow, subscriberFlowInfo);

        InstanceIdentifier<NodesSubscriberInfo> iid_nodes = InstanceIdentifier.create(NodesSubscriberInfo.class);
        NodesSubscriberInfo nodesSubscriberInfo = new NodesSubscriberInfoBuilder().build();
        writeTx.put(LogicalDatastoreType.OPERATIONAL, iid_nodes, nodesSubscriberInfo);


        CheckedFuture<Void, TransactionCommitFailedException> future_basic = writeTx.submit();
        Futures.addCallback(future_basic, new LoggingFuturesCallBack<Void>(
                "Succeeded to initialize the data tree",
                "Failed to initialize the data tree",
                LOG));



    }

    @Override
    public Future<RpcResult<RegisterSubscriberBasicInfoOutput>> registerSubscriberBasicInfo(RegisterSubscriberBasicInfoInput input) {
        // receive RCP to register subsccriberBasic Info
        //write the subscriber basic info to the SubscriberBasicInfo data store
        WriteTransaction writeTx = db.newWriteOnlyTransaction();
        InstanceIdentifier<SubscriberBasicInfoEntry> iid_basic_info =
                InstanceIdentifier.create(SubscriberBasicInfo.class)
                        .child(SubscriberBasicInfoEntry.class, new SubscriberBasicInfoEntryKey(input.getSubId()));
        SubscriberBasicInfoEntry basicInfoEntry = new SubscriberBasicInfoEntryBuilder().setSubId(input.getSubId())
                .setFname(input.getFname()).setLname(input.getLname()).setAddress(input.getAddress()).build();
        writeTx.put(LogicalDatastoreType.OPERATIONAL, iid_basic_info, basicInfoEntry);

        CheckedFuture<Void,TransactionCommitFailedException> future_entry = writeTx.submit();
        Futures.addCallback(future_entry, new LoggingFuturesCallBack<Void>(
                "Succeeded to push basic info entry to the subscriber basic info registry",
                "Failed to push basic info entry to the subscriber basic info registry",
                LOG));
        RegisterSubscriberBasicInfoOutput output = new RegisterSubscriberBasicInfoOutputBuilder()
                .setResult(input.getSubId()+input.getFname()+input.getLname()+input.getAddress()).build();
        return RpcResultBuilder.success(output).buildFuture();

    //    return null;
    }

    @Override
    public Future<RpcResult<RegisterSubscriberFlowInfoOutput>> registerSubscriberFlowInfo(RegisterSubscriberFlowInfoInput input) {

        WriteTransaction writeTx = db.newWriteOnlyTransaction();
        InstanceIdentifier<SubscriberFlowInfoEntry> iid_Flow_info =
                InstanceIdentifier.create(SubscriberFlowInfo.class)
                        .child(SubscriberFlowInfoEntry.class, new SubscriberFlowInfoEntryKey(input.getSubId()));
        InstanceIdentifier<FlowFeatures> iid_Feature = iid_Flow_info.child(FlowFeatures.class, new FlowFeaturesKey(input.getSubId()));

        SubscriberFlowInfoEntry flowInfoEntry = new SubscriberFlowInfoEntryBuilder().setSubId(input.getSubId())
                .build();
        FlowFeatures flowFeature = new FlowFeaturesBuilder().setId(input.getSubId())
                .setIpSrc(input.getIpSrc()).setIpDst(input.getIpDst())
                .setPortSrc(input.getPortSrc()).setPortDst(input.getPortDst())
                .setIpVersion(input.getIpVersion()).setTimeOut(input.getTimeOut())
      //          .setIpProtocol(new FlowFeatures.IpProtocol(input.getIpProtocol().getIntValue()))
                .build();
        writeTx.put(LogicalDatastoreType.OPERATIONAL,iid_Flow_info,flowInfoEntry);
        writeTx.merge(LogicalDatastoreType.OPERATIONAL, iid_Feature, flowFeature);

        CheckedFuture<Void,TransactionCommitFailedException> future_entry = writeTx.submit();
        Futures.addCallback(future_entry, new LoggingFuturesCallBack<Void>(
                "Succeeded to push flow info entry to the subscriber flow info registry",
                "Failed to push flow info entry to the subscriber flow info registry",
                LOG));

        //install the flow on OF nodes flow table
        Nodes nodes = readCurrentNodes(db);

        for (Node current_node: nodes.getNode()){

            WriteTransaction WriteTx = db.newWriteOnlyTransaction();
            Integer TableId = new Integer(0);
            Long flowId = input.getSubId();
            InstanceIdentifier<Flow> path = InstanceIdentifier.create(Nodes.class).child(Node.class, current_node.getKey())
                    .augmentation(FlowCapableNode.class).child(Table.class, new TableKey(TableId.shortValue()))
                    .child(Flow.class, new FlowKey(new FlowId(flowId.toString())));
            MatchBuilder match = createMatch(input.getIpSrc(), input.getIpDst(), input.getPortSrc(), input.getPortDst(), input.getIpVersion());
            InstructionsBuilder instruction = createOutputInstructions(1);
            Flow flow = new FlowBuilder()
                    .setMatch(match.build()).setInstructions(instruction.build())
                    .setIdleTimeout(input.getTimeOut().intValue()).setHardTimeout(input.getTimeOut().intValue())
                    .setId(new FlowId(flowId.toString()))
                    .setTableId(TableId.shortValue())
                    .setPriority(0)
                    .build();
            WriteTx.put(LogicalDatastoreType.CONFIGURATION, path, flow, true);

            InstanceIdentifier<Flow> path_arp = InstanceIdentifier.create(Nodes.class).child(Node.class, current_node.getKey())
                    .augmentation(FlowCapableNode.class).child(Table.class, new TableKey(TableId.shortValue()))
                    .child(Flow.class, new FlowKey(new FlowId("0")));
            MatchBuilder match_arp = createArpMatch();
            InstructionsBuilder instruction_arp = createFloodInstructions();
            Flow flow_arp = new FlowBuilder()
                    .setMatch(match_arp.build()).setInstructions(instruction_arp.build())
                    .setIdleTimeout(65535).setHardTimeout(65535)
                    .setId(new FlowId("0"))
                    .setTableId(TableId.shortValue())
                    .setPriority(0)
                    .build();
            WriteTx.put(LogicalDatastoreType.CONFIGURATION, path_arp, flow_arp, true);

            CheckedFuture<Void,TransactionCommitFailedException> future_flow = WriteTx.submit();
            Futures.addCallback(future_flow, new LoggingFuturesCallBack<Void>(
                    "Succeeded to push flow info Openflow Configuration datastore",
                    "Failed to push flow info Openflow Configuration datastore",
                    LOG));

            // Listen to the datatree change
            CountListener countListener = new CountListener(db, path, current_node.getId(), input.getSubId());
        }

        //save the flow path with subscriber info

//        return  null;
        RegisterSubscriberFlowInfoOutput output = new RegisterSubscriberFlowInfoOutputBuilder()
                .setResult(input.getSubId().toString()).build();
        return RpcResultBuilder.success(output).buildFuture();

    }




    @Override
    public Future<RpcResult<HelloWorldOutput>> helloWorld(HelloWorldInput input) {
            HelloWorldOutput output = new HelloWorldOutputBuilder()
                .setGreeting("HEllo" + input.getName() + input.getAge()).build();
            writeToGreetingRegistry(input, output);
        return RpcResultBuilder.success(output).buildFuture();
    }

    @Override
    public Future<RpcResult<SubscriberAffectedOutput>> subscriberAffected(SubscriberAffectedInput input){
        ReadTransaction read = db.newReadOnlyTransaction();
        InstanceIdentifier<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.Node> Node_iid
                =InstanceIdentifier.create(NodesSubscriberInfo.class)
                .child(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.Node.class, new NodeKey(input.getNodeName()));

        org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.Node
                node = null;
        Optional<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.Node> optionalDataObject;
        CheckedFuture<Optional<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.Node>, ReadFailedException>
                submitFuture = read.read(LogicalDatastoreType.OPERATIONAL, Node_iid);

        SubscriberAffectedOutputBuilder output = new SubscriberAffectedOutputBuilder();
        List<Long> sub_id = new ArrayList<Long>();

        try {
            optionalDataObject = submitFuture.checkedGet();
            if (optionalDataObject !=null && optionalDataObject.isPresent()){
                node = optionalDataObject.get();
                Iterator<Subscriber> iterator = node.getSubscriber().iterator();
                while (iterator.hasNext()){
                    Subscriber current_sub = iterator.next();
                    sub_id.add(current_sub.getKey().getSubId());
                }
            }

        } catch (ReadFailedException e){
            LOG.error("failed to ....", e);

        }
        return RpcResultBuilder.success(output.setSubscriberAffected(sub_id).build()).buildFuture();
    }

    private void writeToGreetingRegistry(HelloWorldInput input, HelloWorldOutput output) {
        WriteTransaction transaction = db.newWriteOnlyTransaction();
        InstanceIdentifier<GreetingRegistryEntry> iid = toInstanceIdentifier(input);
        GreetingRegistryEntry greeting = new GreetingRegistryEntryBuilder()
                .setGreeting(output.getGreeting())
                .setName(input.getName())
                .build();
        transaction.put(LogicalDatastoreType.OPERATIONAL, iid, greeting);
        CheckedFuture<Void, TransactionCommitFailedException> future = transaction.submit();
        Futures.addCallback(future, new LoggingFuturesCallBack<Void>("success greeting reg",
                "Failed to write greeting to greeting registry", LOG));
    }

    private InstanceIdentifier<GreetingRegistryEntry> toInstanceIdentifier(HelloWorldInput input) {
        InstanceIdentifier<GreetingRegistryEntry> iid = InstanceIdentifier.create(GreetingRegistry.class)
                .child(GreetingRegistryEntry.class, new GreetingRegistryEntryKey(input.getName()));
        return iid;
    }



    private Nodes readCurrentNodes(DataBroker db) {
        ReadTransaction readTx = db.newReadOnlyTransaction();

        InstanceIdentifier<Nodes> nodesIID = InstanceIdentifier.create(Nodes.class);
        Nodes nodes = null;
        Optional<Nodes> optionalDataObject;
        CheckedFuture<Optional<Nodes>, ReadFailedException> submitFuture = readTx.read(LogicalDatastoreType.OPERATIONAL, nodesIID);
        try {
            optionalDataObject = submitFuture.checkedGet();
            if (optionalDataObject !=null && optionalDataObject.isPresent()){
                nodes = optionalDataObject.get();
            }

        } catch (ReadFailedException e){
            LOG.error("failed to ....", e);

        }
        return nodes;
    }

        //match

    private MatchBuilder createMatch(IpPrefix Ip_src, IpPrefix Ip_dst, PortNumber Port_src, PortNumber Port_dst, IpVersion version) {
        MatchBuilder match = new MatchBuilder();
        if (version == IpVersion.Ipv4) {
            Ipv4MatchBuilder ipv4Match = new Ipv4MatchBuilder();

            Ipv4Prefix src = new Ipv4Prefix(Ip_src.getIpv4Prefix().getValue());
            Ipv4Prefix dst = new Ipv4Prefix(Ip_dst.getIpv4Prefix().getValue());
            ipv4Match.setIpv4Source(src);
            ipv4Match.setIpv4Destination(dst);
            match.setLayer3Match(ipv4Match.build());
        } else if (version == IpVersion.Ipv6){
            Ipv6MatchBuilder ipv6Match = new Ipv6MatchBuilder();
            Ipv6Prefix src = new Ipv6Prefix(Ip_src.getIpv4Prefix().toString());
            Ipv6Prefix dst = new Ipv6Prefix(Ip_dst.getIpv4Prefix().toString());
            ipv6Match.setIpv6Source(src);
            ipv6Match.setIpv6Destination(dst);;
            match.setLayer3Match(ipv6Match.build());
        }
        //TODO: Implement Port_Number Match
//        TcpMatchBuilder tcpMatch = new TcpMatchBuilder();
//        org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.PortNumber src =
//                new org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.PortNumber(Port_src.getValue());
//        org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.PortNumber dst =
//                new org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.PortNumber(Port_dst.getValue());
//        tcpMatch.setTcpSourcePort(src);
//        tcpMatch.setTcpDestinationPort(dst);
//        match.setLayer4Match(tcpMatch.build());

        final EthernetMatchBuilder ethmatch = new EthernetMatchBuilder();
        final EthernetTypeBuilder ethtype = new EthernetTypeBuilder();
        ethtype.setType(new EtherType(0x0800L));
        ethmatch.setEthernetType(ethtype.build());
        match.setEthernetMatch(ethmatch.build());


        return match;
    }

    private MatchBuilder createArpMatch() {
        MatchBuilder match = new MatchBuilder();
        final EthernetMatchBuilder ethmatch = new EthernetMatchBuilder();
        final EthernetTypeBuilder ethtype = new EthernetTypeBuilder();
        final EtherType type = new EtherType(0x0806L);
        ethmatch.setEthernetType(ethtype.setType(type).build());
        match.setEthernetMatch(ethmatch.build());

        return match;
    }

    private InstructionsBuilder createDecNwTtlInstruction(){
        final DecNwTtlBuilder ta = new DecNwTtlBuilder();
        final DecNwTtl decNwTtl = ta.build();
        final ActionBuilder ab = new ActionBuilder();
        ab.setAction(new DecNwTtlCaseBuilder().setDecNwTtl(decNwTtl).build());
        ab.setKey(new ActionKey(0));
        ab.setOrder(0);

        //add action to a list
        final List<Action> actionList = new ArrayList<Action>();
        actionList.add(ab.build());

        //create an apply action
        ApplyActionsBuilder aab = new ApplyActionsBuilder();
        aab.setAction(actionList);

        //warp our appyly action in an instruction
        final InstructionBuilder ib = new InstructionBuilder();
        ib.setInstruction(new ApplyActionsCaseBuilder().setApplyActions(aab.build()).build());
        ib.setKey(new InstructionKey(0));
        ib.setOrder(0);

        //put our instruction in a list of Instructions
        final InstructionsBuilder isb = new InstructionsBuilder();
        final List<Instruction> instructions = new ArrayList<Instruction>();
        instructions.add(ib.build());
        ib.setKey(new InstructionKey(0));
        isb.setInstruction(instructions);
        return isb;
    }

    private InstructionsBuilder createDropInstructions(){
        final DropActionBuilder dab = new DropActionBuilder();
        final DropAction dropAction= dab.build();
        final ActionBuilder ab = new ActionBuilder();
        ab.setAction(new DropActionCaseBuilder().setDropAction(dropAction).build());
        ab.setKey(new ActionKey(0));
        ab.setOrder(0);

        //Add drop action to a list
        final List<Action> actionList = new ArrayList<Action>();
        actionList.add(ab.build());

        //create an apply action
        ApplyActionsBuilder aab = new ApplyActionsBuilder();
        aab.setAction(actionList);

        //warp our appyly action in an instruction
        final InstructionBuilder ib = new InstructionBuilder();
        ib.setInstruction(new ApplyActionsCaseBuilder().setApplyActions(aab.build()).build());
        ib.setKey(new InstructionKey(0));
        ib.setOrder(0);

        //put our instruction in a list of Instructions
        final InstructionsBuilder isb = new InstructionsBuilder();
        final List<Instruction> instructions = new ArrayList<Instruction>();
        instructions.add(ib.build());
        ib.setKey(new InstructionKey(0));
        isb.setInstruction(instructions);
        return isb;

    }

    private InstructionsBuilder createFloodInstructions(){
        final OutputActionBuilder output = new OutputActionBuilder();
        final Uri value = new Uri("FLOOD");
        output.setOutputNodeConnector(value);
        final ActionBuilder ab = new ActionBuilder();
        ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
        ab.setKey(new ActionKey(0));
        ab.setOrder(0);

        //Add  action to a list
        final List<Action> actionList = new ArrayList<Action>();
        actionList.add(ab.build());

        //create an apply action
        ApplyActionsBuilder aab = new ApplyActionsBuilder();
        aab.setAction(actionList);

        //warp our appyly action in an instruction
        final InstructionBuilder ib = new InstructionBuilder();
        ib.setInstruction(new ApplyActionsCaseBuilder().setApplyActions(aab.build()).build());
        ib.setKey(new InstructionKey(0));
        ib.setOrder(0);

        //put our instruction in a list of Instructions
        final InstructionsBuilder isb = new InstructionsBuilder();
        final List<Instruction> instructions = new ArrayList<Instruction>();
        instructions.add(ib.build());
        ib.setKey(new InstructionKey(0));
        isb.setInstruction(instructions);
        return isb;


    }

    private InstructionsBuilder createOutputInstructions(Integer nodeConnector){
        final OutputActionBuilder output = new OutputActionBuilder();
        final Uri value = new Uri(nodeConnector.toString());
        output.setOutputNodeConnector(value);
        final ActionBuilder ab = new ActionBuilder();
        ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
        ab.setKey(new ActionKey(0));
        ab.setOrder(0);

        //Add  action to a list
        final List<Action> actionList = new ArrayList<Action>();
        actionList.add(ab.build());

        //create an apply action
        ApplyActionsBuilder aab = new ApplyActionsBuilder();
        aab.setAction(actionList);

        //warp our appyly action in an instruction
        final InstructionBuilder ib = new InstructionBuilder();
        ib.setInstruction(new ApplyActionsCaseBuilder().setApplyActions(aab.build()).build());
        ib.setKey(new InstructionKey(0));
        ib.setOrder(0);

        //put our instruction in a list of Instructions
        final InstructionsBuilder isb = new InstructionsBuilder();
        final List<Instruction> instructions = new ArrayList<Instruction>();
        instructions.add(ib.build());
        ib.setKey(new InstructionKey(0));
        isb.setInstruction(instructions);
        return isb;

    }

}
