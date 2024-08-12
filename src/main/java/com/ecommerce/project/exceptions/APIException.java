package com.ecommerce.project.exceptions;

public class APIException extends RuntimeException{
    private static final Long serialVersionID = 1L;

    public APIException() {
    }

    public APIException(String message){
        super(message);
    }
}
