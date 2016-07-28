package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Objects;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry
 *
 */
public class SubscriberBasicInfoEntryBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry> {

    private java.lang.String _address;
    private java.lang.String _fname;
    private SubscriberBasicInfoEntryKey _key;
    private java.lang.String _lname;
    private java.lang.Long _subId;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>> augmentation = Collections.emptyMap();

    public SubscriberBasicInfoEntryBuilder() {
    }

    public SubscriberBasicInfoEntryBuilder(SubscriberBasicInfoEntry base) {
        if (base.getKey() == null) {
            this._key = new SubscriberBasicInfoEntryKey(
                base.getSubId()
            );
            this._subId = base.getSubId();
        } else {
            this._key = base.getKey();
            this._subId = _key.getSubId();
        }
        this._address = base.getAddress();
        this._fname = base.getFname();
        this._lname = base.getLname();
        if (base instanceof SubscriberBasicInfoEntryImpl) {
            SubscriberBasicInfoEntryImpl impl = (SubscriberBasicInfoEntryImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.String getAddress() {
        return _address;
    }
    
    public java.lang.String getFname() {
        return _fname;
    }
    
    public SubscriberBasicInfoEntryKey getKey() {
        return _key;
    }
    
    public java.lang.String getLname() {
        return _lname;
    }
    
    public java.lang.Long getSubId() {
        return _subId;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
    public SubscriberBasicInfoEntryBuilder setAddress(final java.lang.String value) {
        this._address = value;
        return this;
    }
    
     
    public SubscriberBasicInfoEntryBuilder setFname(final java.lang.String value) {
        this._fname = value;
        return this;
    }
    
     
    public SubscriberBasicInfoEntryBuilder setKey(final SubscriberBasicInfoEntryKey value) {
        this._key = value;
        return this;
    }
    
     
    public SubscriberBasicInfoEntryBuilder setLname(final java.lang.String value) {
        this._lname = value;
        return this;
    }
    
     
     private static void checkSubIdRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public SubscriberBasicInfoEntryBuilder setSubId(final java.lang.Long value) {
    if (value != null) {
        checkSubIdRange(value);
    }
        this._subId = value;
        return this;
    }
    
    public SubscriberBasicInfoEntryBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public SubscriberBasicInfoEntryBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public SubscriberBasicInfoEntry build() {
        return new SubscriberBasicInfoEntryImpl(this);
    }

    private static final class SubscriberBasicInfoEntryImpl implements SubscriberBasicInfoEntry {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry.class;
        }

        private final java.lang.String _address;
        private final java.lang.String _fname;
        private final SubscriberBasicInfoEntryKey _key;
        private final java.lang.String _lname;
        private final java.lang.Long _subId;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>> augmentation = Collections.emptyMap();

        private SubscriberBasicInfoEntryImpl(SubscriberBasicInfoEntryBuilder base) {
            if (base.getKey() == null) {
                this._key = new SubscriberBasicInfoEntryKey(
                    base.getSubId()
                );
                this._subId = base.getSubId();
            } else {
                this._key = base.getKey();
                this._subId = _key.getSubId();
            }
            this._address = base.getAddress();
            this._fname = base.getFname();
            this._lname = base.getLname();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.String getAddress() {
            return _address;
        }
        
        @Override
        public java.lang.String getFname() {
            return _fname;
        }
        
        @Override
        public SubscriberBasicInfoEntryKey getKey() {
            return _key;
        }
        
        @Override
        public java.lang.String getLname() {
            return _lname;
        }
        
        @Override
        public java.lang.Long getSubId() {
            return _subId;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + Objects.hashCode(_address);
            result = prime * result + Objects.hashCode(_fname);
            result = prime * result + Objects.hashCode(_key);
            result = prime * result + Objects.hashCode(_lname);
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry)obj;
            if (!Objects.equals(_address, other.getAddress())) {
                return false;
            }
            if (!Objects.equals(_fname, other.getFname())) {
                return false;
            }
            if (!Objects.equals(_key, other.getKey())) {
                return false;
            }
            if (!Objects.equals(_lname, other.getLname())) {
                return false;
            }
            if (!Objects.equals(_subId, other.getSubId())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                SubscriberBasicInfoEntryImpl otherImpl = (SubscriberBasicInfoEntryImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.subscriber.basic.info.SubscriberBasicInfoEntry>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("SubscriberBasicInfoEntry [");
            boolean first = true;
        
            if (_address != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_address=");
                builder.append(_address);
             }
            if (_fname != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_fname=");
                builder.append(_fname);
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
            if (_lname != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_lname=");
                builder.append(_lname);
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
