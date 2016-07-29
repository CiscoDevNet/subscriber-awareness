package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.impl.rev141210.modules.module.configuration;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.impl.rev141210.modules.module.configuration.subawa.Broker;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.module.Configuration;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>subawa-impl</b>
 * <br>(Source path: <i>META-INF/yang/subawa-impl.yang</i>):
 * <pre>
 * case subawa {
 *     container broker {
 *         leaf type {
 *             type leafref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:subawa:impl?revision=2014-12-10)type {
 *                 leaf type {
 *                     type leafref;
 *                 }
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>subawa-impl/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:subawa:impl?revision=2014-12-10)subawa</i>
 *
 */
public interface Subawa
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.impl.rev141210.modules.module.configuration.Subawa>,
    Configuration
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:subawa:impl",
        "2014-12-10", "subawa").intern();

    Broker getBroker();

}

