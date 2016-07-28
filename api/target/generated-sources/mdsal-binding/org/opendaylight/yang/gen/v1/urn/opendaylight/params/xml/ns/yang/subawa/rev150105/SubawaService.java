package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105;
import org.opendaylight.yangtools.yang.binding.RpcService;
import org.opendaylight.yangtools.yang.common.RpcResult;
import java.util.concurrent.Future;


/**
 * Interface for implementing the following YANG RPCs defined in module <b>subawa</b>
 * <br>(Source path: <i>META-INF/yang/subawa.yang</i>):
 * <pre>
 * rpc hello-world {
 *     input {
 *         leaf name {
 *             type string;
 *         }
 *         leaf age {
 *             type uint32;
 *         }
 *     }
 *     
 *     output {
 *         leaf greeting {
 *             type string;
 *         }
 *     }
 * }
 * rpc register-subscriber-flow-info {
 *     "Register subscriber Id and the flow information";
 *     input {
 *         leaf subId {
 *             type uint32;
 *         }
 *         leaf Ip-Src {
 *             type ip-prefix;
 *         }
 *         leaf Ip-Dst {
 *             type ip-prefix;
 *         }
 *         leaf Port-Src {
 *             type port-number;
 *         }
 *         leaf Port-Dst {
 *             type port-number;
 *         }
 *         leaf Ip-Version {
 *             type ip-version;
 *         }
 *         leaf Ip-Protocol {
 *             type enumeration;
 *         }
 *         leaf timeOut {
 *             type uint32;
 *         }
 *     }
 *     
 *     output {
 *         leaf result {
 *             type string;
 *         }
 *     }
 * }
 * rpc subscriber-affected {
 *     input {
 *         leaf nodeName {
 *             type string;
 *         }
 *     }
 *     
 *     output {
 *         leaf-list subscriber-affected {
 *             type uint32;
 *         }
 *     }
 * }
 * rpc register-subscriber-basic-info {
 *     "Register about subscriber Id and other basic information.";
 *     input {
 *         leaf subId {
 *             type uint32;
 *         }
 *         leaf fname {
 *             type string;
 *         }
 *         leaf lname {
 *             type string;
 *         }
 *         leaf address {
 *             type string;
 *         }
 *     }
 *     
 *     output {
 *         leaf result {
 *             type string;
 *         }
 *     }
 * }
 * </pre>
 *
 */
public interface SubawaService
    extends
    RpcService
{




    Future<RpcResult<HelloWorldOutput>> helloWorld(HelloWorldInput input);
    
    /**
     * Register subscriber Id and the flow information
     *
     */
    Future<RpcResult<RegisterSubscriberFlowInfoOutput>> registerSubscriberFlowInfo(RegisterSubscriberFlowInfoInput input);
    
    Future<RpcResult<SubscriberAffectedOutput>> subscriberAffected(SubscriberAffectedInput input);
    
    /**
     * Register about subscriber Id and other basic information.
     *
     */
    Future<RpcResult<RegisterSubscriberBasicInfoOutput>> registerSubscriberBasicInfo(RegisterSubscriberBasicInfoInput input);

}

