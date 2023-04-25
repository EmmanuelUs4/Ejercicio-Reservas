package com.example.Reservas.Services;

import com.example.Reservas.Model.Booking;
import com.example.Reservas.Model.Client;
import com.example.Reservas.Repositories.BookingRepository;
import com.example.Reservas.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ClientService {
private ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public Client create(Client client){
        if(client.getDni() <0 || client.getName() == null || client.getLastName()==null){
            throw new RuntimeException("Uno de los campos del cliente está vacío, por favor ingrese información válida.");
        }
        this.clientRepository.save(client);
        return client;
    }

    public Client showClients(Client client){
        this.clientRepository.findById(client.getDni());
        return client;
    }



    /*. Obtener todas las reservas de un cliente, por consiguiente, el endpoint va recibir la
    identificación del cliente y debe retornar todas las reservas asociadas a él.*/
}
