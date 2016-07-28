package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.IpPrefix;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.IpVersion;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput.IpProtocol;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.PortNumber;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput
 *
 */
public class RegisterSubscriberFlowInfoInputBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput> {

    private IpPrefix _ipDst;
    private IpProtocol _ipProtocol;
    private IpPrefix _ipSrc;
    private IpVersion _ipVersion;
    private PortNumber _portDst;
    private PortNumber _portSrc;
    private java.lang.Long _subId;
    private java.lang.Long _timeOut;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>> augmentation = Collections.emptyMap();

    public RegisterSubscriberFlowInfoInputBuilder() {
    }

    public RegisterSubscriberFlowInfoInputBuilder(RegisterSubscriberFlowInfoInput base) {
        this._ipDst = base.getIpDst();
        this._ipProtocol = base.getIpProtocol();
        this._ipSrc = base.getIpSrc();
        this._ipVersion = base.getIpVersion();
        this._portDst = base.getPortDst();
        this._portSrc = base.getPortSrc();
        this._subId = base.getSubId();
        this._timeOut = base.getTimeOut();
        if (base instanceof RegisterSubscriberFlowInfoInputImpl) {
            RegisterSubscriberFlowInfoInputImpl impl = (RegisterSubscriberFlowInfoInputImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public IpPrefix getIpDst() {
        return _ipDst;
    }
    
    public IpProtocol getIpProtocol() {
        return _ipProtocol;
    }
    
    public IpPrefix getIpSrc() {
        return _ipSrc;
    }
    
    public IpVersion getIpVersion() {
        return _ipVersion;
    }
    
    public PortNumber getPortDst() {
        return _portDst;
    }
    
    public PortNumber getPortSrc() {
        return _portSrc;
    }
    
    public java.lang.Long getSubId() {
        return _subId;
    }
    
    public java.lang.Long getTimeOut() {
        return _timeOut;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public RegisterSubscriberFlowInfoInputBuilder setIpDst(final IpPrefix value) {
        this._ipDst = value;
        return this;
    }
    
     
    public RegisterSubscriberFlowInfoInputBuilder setIpProtocol(final IpProtocol value) {
        this._ipProtocol = value;
        return this;
    }
    
     
    public RegisterSubscriberFlowInfoInputBuilder setIpSrc(final IpPrefix value) {
        this._ipSrc = value;
        return this;
    }
    
     
    public RegisterSubscriberFlowInfoInputBuilder setIpVersion(final IpVersion value) {
        this._ipVersion = value;
        return this;
    }
    
     
    public RegisterSubscriberFlowInfoInputBuilder setPortDst(final PortNumber value) {
        this._portDst = value;
        return this;
    }
    
     
    public RegisterSubscriberFlowInfoInputBuilder setPortSrc(final PortNumber value) {
        this._portSrc = value;
        return this;
    }
    
     
     private static void checkSubIdRange(final long value) {
         if (value >= 1L && value <= 65535L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[1‥65535]].", value));
     }
    
    public RegisterSubscriberFlowInfoInputBuilder setSubId(final java.lang.Long value) {
    if (value != null) {
        checkSubIdRange(value);
    }
        this._subId = value;
        return this;
    }
    
     
     private static void checkTimeOutRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public RegisterSubscriberFlowInfoInputBuilder setTimeOut(final java.lang.Long value) {
    if (value != null) {
        checkTimeOutRange(value);
    }
        this._timeOut = value;
        return this;
    }
    
    public RegisterSubscriberFlowInfoInputBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public RegisterSubscriberFlowInfoInputBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public RegisterSubscriberFlowInfoInput build() {
        return new RegisterSubscriberFlowInfoInputImpl(this);
    }

    private static final class RegisterSubscriberFlowInfoInputImpl implements RegisterSubscriberFlowInfoInput {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput.class;
        }

        private final IpPrefix _ipDst;
        private final IpProtocol _ipProtocol;
        private final IpPrefix _ipSrc;
        private final IpVersion _ipVersion;
        private final PortNumber _portDst;
        private final PortNumber _portSrc;
        private final java.lang.Long _subId;
        private final java.lang.Long _timeOut;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>> augmentation = Collections.emptyMap();

        private RegisterSubscriberFlowInfoInputImpl(RegisterSubscriberFlowInfoInputBuilder base) {
            this._ipDst = base.getIpDst();
            this._ipProtocol = base.getIpProtocol();
            this._ipSrc = base.getIpSrc();
            this._ipVersion = base.getIpVersion();
            this._portDst = base.getPortDst();
            this._portSrc = base.getPortSrc();
            this._subId = base.getSubId();
            this._timeOut = base.getTimeOut();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public IpPrefix getIpDst() {
            return _ipDst;
        }
        
        @Override
        public IpProtocol getIpProtocol() {
            return _ipProtocol;
        }
        
        @Override
        public IpPrefix getIpSrc() {
            return _ipSrc;
        }
        
        @Override
        public IpVersion getIpVersion() {
            return _ipVersion;
        }
        
        @Override
        public PortNumber getPortDst() {
            return _portDst;
        }
        
        @Override
        public PortNumber getPortSrc() {
            return _portSrc;
        }
        
        @Override
        public java.lang.Long getSubId() {
            return _subId;
        }
        
        @Override
        public java.lang.Long getTimeOut() {
            return _timeOut;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        private int hash = 0;
        private volatile boolean hashValid = false;
        
        @Override
        public int hashCode() {
            if (hashValid) {
                return hash;
            }
        
            final int prime = 31;
            int result = 1;
            result = prime * result + Objects.hashCode(_ipDst);
            result = prime * result + Objects.hashCode(_ipProtocol);
            result = prime * result + Objects.hashCode(_ipSrc);
            result = prime * result + Objects.hashCode(_ipVersion);
            result = prime * result + Objects.hashCode(_portDst);
            result = prime * result + Objects.hashCode(_portSrc);
            result = prime * result + Objects.hashCode(_subId);
            result = prime * result + Objects.hashCode(_timeOut);
            result = prime * result + Objects.hashCode(augmentation);
        
            hash = result;
            hashValid = true;
            return result;
        }

        @Override
        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DataObject)) {
                return false;
            }
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput)obj;
            if (!Objects.equals(_ipDst, other.getIpDst())) {
                return false;
            }
            if (!Objects.equals(_ipProtocol, other.getIpProtocol())) {
                return false;
            }
            if (!Objects.equals(_ipSrc, other.getIpSrc())) {
                return false;
            }
            if (!Objects.equals(_ipVersion, other.getIpVersion())) {
                return false;
            }
            if (!Objects.equals(_portDst, other.getPortDst())) {
                return false;
            }
            if (!Objects.equals(_portSrc, other.getPortSrc())) {
                return false;
            }
            if (!Objects.equals(_subId, other.getSubId())) {
                return false;
            }
            if (!Objects.equals(_timeOut, other.getTimeOut())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                RegisterSubscriberFlowInfoInputImpl otherImpl = (RegisterSubscriberFlowInfoInputImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.RegisterSubscriberFlowInfoInput>> e : augmentation.entrySet()) {
                    if (!e.getValue().equals(other.getAugmentation(e.getKey()))) {
                        return false;
                    }
                }
                // .. and give the other one the chance to do the same
                if (!obj.equals(this)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("RegisterSubscriberFlowInfoInput [");
            boolean first = true;
        
            if (_ipDst != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ipDst=");
                builder.append(_ipDst);
             }
            if (_ipProtocol != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ipProtocol=");
                builder.append(_ipProtocol);
             }
            if (_ipSrc != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ipSrc=");
                builder.append(_ipSrc);
             }
            if (_ipVersion != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ipVersion=");
                builder.append(_ipVersion);
             }
            if (_portDst != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_portDst=");
                builder.append(_portDst);
             }
            if (_portSrc != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_portSrc=");
                builder.append(_portSrc);
             }
            if (_subId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_subId=");
                builder.append(_subId);
             }
            if (_timeOut != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_timeOut=");
                builder.append(_timeOut);
             }
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("augmentation=");
            builder.append(augmentation.values());
            return builder.append(']').toString();
        }
    }

}
