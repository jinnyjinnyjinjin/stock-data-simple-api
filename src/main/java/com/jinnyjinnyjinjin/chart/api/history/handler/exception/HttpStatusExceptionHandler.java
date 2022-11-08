package com.jinnyjinnyjinjin.chart.api.history.handler.exception;

import com.jinnyjinnyjinjin.chart.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

@RestControllerAdvice
public class HttpStatusExceptionHandler {

    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<ApiResponse> handleInternalServerException(HttpStatusCodeException ex) {
        return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()), ex.getStatusCode());
    }
}
