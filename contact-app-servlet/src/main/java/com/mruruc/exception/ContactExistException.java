package com.mruruc.exception;

public class ContactExistException extends RuntimeException {
    public ContactExistException(String message) {
        super(message);
    }
}
