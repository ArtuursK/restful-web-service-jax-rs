package com.api.dto;

import java.util.Objects;


public class ErrorResponse extends DtoObj {

    private int status;

    private String code;

    private String message;

    /**
     * HTTP status code.
     * 401,500,200
     */
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ErrorResponse status(int status) {
        setStatus(status);
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ErrorResponse code(String code) {
        setCode(code);
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorResponse message(String message) {
        setMessage(message);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (! super.equals(o)) {
            return false;
        }
        final ErrorResponse errorResponse = (ErrorResponse) o;
        return Objects.equals(this.status, errorResponse.status) &&
                Objects.equals(this.code, errorResponse.code) &&
                Objects.equals(this.message, errorResponse.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, code, message);
    }

    @Override
    protected StringBuilder fieldsToString() {
        final StringBuilder sb = super.fieldsToString();
        appendField(sb, "status", status);
        appendField(sb, "code", code);
        appendField(sb, "message", message);
        return sb;
    }

}

