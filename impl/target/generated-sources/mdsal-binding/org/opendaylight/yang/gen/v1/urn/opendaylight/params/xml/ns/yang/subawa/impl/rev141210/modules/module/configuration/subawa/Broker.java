package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.impl.rev141210.modules.module.configuration.subawa;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.Module;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.ServiceRef;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>subawa-impl</b>
 * <br>(Source path: <i>META-INF/yang/subawa-impl.yang</i>):
 * <pre>
 * container broker {
 *     leaf type {
 *         type leafref;
 *     }
 *     leaf name {
 *         type leafref;
 *     }
 *     uses service-ref {
 *         refine (urn:opendaylight:params:xml:ns:yang:subawa:impl?revision=2014-12-10)type {
 *             leaf type {
 *                 type leafref;
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>subawa-impl/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:subawa:impl?revision=2014-12-10)subawa/broker</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.impl.rev141210.modules.module.configuration.subawa.BrokerBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.impl.rev141210.modules.module.configuration.subawa.BrokerBuilder
 *
 */
public interface Broker
    extends
    ChildOf<Module>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.impl.rev141210.modules.module.configuration.subawa.Broker>,
    ServiceRef
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:subawa:impl",
        "2014-12-10", "broker").intern();


}

