package com.ztesoft.jmx.monitor.agent.view.handle;

import com.ztesoft.jmx.monitor.agent.view.controller.AgentViewController;
import com.ztesoft.jmx.monitor.agent.view.exeption.InvalidObjectNameFilterException;
import com.ztesoft.jmx.monitor.common.dto.CustomErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackageClasses = {AgentViewController.class})
public class AgentViewExceptionHandler {
    @ExceptionHandler(value = {InvalidObjectNameFilterException.class})
    @ResponseBody
    public ResponseEntity<?> handleInvalidObjectNameFilterException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(
                new CustomErrorType(HttpStatus.EXPECTATION_FAILED.value(),
                        ex.getLocalizedMessage()),
                HttpStatus.EXPECTATION_FAILED);
    }
}
