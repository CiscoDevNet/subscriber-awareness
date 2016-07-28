package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info;
import org.opendaylight.yangtools.yang.binding.Identifier;
import java.util.Objects;


public class NodeKey
 implements Identifier<Node> {
    private static final long serialVersionUID = -981934742417623433L;
    private final java.lang.String _nodeId;


    public NodeKey(java.lang.String _nodeId) {
    
    
        this._nodeId = _nodeId;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public NodeKey(NodeKey source) {
        this._nodeId = source._nodeId;
    }


    public java.lang.String getNodeId() {
        return _nodeId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(_nodeId);
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
        NodeKey other = (NodeKey) obj;
        if (!Objects.equals(_nodeId, other._nodeId)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.nodes.subscriber.info.NodeKey.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_nodeId != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_nodeId=");
            builder.append(_nodeId);
         }
        return builder.append(']').toString();
    }
}

