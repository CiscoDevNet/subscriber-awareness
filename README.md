# OpenDaylight Subscriber-Awareness Project
 
<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17063168/d6ce19a6-4fea-11e6-963c-289cafd9e7aa.png" width="200" height="200"/>
</p>
OpenDaylight (ODL) is an open source application development and delivery platform (also referred to as a controller for software defined network (SDN)). By uniting the industry around a common SDN platform, the ODL community is helping to make interoperable, programmable networks a reality.

## Problem Statement
<p align="left">
  <img src="https://cloud.githubusercontent.com/assets/15353120/17063505/8019d620-4fec-11e6-9663-a53c4d235f7e.png" height="150"/>
</p>
The problem we are targeting is that when a new flow comes into the network, how can we associate it to its subscriber?

## Our Solution
The current ODL platform is flow-aware and device-aware, but not subscriber-aware. We add the subscriber awarenss to the ODL platform to enable the association between flow, subscriber, device, and service.

## Graphical User Interface (GUI)

## REST Calls
* **Add new subscriber basic information**

  ```
  POST http://<controller-addr>:8080/restconf/operations/subawa:register-subscriber-basic-info  
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
POST http://<controller-addr>:8080/restconf/operations/subawa:register-subscriber-flow-info
{
    "input": {
        "subId": 1;
        "Ip-Src":"10.0.0.1/32";
        "Ip-Dst":"10.0.0.3/32";
        "Port-Src": 183;
        "Port-Dst":8080;
        "Ip-Version":ipv4;
        "Ip-Protocol":TCP;
        "timeOut":2000
    }
}
```
* **Get subscriber information in the system**
```
GET http://<controller-addr>:8080/restconf/operational/subawa:subscriber-flow-info
```
* **Get the flow byte count for each subscriber**
```
GET http://<controller-addr>:8181/restconf/operational/subawa:nodes-subscriber-info
```
* **Get notified about the impacted subscriber when a node is broken**
```
POST http://<controller-addr>:8080/restconf/operations/subawa:subscriber-affected
{
    "input": {
        "nodeName": "node:1"
    }
}
```
