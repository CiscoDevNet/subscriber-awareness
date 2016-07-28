package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.greeting.registry;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.GreetingRegistry;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>subawa</b>
 * <br>(Source path: <i>META-INF/yang/subawa.yang</i>):
 * <pre>
 * list greeting-registry-entry {
 *     key "name"
 *     leaf name {
 *         type string;
 *     }
 *     leaf greeting {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>subawa/greeting-registry/greeting-registry-entry</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.greeting.registry.GreetingRegistryEntryBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.greeting.registry.GreetingRegistryEntryBuilder
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.greeting.registry.GreetingRegistryEntryKey
 *
 */
public interface GreetingRegistryEntry
    extends
    ChildOf<GreetingRegistry>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.greeting.registry.GreetingRegistryEntry>,
    Identifiable<GreetingRegistryEntryKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:subawa",
        "2015-01-05", "greeting-registry-entry").intern();

    java.lang.String getName();
    
    java.lang.String getGreeting();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    GreetingRegistryEntryKey getKey();

}

