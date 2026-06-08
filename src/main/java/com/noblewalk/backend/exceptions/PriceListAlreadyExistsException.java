package com.noblewalk.backend.exceptions;

public class PriceListAlreadyExistsException extends RuntimeException{
    public PriceListAlreadyExistsException(String message) {
        super(message);
    }
}
