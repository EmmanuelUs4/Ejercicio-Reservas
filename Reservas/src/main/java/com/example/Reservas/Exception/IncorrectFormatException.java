package com.example.Reservas.Exception;

public class IncorrectFormatException extends RuntimeException{

    public IncorrectFormatException(){}
    public IncorrectFormatException(String messageError){
        super(messageError);
    }

}
