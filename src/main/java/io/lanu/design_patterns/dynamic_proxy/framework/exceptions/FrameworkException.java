package io.lanu.design_patterns.dynamic_proxy.framework.exceptions;

public class FrameworkException extends RuntimeException {

    public FrameworkException(String message) {
        super(message);
    }

    public FrameworkException(Throwable throwable) {
        super("Unknown exception", throwable);
    }

}
