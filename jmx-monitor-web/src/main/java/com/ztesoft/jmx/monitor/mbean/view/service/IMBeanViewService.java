package com.ztesoft.jmx.monitor.mbean.view.service;

import com.ztesoft.jmx.monitor.connection.exception.ConnInvalidException;
import com.ztesoft.jmx.monitor.mbean.view.dto.MBeanDTO;
import com.ztesoft.jmx.monitor.mbean.view.exception.MBeanException;
import com.ztesoft.jmx.monitor.mbean.view.exception.MBeanInfoNotFoundException;
import com.ztesoft.jmx.monitor.mbean.view.exception.TooManyMBeanFoundException;

import javax.management.MBeanServerConnection;

public interface IMBeanViewService {
    /**
     * 获取 MBeanInfo,并获取相应值,进行相应转化后,返回 MBeanDTO
     * @param mBeanServerConnection connection
     * @param objectName objectName, a String type
     * @return MBeanDTO
     * @throws MBeanInfoNotFoundException can not found mbean by the string of objectName
     * @throws TooManyMBeanFoundException more than one mbean found by objectName string
     * @throws ConnInvalidException jmx conn is invalid.
     */
    MBeanDTO getMBeanDTO(MBeanServerConnection mBeanServerConnection, String domain, String objectName)
            throws MBeanException, MBeanInfoNotFoundException,
            ConnInvalidException;
}
