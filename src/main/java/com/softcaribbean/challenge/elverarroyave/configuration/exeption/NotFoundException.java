package com.softcaribbean.challenge.elverarroyave.configuration.exeption;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){}

    public NotFoundException(String message){super(message);}
}
