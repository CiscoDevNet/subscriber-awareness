# OpenDaylight Subscriber-Awareness Project
 
<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17063168/d6ce19a6-4fea-11e6-963c-289cafd9e7aa.png" width="200" height="200"/>
</p>
OpenDaylight (ODL) is an open source application development and delivery platform (also referred to as a controller for software defined network (SDN)). By uniting the industry around a common SDN platform, the ODL community is helping to make interoperable, programmable networks a reality.

## Team
* Alon Bernstein  
* Chuanji (Jenny) Zhang  

## Problem Statement

<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17420529/16576fd8-5a58-11e6-8388-c4f3a9593b5f.png" height="250"/>
</p>
*Figure 1. TMN model*

When a new flow comes into the network, how can we associate it to its subscriber?  

In the Telecommunication Management Network (TMN) Model shown in Figure 1., the subscriber awareness fades away as the layer goes down, which means that the element management layer may have no idea who is the subscriber of the flow while the business management layer has all the subscriber knowledge. 

The role of ODL platform corresponds to the element management layer in an SDN network. Currently, ODL is flow-aware and device-aware, but not subscriber-aware. We add the subscriber awarenss to the ODL platform to enable the association between flow, subscriber, device, and service. The association hierarchy is shown in Figure 2. Flows, device, subscriber, and service instance can point to each other (not limited to the hierarchy). The association to the service instance can be implemented in the future easily based on our project architecture.
<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17425652/aa0155f6-5a84-11e6-81e8-99a642c3f399.png" height="250"/>
</p>
*Figure 2. Association Hierarchy*  




## Core Technology
### Subscriber, Flow, and Device Association
<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17424816/5c67533e-5a7c-11e6-9a81-2b0ca02f82ad.png" height="250"/>
</p>
*Figure 3. Core Teclnology*  

The core technology of our project is the process to link the subscriber in the system database with flow, device, and service instance in ODL. The subscriber information and its flow features can be provided by the home gateway, application, softphone, application network signaling to the ODL controller. The flow features will be put in the match field, and the corresponding flowId will be stored with the subId. When the flow comes to the network, the southbound plugin will return the incoming infrastructure devices and byte count (optional for certain use cases). The logic flow diagram is shown in Figure 4. The Openflow switch is chosen here since it is easy to simulate using Mininet. 
<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17425757/f0593252-5a85-11e6-9004-12120b74f027.png" height="250"/>
</p>
*Figure 4. Logic Flow Diagram* 

### DOCSIS Flow
DOCSIS flow is handled by Packet Cable MultiMedia (PCMM) in ODL. It provides an interface to control and manage service flow for CMTS network elements. The gateId of the service flows in PCMM can be used to store with the subId to enable the flow-subscriber association.

## Use Cases
*	QoS Operation: Based on the subscriber information, QoS adjustment can be performed on the flows. 
* Location tracking: When wifi subscribers roaming across access points, their location can be tracked based on the node (access points) they connected to.  
*	Quality tracking: If a node (AP, router, etc.) fails, the subscribers and flows affected are immediately known. 
*	Security Issue: For some security service, only flows from qualified subscriber can be routed. 
*	Handover Tracking: When a subscriber move from different network, the status can be tracked.


## Graphical User Interface (GUI) Design
Figure 5 shows the user interface to view the current network topology and add new subscriber information to the system.
<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17070892/4be4f566-5013-11e6-9ec9-4b732821e6c7.PNG" height="350"/>
</p>
*Figure.5 Add Subscriber Panel*

Figure 6 shows the flow statistics in the system.
<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17072963/5a4b9584-5021-11e6-8bae-e510ad94224c.PNG" height="350" />
</p>
*Figure.6 Statistics Panel*

Figure 7 shows the current subscribers in the systems and the impacted subscribers due to a node down incident.
<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17072338/48e022e2-501c-11e6-8f4a-458c5dee6207.PNG" height="350"/>
</p>
*Figure.7 Impacted Subscriber Panel*


## REST Calls
Here are the basic REST calls used for the project.
* **Add new subscriber basic information**

```
  POST http://<controller-addr>:8181/restconf/operations/subawa:register-subscriber-basic-info  
  {  
     "input": {  
        "subId": 1;  
        "fname": "Alex";  
        "lname": "Smith";  
        "address": "Cisco Bldg. 6"  
      }  
  }  
```
* **Add new subscriber flow information**
```
  POST http://<controller-addr>:8181/restconf/operations/subawa:register-subscriber-flow-info
  {
      "input": {
         "subId": 1;
         "Ip-Src":"10.0.0.1/32";
         "Ip-Dst":"10.0.0.3/32";
         "Port-Src": 183;
         "Port-Dst":8080;
         "Ip-Version":ipv4;
         "Ip-Protocol":TCP;
         "timeOut":100
      }
  }
```
* **Get subscriber information in the system**
```
  GET http://<controller-addr>:8181/restconf/operational/subawa:subscriber-flow-info
```
* **Get the flow statistics (byte count) for each subscriber**
```
  GET http://<controller-addr>:8181/restconf/operational/subawa:nodes-subscriber-info
```
* **Notify the impacted subscriber when a node is broken**
```
  POST http://<controller-addr>:8181/restconf/operations/subawa:subscriber-affected
  {
      "input": {
         "nodeName": "node:1"
      }
  }
```
