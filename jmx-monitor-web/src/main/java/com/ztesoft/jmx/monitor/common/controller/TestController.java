package com.ztesoft.jmx.monitor.common.controller;

import com.ztesoft.jmx.monitor.common.exception.DataNotValidException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {
    @RequestMapping("exception")
    @ResponseBody
    public void testException() {
        throw new DataNotValidException();
    }
}
