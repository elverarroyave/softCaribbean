package com.softcaribbean.challenge.elverarroyave.configuration.exeption;

public class BadRequestException extends RuntimeException{
    public BadRequestException(){}

    public BadRequestException(String message) {
        super(message);
    }
}
