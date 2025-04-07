package com.grepp.servlet.infra.exception;

public class JdbcInitializeException extends RuntimeException {

    public JdbcInitializeException(String message) {
        super(message);
    }

    public JdbcInitializeException(String message, Throwable cause) {
        super(message, cause);
    }
}
