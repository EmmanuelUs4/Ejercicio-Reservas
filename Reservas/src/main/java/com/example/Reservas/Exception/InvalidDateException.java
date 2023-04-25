package com.example.Reservas.Exception;

public class InvalidDateException extends RuntimeException{
    public InvalidDateException() {
    }

    public InvalidDateException(String messageError){
        super(messageError);
    }
}