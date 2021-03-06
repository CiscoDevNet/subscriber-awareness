package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node;
import org.opendaylight.yangtools.yang.binding.Identifier;
import java.util.Objects;


public class SubscriberKey
 implements Identifier<Subscriber> {
    private static final long serialVersionUID = -2536779395700859024L;
    private final java.lang.Long _subId;


    public SubscriberKey(java.lang.Long _subId) {
    
    
        this._subId = _subId;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public SubscriberKey(SubscriberKey source) {
        this._subId = source._subId;
    }


    public java.lang.Long getSubId() {
        return _subId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(_subId);
        return result;
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SubscriberKey other = (SubscriberKey) obj;
        if (!Objects.equals(_subId, other._subId)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.node.SubscriberKey.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_subId != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_subId=");
            builder.append(_subId);
         }
        return builder.append(']').toString();
    }
}

