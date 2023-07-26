package com.friska.jnotes.test.testutil;

public abstract class Failable {

    protected final StringBuilder failLog = new StringBuilder();

    protected boolean failed = false;

    protected int failedNum = 0;

    protected String getFailLog() {
        return failLog.toString();
    }

    protected boolean isFailed() {
        return failed;
    }

    protected int getFailedNum() {
        return failedNum;
    }
}
