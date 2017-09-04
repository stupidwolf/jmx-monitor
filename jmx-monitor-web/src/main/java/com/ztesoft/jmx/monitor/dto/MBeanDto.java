package com.ztesoft.jmx.monitor.dto;

public class MBeanDto {
    private Integer domainCount;

    //所有包含的对象域domains
    //Returns the list of domains in which any MBean is currently registered.
    // A string is in the returned array if and only if there is at least one
    // MBean registered with an ObjectName whose getDomain() is equal to that
    // string. The order of strings within the returned array is not defined.



    //MBInfo
    //This method discovers the attributes and operations that an MBean
    // exposes for management.


    //Attribute
    //Gets the value of a specific attribute of a named MBean.
    // The MBean is identified by its object name.

    //Attributes
    //Retrieves the values of several attributes of a named MBean.
    // The MBean is identified by its object name.



}
