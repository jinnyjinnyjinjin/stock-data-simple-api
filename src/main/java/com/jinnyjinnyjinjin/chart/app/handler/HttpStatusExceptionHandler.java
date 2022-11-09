package com.jinnyjinnyjinjin.chart.app.handler;

import com.jinnyjinnyjinjin.chart.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;

@RestControllerAdvice
public class HttpStatusExceptionHandler {

    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<ApiResponse> handleInternalServerException(HttpStatusCodeException ex) {
        return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()), ex.getStatusCode());
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<ApiResponse> handleRestClientException(RestClientException ex) {
        return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
