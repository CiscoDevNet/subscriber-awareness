package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>subawa</b>
 * <br>(Source path: <i>META-INF/yang/subawa.yang</i>):
 * <pre>
 * container input {
 *     leaf nodeName {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>subawa/subscriber-affected/input</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.SubscriberAffectedInputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.SubscriberAffectedInputBuilder
 *
 */
public interface SubscriberAffectedInput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.SubscriberAffectedInput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:subawa",
        "2015-01-05", "input").intern();

    java.lang.String getNodeName();

}

