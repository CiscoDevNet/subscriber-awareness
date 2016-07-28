package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>subawa</b>
 * <br>(Source path: <i>META-INF/yang/subawa.yang</i>):
 * <pre>
 * container subscriber-basic-info {
 *     list subscriber-basic-info-entry {
 *         key "subId"
 *         leaf subId {
 *             type uint32;
 *         }
 *         leaf fname {
 *             type string;
 *         }
 *         leaf lname {
 *             type string;
 *         }
 *         leaf address {
 *             type string;
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>subawa/subscriber-basic-info</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.SubscriberBasicInfoBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.SubscriberBasicInfoBuilder
 *
 */
public interface SubscriberBasicInfo
    extends
    ChildOf<SubawaData>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.SubscriberBasicInfo>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:subawa",
        "2015-01-05", "subscriber-basic-info").intern();

    /**
     * List of all subscriber-basic database instances.
     *
     */
    List<SubscriberBasicInfoEntry> getSubscriberBasicInfoEntry();

}

