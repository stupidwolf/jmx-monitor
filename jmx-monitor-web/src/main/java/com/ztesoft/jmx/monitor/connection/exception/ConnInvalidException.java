package com.ztesoft.jmx.monitor.connection.exception;

public class ConnInvalidException extends RuntimeException{
    public ConnInvalidException() {
        super("Jmx connection invalid exception.");
    }

    public ConnInvalidException(String message) {
        super(message);
    }
}
