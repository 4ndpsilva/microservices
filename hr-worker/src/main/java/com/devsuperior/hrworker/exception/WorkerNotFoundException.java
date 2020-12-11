package com.devsuperior.hrworker.exception;

public class WorkerNotFoundException extends RuntimeException {
    public WorkerNotFoundException(final String message){
        super(message);
    }
}