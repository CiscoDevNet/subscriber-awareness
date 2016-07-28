package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>subawa</b>
 * <br>(Source path: <i>META-INF/yang/subawa.yang</i>):
 * <pre>
 * container output {
 *     leaf result {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>subawa/register-subscriber-flow-info/output</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoOutputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoOutputBuilder
 *
 */
public interface RegisterSubscriberFlowInfoOutput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoOutput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:subawa",
        "2015-01-05", "output").intern();

    java.lang.String getResult();

}

