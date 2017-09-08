package com.ztesoft.jmx.monitor.advice;

import com.ztesoft.jmx.monitor.controller.JmxMonitorController;
import com.ztesoft.jmx.monitor.dto.CustomErrorType;
import com.ztesoft.jmx.monitor.exception.InvalidObjectNameFilterException;
import com.ztesoft.jmx.monitor.exception.connection.JmxConnectionInvalidException;
import com.ztesoft.jmx.monitor.exception.http.response.DataNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackageClasses = {JmxMonitorController.class})
public class JmxControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DataNotValidException.class})
    @ResponseBody
    ResponseEntity<?> handleBadRequest(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(
                new CustomErrorType(HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage()),
                HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(DataNotValidException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(new CustomErrorType(status.value(), ex.getMessage()), status);
    }

    @ExceptionHandler(value = {JmxConnectionInvalidException.class})
    @ResponseBody
    ResponseEntity<?> handleConnectionInvalidException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(
                new CustomErrorType(HttpStatus.EXPECTATION_FAILED.value(),
                        ex.getLocalizedMessage()),
                HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = {InvalidObjectNameFilterException.class})
    @ResponseBody
    ResponseEntity<?> handleInvalidObjectNameFilterException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(
                new CustomErrorType(HttpStatus.EXPECTATION_FAILED.value(),
                        ex.getLocalizedMessage()),
                HttpStatus.EXPECTATION_FAILED);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
