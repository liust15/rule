package com.liust.rule.exception;

public class RuleExcetion extends RuntimeException{
    public RuleExcetion() {
    }

    public RuleExcetion(String message) {
        super(message);
    }

    public RuleExcetion(String message, Throwable cause) {
        super(message, cause);
    }

    public RuleExcetion(Throwable cause) {
        super(cause);
    }

    public RuleExcetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
