package com.example.Reservas.Exception;

public class ApiRequestException extends RuntimeException {
    public ApiRequestException(){}
    public ApiRequestException(String messageError){
        super(messageError);
    }

}
