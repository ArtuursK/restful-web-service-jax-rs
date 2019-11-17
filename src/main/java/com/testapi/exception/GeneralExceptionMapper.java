package com.testapi.exception;

import com.testapi.dto.ErrorResponse;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.TransactionRolledbackLocalException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof BusinessException) {
            return handleBusinessException((BusinessException) exception);
        } else if (exception instanceof WebApplicationException) {
            return handleWebApplicationException((WebApplicationException) exception);
        } else {
            return handleUnknownException(exception);
        }
    }

    private Response handleBusinessException(BusinessException exception) {
        return prepareErrorResponse(exception.getErrorCode(), exception.getMessage());
    }

    private Response handleWebApplicationException(WebApplicationException exception) {
        return prepareErrorResponse(new IErrorCode() {
            @Override
            public String getCode() {
                final StatusType status = exception.getResponse().getStatusInfo();
                if (status.getClass().isEnum()) {
                    return ((Enum<?>) status).name().toLowerCase();
                }
                return EGeneralErrorCode.APPLICATION_ERROR.name().toLowerCase();
            }

            @Override
            public int getStatusCode() {
                return exception.getResponse().getStatus();
            }
        }, exception.getResponse().getStatusInfo().getReasonPhrase());
    }

    private Response handleUnknownException(Exception exception) {
        boolean wentDeeper;
        do {
            wentDeeper = true;
            if (exception instanceof EJBTransactionRolledbackException) {
                exception = ((EJBTransactionRolledbackException) exception).getCausedByException();
            } else if (exception instanceof TransactionRolledbackLocalException) {
                exception = ((TransactionRolledbackLocalException) exception).getCausedByException();
            } else {
                wentDeeper = false;
            }
        } while (wentDeeper);
        final IErrorCode errorCode = exception instanceof NotFoundException
                ? EGeneralErrorCode.NOT_FOUND : EGeneralErrorCode.APPLICATION_ERROR;
        return prepareErrorResponse(errorCode, exception.getMessage());
    }

    private static Response prepareErrorResponse(IErrorCode errorCode, @NotNull String message) {
        final ErrorResponse responseBody = new ErrorResponse()
                .status(errorCode.getStatusCode())
                .code(errorCode.getCode().toLowerCase())
                .message(message);
        final ResponseBuilder responseBuilder = Response.status(errorCode.getStatusCode()).type(MediaType.APPLICATION_JSON).entity(responseBody);
        return responseBuilder.build();
    }

}
