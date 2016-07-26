# OpenDaylight Subscriber-Awareness Project
 
<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17063168/d6ce19a6-4fea-11e6-963c-289cafd9e7aa.png" width="200" height="200"/>
</p>
OpenDaylight (ODL) is an open source application development and delivery platform (also referred to as a controller for software defined network (SDN)). By uniting the industry around a common SDN platform, the ODL community is helping to make interoperable, programmable networks a reality.

## Problem Statement
<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17064860/941333a4-4ff3-11e6-9d59-ffcca45a2310.png" height="150"/>
</p>
*Figure 1. Targeting Problem*

Figure 1 shows the problem we are targeting at: when a new flow comes into the network, how can we associate it to its subscriber.

## Our Solution
<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17064874/a4928aa4-4ff3-11e6-839a-60fb91cb7c26.png" height="150"/>
</p>
*Figure 2. Proposed Solution*

The current ODL platform is flow-aware and device-aware, but not subscriber-aware. We add the subscriber awarenss to the ODL platform to enable the association between flow, subscriber, device, and service.

## Use Cases
*	QoS Operation: Based on the subscriber information, QoS adjustment can be performed on the flows. 
* Location tracking: When wifi subscribers roaming across access points, their location can be tracked based on the node (access points) they connected to.  
*	Quality tracking: If a node (AP, router, etc.) fails, the subscribers and flows affected are immediately known. 
*	Security Issue: For some security service, only flows from qualified subscriber can be routed. 


## Graphical User Interface (GUI) Design
Figure 3 shows the user interface to view the current network topology and add new subscriber information to the system.
<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17070892/4be4f566-5013-11e6-9ec9-4b732821e6c7.PNG" height="350"/>
</p>
*Figure.3 Add Subscriber Panel*

Figure 4 shows the flow statistics in the system.
<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17072963/5a4b9584-5021-11e6-8bae-e510ad94224c.PNG" height="350" />
</p>
*Figure.4 Statistics Panel*

Figure 5 shows the current subscribers in the systems and the impacted subscribers due to a node down incident.
<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17072338/48e022e2-501c-11e6-8f4a-458c5dee6207.PNG" height="350"/>
</p>
*Figure.5 Impacted Subscriber Panel*


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
