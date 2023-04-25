package com.example.Reservas.Controllers;

import com.example.Reservas.Model.Client;
import com.example.Reservas.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    private ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @PostMapping("/client")
    public Client registerClient(@RequestBody Client client) {
        return this.clientService.create(client);
    }



}
