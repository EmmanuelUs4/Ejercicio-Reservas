package com.example.Reservas.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "roomnumber")
    private int roomNumber;
    @Column(name = "roomtype")
    private String roomType;
    @Column(name = "roomprice")
    private int roomPrice;


    public Room(){}

    public Room(int roomNumber, String roomType, int roomPrice) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getRoomPrice() {
        return roomPrice;
    }


}
