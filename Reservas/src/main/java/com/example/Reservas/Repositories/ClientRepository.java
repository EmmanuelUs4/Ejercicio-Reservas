package com.example.Reservas.Repositories;

import com.example.Reservas.Model.Client;
import com.example.Reservas.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {


}
