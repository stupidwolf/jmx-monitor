package com.ztesoft.jmx.monitor.common.exception;

//, reason = "data can not pass valid."
//@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DataNotValidException extends RuntimeException{
    private final static String msg = "data can not pass valid.";
    public DataNotValidException() {
        super(msg);
    }
}