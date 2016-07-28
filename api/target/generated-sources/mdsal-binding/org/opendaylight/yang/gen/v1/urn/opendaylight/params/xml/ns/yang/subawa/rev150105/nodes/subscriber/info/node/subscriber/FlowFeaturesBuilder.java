package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.IpVersion;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.IpPrefix;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.Objects;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures.IpProtocol;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.PortNumber;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures
 *
 */
public class FlowFeaturesBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures> {

    private java.lang.Long _count;
    private java.lang.Long _id;
    private IpPrefix _ipDst;
    private IpProtocol _ipProtocol;
    private IpPrefix _ipSrc;
    private IpVersion _ipVersion;
    private FlowFeaturesKey _key;
    private PortNumber _portDst;
    private PortNumber _portSrc;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>> augmentation = Collections.emptyMap();

    public FlowFeaturesBuilder() {
    }

    public FlowFeaturesBuilder(FlowFeatures base) {
        if (base.getKey() == null) {
            this._key = new FlowFeaturesKey(
                base.getId()
            );
            this._id = base.getId();
        } else {
            this._key = base.getKey();
            this._id = _key.getId();
        }
        this._count = base.getCount();
        this._ipDst = base.getIpDst();
        this._ipProtocol = base.getIpProtocol();
        this._ipSrc = base.getIpSrc();
        this._ipVersion = base.getIpVersion();
        this._portDst = base.getPortDst();
        this._portSrc = base.getPortSrc();
        if (base instanceof FlowFeaturesImpl) {
            FlowFeaturesImpl impl = (FlowFeaturesImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.Long getCount() {
        return _count;
    }
    
    public java.lang.Long getId() {
        return _id;
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
    
    public FlowFeaturesKey getKey() {
        return _key;
    }
    
    public PortNumber getPortDst() {
        return _portDst;
    }
    
    public PortNumber getPortSrc() {
        return _portSrc;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
     private static void checkCountRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public FlowFeaturesBuilder setCount(final java.lang.Long value) {
    if (value != null) {
        checkCountRange(value);
    }
        this._count = value;
        return this;
    }
    
     
     private static void checkIdRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public FlowFeaturesBuilder setId(final java.lang.Long value) {
    if (value != null) {
        checkIdRange(value);
    }
        this._id = value;
        return this;
    }
    
     
    public FlowFeaturesBuilder setIpDst(final IpPrefix value) {
        this._ipDst = value;
        return this;
    }
    
     
    public FlowFeaturesBuilder setIpProtocol(final IpProtocol value) {
        this._ipProtocol = value;
        return this;
    }
    
     
    public FlowFeaturesBuilder setIpSrc(final IpPrefix value) {
        this._ipSrc = value;
        return this;
    }
    
     
    public FlowFeaturesBuilder setIpVersion(final IpVersion value) {
        this._ipVersion = value;
        return this;
    }
    
     
    public FlowFeaturesBuilder setKey(final FlowFeaturesKey value) {
        this._key = value;
        return this;
    }
    
     
    public FlowFeaturesBuilder setPortDst(final PortNumber value) {
        this._portDst = value;
        return this;
    }
    
     
    public FlowFeaturesBuilder setPortSrc(final PortNumber value) {
        this._portSrc = value;
        return this;
    }
    
    public FlowFeaturesBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public FlowFeaturesBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public FlowFeatures build() {
        return new FlowFeaturesImpl(this);
    }

    private static final class FlowFeaturesImpl implements FlowFeatures {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures.class;
        }

        private final java.lang.Long _count;
        private final java.lang.Long _id;
        private final IpPrefix _ipDst;
        private final IpProtocol _ipProtocol;
        private final IpPrefix _ipSrc;
        private final IpVersion _ipVersion;
        private final FlowFeaturesKey _key;
        private final PortNumber _portDst;
        private final PortNumber _portSrc;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>> augmentation = Collections.emptyMap();

        private FlowFeaturesImpl(FlowFeaturesBuilder base) {
            if (base.getKey() == null) {
                this._key = new FlowFeaturesKey(
                    base.getId()
                );
                this._id = base.getId();
            } else {
                this._key = base.getKey();
                this._id = _key.getId();
            }
            this._count = base.getCount();
            this._ipDst = base.getIpDst();
            this._ipProtocol = base.getIpProtocol();
            this._ipSrc = base.getIpSrc();
            this._ipVersion = base.getIpVersion();
            this._portDst = base.getPortDst();
            this._portSrc = base.getPortSrc();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.Long getCount() {
            return _count;
        }
        
        @Override
        public java.lang.Long getId() {
            return _id;
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
        public FlowFeaturesKey getKey() {
            return _key;
        }
        
        @Override
        public PortNumber getPortDst() {
            return _portDst;
        }
        
        @Override
        public PortNumber getPortSrc() {
            return _portSrc;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_count);
            result = prime * result + Objects.hashCode(_id);
            result = prime * result + Objects.hashCode(_ipDst);
            result = prime * result + Objects.hashCode(_ipProtocol);
            result = prime * result + Objects.hashCode(_ipSrc);
            result = prime * result + Objects.hashCode(_ipVersion);
            result = prime * result + Objects.hashCode(_key);
            result = prime * result + Objects.hashCode(_portDst);
            result = prime * result + Objects.hashCode(_portSrc);
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures)obj;
            if (!Objects.equals(_count, other.getCount())) {
                return false;
            }
            if (!Objects.equals(_id, other.getId())) {
                return false;
            }
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
            if (!Objects.equals(_key, other.getKey())) {
                return false;
            }
            if (!Objects.equals(_portDst, other.getPortDst())) {
                return false;
            }
            if (!Objects.equals(_portSrc, other.getPortSrc())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                FlowFeaturesImpl otherImpl = (FlowFeaturesImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.subscriber.FlowFeatures>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("FlowFeatures [");
            boolean first = true;
        
            if (_count != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_count=");
                builder.append(_count);
             }
            if (_id != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_id=");
                builder.append(_id);
             }
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
            if (_key != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_key=");
                builder.append(_key);
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
