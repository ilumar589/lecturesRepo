package org.eddInc.noname.lectures.backend.CustomExceptions;

import java.util.List;

/**
 * Created by Catalina on 2/18/14.
 */
public class BusinessException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
    private String errorMessage;
    private List<String> errorMessages;
    private int severity = -1;

    public BusinessException() {
        super();
        errorCode = "0";
    }

    public BusinessException(Exception e) {
        super(e);
        this.errorCode = e.getMessage();
        this.errorMessage = e.getMessage();
    }

    public BusinessException(String errorCode) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorCode;
    }

    public BusinessException(String errorCode, String errorMessage,
                             int severity) {
        super();
        this.errorCode = errorCode;
        this.severity = severity;
        this.errorMessage = errorMessage;
    }

    public BusinessException(String errorCode, List<String> errorMessages,
                             int severity) {
        super();
        this.errorCode = errorCode;
        this.severity = severity;
        this.errorMessages = errorMessages;
    }

    public BusinessException(String errorMessage, Exception e) {
        super(e);
        this.errorMessage = errorMessage;
    }

    public BusinessException(String errorCode, String errorMessage,
                             int severity, Exception e) {
        super(e);
        this.errorCode = errorCode;
        this.severity = severity;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getSeverity() {
        return this.severity;
    }

    @Override
    public String getMessage() {
        return getErrorMessage();
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

