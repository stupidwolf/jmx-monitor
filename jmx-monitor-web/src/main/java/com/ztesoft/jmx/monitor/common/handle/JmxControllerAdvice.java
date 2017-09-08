package com.ztesoft.jmx.monitor.common.handle;

import com.ztesoft.jmx.monitor.common.dto.CustomErrorType;
import com.ztesoft.jmx.monitor.common.exception.DataNotValidException;
import com.ztesoft.jmx.monitor.connection.exception.ConnInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

//TODO 需要细分么?
@ControllerAdvice(basePackages = {"com.ztesoft.jmx.monitor"})
public class JmxControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DataNotValidException.class})
    @ResponseBody
    ResponseEntity<?> handleBadRequest(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(
                new CustomErrorType(HttpStatus.BAD_REQUEST.value(), ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(DataNotValidException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(new CustomErrorType(status.value(), ex.getMessage()), status);
    }

    @ExceptionHandler(value = {ConnInvalidException.class})
    @ResponseBody
    ResponseEntity<?> handleConnectionInvalidException(HttpServletRequest request, Throwable ex) {
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
