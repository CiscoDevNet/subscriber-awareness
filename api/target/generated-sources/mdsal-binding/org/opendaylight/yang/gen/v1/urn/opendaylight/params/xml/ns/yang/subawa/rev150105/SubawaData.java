package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105;
import org.opendaylight.yangtools.yang.binding.DataRoot;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>subawa</b>
 * <br>Source path: <i>META-INF/yang/subawa.yang</i>):
 * <pre>
 * module subawa {
 *     yang-version 1;
 *     namespace "urn:opendaylight:params:xml:ns:yang:subawa";
 *     prefix "subawa";
 *
 *     import ietf-yang-types { prefix "yang"; }
 *     
 *     import ietf-inet-types { prefix "inet"; }
 *     revision 2015-01-05 {
 *         description "";
 *     }
 *
 *     container subscriber-flow-info {
 *         list subscriber-flow-info-entry {
 *             key "subId"
 *             leaf subId {
 *                 type uint32;
 *             }
 *             list flow-features {
 *                 key "id"
 *                 leaf id {
 *                     type uint32;
 *                 }
 *                 leaf Ip-Src {
 *                     type ip-prefix;
 *                 }
 *                 leaf Ip-Dst {
 *                     type ip-prefix;
 *                 }
 *                 leaf Port-Src {
 *                     type port-number;
 *                 }
 *                 leaf Port-Dst {
 *                     type port-number;
 *                 }
 *                 leaf Ip-Version {
 *                     type ip-version;
 *                 }
 *                 leaf Ip-Protocol {
 *                     type enumeration;
 *                 }
 *                 leaf Time-Out {
 *                     type uint32;
 *                 }
 *             }
 *         }
 *     }
 *     container nodes-subscriber-info {
 *         list node {
 *             key "nodeId"
 *             leaf nodeId {
 *                 type string;
 *             }
 *             list subscriber {
 *                 key "subId"
 *                 leaf subId {
 *                     type uint32;
 *                 }
 *                 list flow-features {
 *                     key "id"
 *                     leaf id {
 *                         type uint32;
 *                     }
 *                     leaf Ip-Src {
 *                         type ip-prefix;
 *                     }
 *                     leaf Ip-Dst {
 *                         type ip-prefix;
 *                     }
 *                     leaf Port-Src {
 *                         type port-number;
 *                     }
 *                     leaf Port-Dst {
 *                         type port-number;
 *                     }
 *                     leaf Ip-Version {
 *                         type ip-version;
 *                     }
 *                     leaf Ip-Protocol {
 *                         type enumeration;
 *                     }
 *                     leaf count {
 *                         type uint32;
 *                     }
 *                 }
 *             }
 *         }
 *     }
 *     container subscriber-basic-info {
 *         list subscriber-basic-info-entry {
 *             key "subId"
 *             leaf subId {
 *                 type uint32;
 *             }
 *             leaf fname {
 *                 type string;
 *             }
 *             leaf lname {
 *                 type string;
 *             }
 *             leaf address {
 *                 type string;
 *             }
 *         }
 *     }
 *     container greeting-registry {
 *         list greeting-registry-entry {
 *             key "name"
 *             leaf name {
 *                 type string;
 *             }
 *             leaf greeting {
 *                 type string;
 *             }
 *         }
 *     }
 *
 *     rpc hello-world {
 *         input {
 *             leaf name {
 *                 type string;
 *             }
 *             leaf age {
 *                 type uint32;
 *             }
 *         }
 *         
 *         output {
 *             leaf greeting {
 *                 type string;
 *             }
 *         }
 *     }
 *     rpc register-subscriber-flow-info {
 *         "Register subscriber Id and the flow information";
 *         input {
 *             leaf subId {
 *                 type uint32;
 *             }
 *             leaf Ip-Src {
 *                 type ip-prefix;
 *             }
 *             leaf Ip-Dst {
 *                 type ip-prefix;
 *             }
 *             leaf Port-Src {
 *                 type port-number;
 *             }
 *             leaf Port-Dst {
 *                 type port-number;
 *             }
 *             leaf Ip-Version {
 *                 type ip-version;
 *             }
 *             leaf Ip-Protocol {
 *                 type enumeration;
 *             }
 *             leaf timeOut {
 *                 type uint32;
 *             }
 *         }
 *         
 *         output {
 *             leaf result {
 *                 type string;
 *             }
 *         }
 *     }
 *     rpc subscriber-affected {
 *         input {
 *             leaf nodeName {
 *                 type string;
 *             }
 *         }
 *         
 *         output {
 *             leaf-list subscriber-affected {
 *                 type uint32;
 *             }
 *         }
 *     }
 *     rpc register-subscriber-basic-info {
 *         "Register about subscriber Id and other basic information.";
 *         input {
 *             leaf subId {
 *                 type uint32;
 *             }
 *             leaf fname {
 *                 type string;
 *             }
 *             leaf lname {
 *                 type string;
 *             }
 *             leaf address {
 *                 type string;
 *             }
 *         }
 *         
 *         output {
 *             leaf result {
 *                 type string;
 *             }
 *         }
 *     }
 * }
 * </pre>
 *
 */
public interface SubawaData
    extends
    DataRoot
{




    SubscriberFlowInfo getSubscriberFlowInfo();
    
    NodesSubscriberInfo getNodesSubscriberInfo();
    
    SubscriberBasicInfo getSubscriberBasicInfo();
    
    GreetingRegistry getGreetingRegistry();

}

