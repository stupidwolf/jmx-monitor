package com.ztesoft.jmx.monitor.exception.http.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//, reason = "data can not pass valid."
//@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DataNotValidException extends RuntimeException{
    private final static String msg = "data can not pass valid.";
    public DataNotValidException() {
        super(msg);
    }
}