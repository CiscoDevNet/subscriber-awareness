package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.Node;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>subawa</b>
 * <br>(Source path: <i>META-INF/yang/subawa.yang</i>):
 * <pre>
 * container nodes-subscriber-info {
 *     list node {
 *         key "nodeId"
 *         leaf nodeId {
 *             type string;
 *         }
 *         list subscriber {
 *             key "subId"
 *             leaf subId {
 *                 type uint32;
 *             }
 *             list flow-features {
 *                 key "id"
 *                 leaf id {
 *                     type uint32;
 *                 }
 *                 leaf Ip-Src {
 *                     type ip-prefix;
 *                 }
 *                 leaf Ip-Dst {
 *                     type ip-prefix;
 *                 }
 *                 leaf Port-Src {
 *                     type port-number;
 *                 }
 *                 leaf Port-Dst {
 *                     type port-number;
 *                 }
 *                 leaf Ip-Version {
 *                     type ip-version;
 *                 }
 *                 leaf Ip-Protocol {
 *                     type enumeration;
 *                 }
 *                 leaf count {
 *                     type uint32;
 *                 }
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>subawa/nodes-subscriber-info</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.NodesSubscriberInfoBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.NodesSubscriberInfoBuilder
 *
 */
public interface NodesSubscriberInfo
    extends
    ChildOf<SubawaData>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.NodesSubscriberInfo>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:subawa",
        "2015-01-05", "nodes-subscriber-info").intern();

    List<Node> getNode();

}

