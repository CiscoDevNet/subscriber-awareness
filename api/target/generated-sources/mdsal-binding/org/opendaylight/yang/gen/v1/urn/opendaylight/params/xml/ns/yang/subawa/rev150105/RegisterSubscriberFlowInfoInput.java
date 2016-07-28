package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.IpPrefix;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.IpVersion;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput.IpProtocol;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.PortNumber;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>subawa</b>
 * <br>(Source path: <i>META-INF/yang/subawa.yang</i>):
 * <pre>
 * container input {
 *     leaf subId {
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
 *     leaf timeOut {
 *         type uint32;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>subawa/register-subscriber-flow-info/input</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInputBuilder
 *
 */
public interface RegisterSubscriberFlowInfoInput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>
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
        "2015-01-05", "input").intern();

    java.lang.Long getSubId();
    
    IpPrefix getIpSrc();
    
    IpPrefix getIpDst();
    
    PortNumber getPortSrc();
    
    PortNumber getPortDst();
    
    IpVersion getIpVersion();
    
    IpProtocol getIpProtocol();
    
    java.lang.Long getTimeOut();

}

