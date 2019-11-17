package com.testapi.exception;

public enum EGeneralErrorCode implements IErrorCode {

    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    DATA_CONFLICT(409),
    UNPROCESSABLE_ENTITY(422),
    TOO_MANY_REQUESTS(429),
    BUSINESS_ERROR(500),
    APPLICATION_ERROR(500),
    RECEIVED_UNPARSABLE_RESPONSE(500),
    RECEIVED_ERROR_RESPONSE(500),
    COMMUNICATION_ERROR(502),
    SERVICE_NOT_AVAILABLE(503);

    private int statusCode;

    EGeneralErrorCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getCode() {
        return name().toLowerCase();
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

}
