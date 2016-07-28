package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.Node;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>subawa</b>
 * <br>(Source path: <i>META-INF/yang/subawa.yang</i>):
 * <pre>
 * list subscriber {
 *     key "subId"
 *     leaf subId {
 *         type uint32;
 *     }
 *     list flow-features {
 *         key "id"
 *         leaf id {
 *             type uint32;
 *         }
 *         leaf Ip-Src {
 *             type ip-prefix;
 *         }
 *         leaf Ip-Dst {
 *             type ip-prefix;
 *         }
 *         leaf Port-Src {
 *             type port-number;
 *         }
 *         leaf Port-Dst {
 *             type port-number;
 *         }
 *         leaf Ip-Version {
 *             type ip-version;
 *         }
 *         leaf Ip-Protocol {
 *             type enumeration;
 *         }
 *         leaf count {
 *             type uint32;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>subawa/nodes-subscriber-info/node/subscriber</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.SubscriberBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.SubscriberBuilder
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.SubscriberKey
 *
 */
public interface Subscriber
    extends
    ChildOf<Node>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.Subscriber>,
    Identifiable<SubscriberKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:subawa",
        "2015-01-05", "subscriber").intern();

    java.lang.Long getSubId();
    
    List<FlowFeatures> getFlowFeatures();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    SubscriberKey getKey();

}

