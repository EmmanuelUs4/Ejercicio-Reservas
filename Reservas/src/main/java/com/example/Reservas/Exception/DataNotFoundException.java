package com.example.Reservas.Exception;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(){}
    public DataNotFoundException(String messageError){
        super(messageError);
    }
}
