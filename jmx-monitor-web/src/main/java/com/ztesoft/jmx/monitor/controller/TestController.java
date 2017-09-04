package com.ztesoft.jmx.monitor.controller;

import com.ztesoft.jmx.monitor.exception.http.response.DataNotValidException;
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
