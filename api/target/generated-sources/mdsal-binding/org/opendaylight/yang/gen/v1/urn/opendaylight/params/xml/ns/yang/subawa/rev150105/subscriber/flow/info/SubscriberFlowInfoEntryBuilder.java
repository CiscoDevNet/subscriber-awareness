package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.subscriber.flow.info.entry.FlowFeatures;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import java.util.List;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry
 *
 */
public class SubscriberFlowInfoEntryBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry> {

    private List<FlowFeatures> _flowFeatures;
    private SubscriberFlowInfoEntryKey _key;
    private java.lang.Long _subId;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry>> augmentation = Collections.emptyMap();

    public SubscriberFlowInfoEntryBuilder() {
    }

    public SubscriberFlowInfoEntryBuilder(SubscriberFlowInfoEntry base) {
        if (base.getKey() == null) {
            this._key = new SubscriberFlowInfoEntryKey(
                base.getSubId()
            );
            this._subId = base.getSubId();
        } else {
            this._key = base.getKey();
            this._subId = _key.getSubId();
        }
        this._flowFeatures = base.getFlowFeatures();
        if (base instanceof SubscriberFlowInfoEntryImpl) {
            SubscriberFlowInfoEntryImpl impl = (SubscriberFlowInfoEntryImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public List<FlowFeatures> getFlowFeatures() {
        return _flowFeatures;
    }
    
    public SubscriberFlowInfoEntryKey getKey() {
        return _key;
    }
    
    public java.lang.Long getSubId() {
        return _subId;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public SubscriberFlowInfoEntryBuilder setFlowFeatures(final List<FlowFeatures> value) {
        this._flowFeatures = value;
        return this;
    }
    
     
    public SubscriberFlowInfoEntryBuilder setKey(final SubscriberFlowInfoEntryKey value) {
        this._key = value;
        return this;
    }
    
     
     private static void checkSubIdRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public SubscriberFlowInfoEntryBuilder setSubId(final java.lang.Long value) {
    if (value != null) {
        checkSubIdRange(value);
    }
        this._subId = value;
        return this;
    }
    
    public SubscriberFlowInfoEntryBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public SubscriberFlowInfoEntryBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public SubscriberFlowInfoEntry build() {
        return new SubscriberFlowInfoEntryImpl(this);
    }

    private static final class SubscriberFlowInfoEntryImpl implements SubscriberFlowInfoEntry {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry.class;
        }

        private final List<FlowFeatures> _flowFeatures;
        private final SubscriberFlowInfoEntryKey _key;
        private final java.lang.Long _subId;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry>> augmentation = Collections.emptyMap();

        private SubscriberFlowInfoEntryImpl(SubscriberFlowInfoEntryBuilder base) {
            if (base.getKey() == null) {
                this._key = new SubscriberFlowInfoEntryKey(
                    base.getSubId()
                );
                this._subId = base.getSubId();
            } else {
                this._key = base.getKey();
                this._subId = _key.getSubId();
            }
            this._flowFeatures = base.getFlowFeatures();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public List<FlowFeatures> getFlowFeatures() {
            return _flowFeatures;
        }
        
        @Override
        public SubscriberFlowInfoEntryKey getKey() {
            return _key;
        }
        
        @Override
        public java.lang.Long getSubId() {
            return _subId;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_flowFeatures);
            result = prime * result + Objects.hashCode(_key);
            result = prime * result + Objects.hashCode(_subId);
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry)obj;
            if (!Objects.equals(_flowFeatures, other.getFlowFeatures())) {
                return false;
            }
            if (!Objects.equals(_key, other.getKey())) {
                return false;
            }
            if (!Objects.equals(_subId, other.getSubId())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                SubscriberFlowInfoEntryImpl otherImpl = (SubscriberFlowInfoEntryImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.flow.info.SubscriberFlowInfoEntry>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("SubscriberFlowInfoEntry [");
            boolean first = true;
        
            if (_flowFeatures != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_flowFeatures=");
                builder.append(_flowFeatures);
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
            if (_subId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_subId=");
                builder.append(_subId);
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
