package com.example.Reservas.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue()
    private UUID bookingCode;
    @Column(name = "bookingday")
    private LocalDate date;
    @OneToOne
    @JoinColumn(name = "room")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "dni")
    private Client client;

    @Column(name = "price")
    private Integer price;

    public Booking() {
    }





    public Booking(Client client, Room  room, LocalDate date, Integer price) {
        this.client = client;
        this.room = room;
        this.date = date;
        this.price = price;
    }

    public Booking(UUID bookingCode, LocalDate date, Room room, Client client,  Integer price) {
        this.bookingCode = bookingCode;
        this.date = date;
        this.room = room;
        this.client = client;
        this.price = price;
    }

    public UUID getBookingCode() {
        return bookingCode;
    }

    public LocalDate getDate() {
        return date;
    }

    public Room getRoom() {
        return room;
    }

    public Client getClient() {
        return client;
    }

    public Integer getPrice() {
        return price;
    }





    @Override
    public String toString() {
        return "Payment= " + room.getRoomPrice()  +
                ". Booking number: " + bookingCode +
                ". Room number: " + room +
                ". Booking Date: "+ date
                ;
    }
}


