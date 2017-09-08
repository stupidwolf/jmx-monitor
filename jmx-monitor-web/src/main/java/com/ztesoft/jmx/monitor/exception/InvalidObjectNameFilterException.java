package com.ztesoft.jmx.monitor.exception;

public class InvalidObjectNameFilterException extends RuntimeException {
    public InvalidObjectNameFilterException() {
        super("Invalid objectName filter.");
    }

    public InvalidObjectNameFilterException(String message) {
        super(message);
    }
}
