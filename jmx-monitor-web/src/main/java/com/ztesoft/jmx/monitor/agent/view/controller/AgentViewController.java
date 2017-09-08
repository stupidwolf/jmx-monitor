package com.ztesoft.jmx.monitor.agent.view.controller;

import com.ztesoft.jmx.monitor.agent.view.dto.ObjectNamesDTO;
import com.ztesoft.jmx.monitor.agent.view.exeption.InvalidObjectNameFilterException;
import com.ztesoft.jmx.monitor.agent.view.service.IAgentViewService;
import com.ztesoft.jmx.monitor.connection.exception.ConnInvalidException;
import com.ztesoft.jmx.monitor.connection.service.IConnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("jmx/agent")
public class AgentViewController {
    private final static Logger logger = LoggerFactory.getLogger(AgentViewController.class);

    @Autowired
    private IAgentViewService agentViewService;

    @Autowired
    private IConnService connService;

    /**
     *
     * @param filter 格式: *:type=MBeanServerDelegate*
     * @param session session
     * @return 若 filter为空，则返回所有的objectNames信息,否则，根据 filter进行过滤
     * @throws ConnInvalidException 无法获取到jmx的连接
     * @throws InvalidObjectNameFilterException 不合法的filter
     */
    @RequestMapping(value = "objectNames", method = {RequestMethod.GET})
    public ResponseEntity<ObjectNamesDTO> getObjectNamesAtAgent(@RequestParam(value = "filter", required=false) String filter, HttpSession session)
            throws ConnInvalidException,  InvalidObjectNameFilterException {
        MBeanServerConnection mBeanServerConnection = null;
        ObjectName objectName = null;

        try {
            mBeanServerConnection = connService.getCurrentJMXConnector(session).getMBeanServerConnection();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ConnInvalidException();
        }

        try {
            if (!StringUtils.isEmpty(filter)) {
                objectName = new ObjectName(filter);
            }
        } catch (MalformedObjectNameException e) {
            logger.error("{}, {}", "Invalid objectName filter.", e);
            throw new InvalidObjectNameFilterException();
        }
        ObjectNamesDTO objectNamesDTO = agentViewService.getObjectNamesDTO(mBeanServerConnection,
                objectName, null);

        return new ResponseEntity<ObjectNamesDTO>(objectNamesDTO, HttpStatus.OK);
    }
}
