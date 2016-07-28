package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>subawa</b>
 * <br>(Source path: <i>META-INF/yang/subawa.yang</i>):
 * <pre>
 * container subscriber-flow-info {
 *     list subscriber-flow-info-entry {
 *         key "subId"
 *         leaf subId {
 *             type uint32;
 *         }
 *         list flow-features {
 *             key "id"
 *             leaf id {
 *                 type uint32;
 *             }
 *             leaf Ip-Src {
 *                 type ip-prefix;
 *             }
 *             leaf Ip-Dst {
 *                 type ip-prefix;
 *             }
 *             leaf Port-Src {
 *                 type port-number;
 *             }
 *             leaf Port-Dst {
 *                 type port-number;
 *             }
 *             leaf Ip-Version {
 *                 type ip-version;
 *             }
 *             leaf Ip-Protocol {
 *                 type enumeration;
 *             }
 *             leaf Time-Out {
 *                 type uint32;
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>subawa/subscriber-flow-info</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.SubscriberFlowInfoBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.SubscriberFlowInfoBuilder
 *
 */
public interface SubscriberFlowInfo
    extends
    ChildOf<SubawaData>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.SubscriberFlowInfo>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:subawa",
        "2015-01-05", "subscriber-flow-info").intern();

    /**
     * List of all subscriber-flow database instances.
     *
     */
    List<SubscriberFlowInfoEntry> getSubscriberFlowInfoEntry();

}

