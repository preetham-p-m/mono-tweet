package com.pmp.restful_web_service.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pmp.restful_web_service.exception.errors.UserNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllException(Exception ex, WebRequest request) throws Exception {
        return new ResponseEntity<Error>(getError(ex, request), getErrorCode(ex));
    }

    /**
     * The below method will be redundant since the handleAllException method
     * provides a generic implementation to return the appropriate status code
     * using reflection.
     */
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Error> handleUserNotFoundExceptionException(Exception ex, WebRequest request)
            throws Exception {
        return new ResponseEntity<Error>(getError(ex, request),
                HttpStatus.NOT_FOUND);
    }

    private static Error getError(Exception ex, WebRequest request) {
        return new Error(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));
    }

    private static HttpStatus getErrorCode(Exception ex) {
        ResponseStatus responseStatus = ex.getClass().getAnnotation(ResponseStatus.class);
        return responseStatus == null ? HttpStatus.INTERNAL_SERVER_ERROR : responseStatus.code();
    }

}
