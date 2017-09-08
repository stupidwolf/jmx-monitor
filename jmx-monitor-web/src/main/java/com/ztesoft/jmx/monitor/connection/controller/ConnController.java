package com.ztesoft.jmx.monitor.connection.controller;

import com.ztesoft.jmx.monitor.connection.model.ConnModel;
import com.ztesoft.jmx.monitor.connection.model.ConnMsgModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("jmx/connection")
public class ConnController {
    private final static Logger logger = LoggerFactory.getLogger(ConnController.class);

    @RequestMapping("")
    @ResponseBody
    public ConnMsgModel jmxConnect(@RequestBody ConnModel connModel) {
        logger.info("jmx connection from client: {}", connModel);

        //TODO 调用连接操作
        return new ConnMsgModel("200", "connect success..");
    }
}
