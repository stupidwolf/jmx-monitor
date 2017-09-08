package com.ztesoft.jmx.monitor.mbean.view.controller;

import com.ztesoft.jmx.monitor.connection.service.IConnService;
import com.ztesoft.jmx.monitor.mbean.view.dto.MBeanDTO;
import com.ztesoft.jmx.monitor.mbean.view.service.IMBeanViewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("jmx/ViewObjectRes")
public class MBeanViewController {
    private Logger logger = LoggerFactory.getLogger(MBeanViewController.class);

    @Autowired
    private IMBeanViewService mBeanViewService;

    @Autowired
    private IConnService connService;

    @RequestMapping("{domain}/{objectName}")
    public ResponseEntity<MBeanDTO> getMBeanDTO(@PathVariable("domain") String domain,
                                                @PathVariable("objectName") String objectName, HttpSession session) {
        MBeanDTO mBeanDTO;
        MBeanServerConnection mBeanServerConnection = null;
        try {
            mBeanServerConnection = connService.getCurrentJMXConnector(session).getMBeanServerConnection();
        } catch (IOException e) {
            logger.error("error msg: {}", e.getMessage(), e);
        }
        mBeanDTO = mBeanViewService.getMBeanDTO(mBeanServerConnection, domain, objectName);

        return new ResponseEntity<MBeanDTO>(mBeanDTO, HttpStatus.OK);
    }
}
