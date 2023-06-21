package com.fiapadj.fase1.services.exception;

public class ControllerNotFoundException extends RuntimeException{

    public ControllerNotFoundException(String message){
        super(message);
    }
}

