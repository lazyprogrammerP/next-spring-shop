package io.spring.shop.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ThrowableException extends RuntimeException {

    private HttpStatus statusCode;
    private String message;

    public ThrowableException(HttpStatus statusCode) {
        this.statusCode = statusCode;
        this.message = "Something went wrong.";
    }

    public ThrowableException(String message) {
        this.statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = message;
    }

    public ThrowableException(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

}
