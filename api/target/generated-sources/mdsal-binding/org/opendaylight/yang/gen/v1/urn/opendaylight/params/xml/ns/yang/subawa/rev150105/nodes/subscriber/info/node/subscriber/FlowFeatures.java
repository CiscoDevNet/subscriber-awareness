package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.IpPrefix;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.Subscriber;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.IpVersion;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures.IpProtocol;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.PortNumber;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>subawa</b>
 * <br>(Source path: <i>META-INF/yang/subawa.yang</i>):
 * <pre>
 * list flow-features {
 *     key "id"
 *     leaf id {
 *         type uint32;
 *     }
 *     leaf Ip-Src {
 *         type ip-prefix;
 *     }
 *     leaf Ip-Dst {
 *         type ip-prefix;
 *     }
 *     leaf Port-Src {
 *         type port-number;
 *     }
 *     leaf Port-Dst {
 *         type port-number;
 *     }
 *     leaf Ip-Version {
 *         type ip-version;
 *     }
 *     leaf Ip-Protocol {
 *         type enumeration;
 *     }
 *     leaf count {
 *         type uint32;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>subawa/nodes-subscriber-info/node/subscriber/flow-features</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeaturesBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeaturesBuilder
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeaturesKey
 *
 */
public interface FlowFeatures
    extends
    ChildOf<Subscriber>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>,
    Identifiable<FlowFeaturesKey>
{


    public enum IpProtocol {
        /**
         * TCP Protocol
         *
         */
        TCP(6),
        
        /**
         * UDP Protocol
         *
         */
        UDP(17)
        ;
    
    
        int value;
        private static final java.util.Map<java.lang.Integer, IpProtocol> VALUE_MAP;
    
        static {
            final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, IpProtocol> b = com.google.common.collect.ImmutableMap.builder();
            for (IpProtocol enumItem : IpProtocol.values())
            {
                b.put(enumItem.value, enumItem);
            }
    
            VALUE_MAP = b.build();
        }
    
        private IpProtocol(int value) {
            this.value = value;
        }
    
        /**
         * @return integer value
         */
        public int getIntValue() {
            return value;
        }
    
        /**
         * @param valueArg
         * @return corresponding IpProtocol item
         */
        public static IpProtocol forValue(int valueArg) {
            return VALUE_MAP.get(valueArg);
        }
    }

    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:subawa",
        "2015-01-05", "flow-features").intern();

    java.lang.Long getId();
    
    IpPrefix getIpSrc();
    
    IpPrefix getIpDst();
    
    PortNumber getPortSrc();
    
    PortNumber getPortDst();
    
    IpVersion getIpVersion();
    
    IpProtocol getIpProtocol();
    
    java.lang.Long getCount();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    FlowFeaturesKey getKey();

}

