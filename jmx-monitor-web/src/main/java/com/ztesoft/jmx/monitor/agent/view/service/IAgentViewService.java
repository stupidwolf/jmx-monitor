package com.ztesoft.jmx.monitor.agent.view.service;

import com.ztesoft.jmx.monitor.agent.view.dto.ObjectNamesDTO;
import com.ztesoft.jmx.monitor.connection.exception.ConnInvalidException;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.QueryExp;

public interface IAgentViewService {
    /**
     *
     * @param mBeanServerConnection  if mBeanServerConnection is null
     * @param objectName if null, query all
     * @param queryExp if null, query all
     * @return ObjectNamesDTO
     * @throws ConnInvalidException  throw ConnInvalidException.
     */
    ObjectNamesDTO getObjectNamesDTO(MBeanServerConnection mBeanServerConnection, ObjectName objectName, QueryExp queryExp) throws ConnInvalidException;

}
