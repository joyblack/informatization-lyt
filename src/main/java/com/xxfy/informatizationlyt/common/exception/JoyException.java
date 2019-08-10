package com.xxfy.informatizationlyt.common.exception;

import com.xxfy.informatizationlyt.common.result.JoyResult;
import com.xxfy.informatizationlyt.common.result.Notice;

public class JoyException extends RuntimeException {

    private static final long serialVersionUID = 8182981230289783930L;

    private JoyResult errorMessage;

    public JoyResult getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(JoyResult errorMessage) {
        this.errorMessage = errorMessage;
    }

    public JoyException() {
        super();
        errorMessage = JoyResult.buildFailedResult("系统出错");
    }

    public JoyException(String message, Throwable cause) {
        super(message, cause);
        this.errorMessage = JoyResult.buildFailedResult(message);
        errorMessage.setDetailMessage(cause.getMessage());
    }

    public JoyException(String message) {
        super(message);
        this.errorMessage = JoyResult.buildFailedResult(message);
    }

    public JoyException(Notice notice) {
        super(notice.getMessage());
        this.errorMessage = JoyResult.buildFailedResult(notice,"");
    }

    public JoyException(Throwable cause) {
        super(cause);
        this.errorMessage = JoyResult.buildFailedResult(cause.getMessage());
    }

    public JoyException(JoyResult errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

}

