package com.example.Reservas.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastName;

    @Id
    @Column(name="dni")
    private Integer dni;

    @Column(name="adress")
    private String adress;

    @Column(name="age")
    private int age;

    @Column(name="emailadress")
    private String emailAdress;

    public Client(){}

    public Client(String name, String lastName, Integer dni, String adress, int age, String emailAdress) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.adress = adress;
        this.age = age;
        this.emailAdress = emailAdress;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDni() {
        return dni;
    }

    public String getAdress() {
        return adress;
    }

    public int getAge() {
        return age;
    }

    public String getEmailAdress() {
        return emailAdress;
    }




}


