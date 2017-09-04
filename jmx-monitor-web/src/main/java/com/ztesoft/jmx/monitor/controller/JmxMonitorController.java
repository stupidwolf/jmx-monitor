package com.ztesoft.jmx.monitor.controller;

import com.ztesoft.jmx.monitor.model.JmxConnectionModel;
import com.ztesoft.jmx.monitor.model.JmxConnectionMsgModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 陈名立
 * @Description:
 * @Date: 2017, 九月 03 15:56 on 星期日
 */
@Controller
@RequestMapping("jmx")
public class JmxMonitorController {
    private final static Logger logger = LoggerFactory.getLogger(JmxMonitorController.class);

    @RequestMapping("connection")
    @ResponseBody
    public JmxConnectionMsgModel jmxConnect(@RequestBody JmxConnectionModel jmxConnectionModel) {
            logger.info("jmx connection from client: {}", jmxConnectionModel);

        //TODO 调用连接操作

        return new JmxConnectionMsgModel("200", "connect success..");
    }
}
