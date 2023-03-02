
package io.spring.shop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(ThrowableException.class)
    public ResponseEntity<Object> handleExceptions(ThrowableException exception, WebRequest webRequest) {
        return new ResponseEntity<>(exception, exception.getStatusCode());
    }

}