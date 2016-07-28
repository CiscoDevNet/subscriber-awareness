package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.SubscriberBasicInfo;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * List of all subscriber-basic database instances.
 *
 * <p>This class represents the following YANG schema fragment defined in module <b>subawa</b>
 * <br>(Source path: <i>META-INF/yang/subawa.yang</i>):
 * <pre>
 * list subscriber-basic-info-entry {
 *     key "subId"
 *     leaf subId {
 *         type uint32;
 *     }
 *     leaf fname {
 *         type string;
 *     }
 *     leaf lname {
 *         type string;
 *     }
 *     leaf address {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>subawa/subscriber-basic-info/subscriber-basic-info-entry</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntryBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntryBuilder
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntryKey
 *
 */
public interface SubscriberBasicInfoEntry
    extends
    ChildOf<SubscriberBasicInfo>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>,
    Identifiable<SubscriberBasicInfoEntryKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:subawa",
        "2015-01-05", "subscriber-basic-info-entry").intern();

    java.lang.Long getSubId();
    
    java.lang.String getFname();
    
    java.lang.String getLname();
    
    java.lang.String getAddress();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    SubscriberBasicInfoEntryKey getKey();

}

