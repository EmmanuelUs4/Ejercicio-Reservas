package com.example.Reservas.Services;

import com.example.Reservas.Exception.ApiRequestException;
import com.example.Reservas.Model.Booking;
import com.example.Reservas.Model.Client;
import com.example.Reservas.Model.Room;
import com.example.Reservas.Repositories.BookingRepository;
import com.example.Reservas.Repositories.ClientRepository;
import com.example.Reservas.Repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class BookingService {

    private BookingRepository bookingRepository;
    private RoomRepository roomRepository;
    private ClientRepository clientRepository;
    private Booking booking;


    @Autowired
    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository, ClientRepository clientRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.clientRepository = clientRepository;

    }


    public Booking bookRoom(Integer dni, Integer roomNumber, String date, Integer price) {
        LocalDate date1 = stringToDate(date);

            if (dni <= 0 || roomNumber <= 0 || date == null) {
                throw new RuntimeException("Falta uno de los parámetros");
            }
            Optional<Room> room = roomRepository.findById(roomNumber);
            Optional<Client> client = clientRepository.findById(dni);
            if (room.isPresent() && client.isPresent()) {
                Booking booking = new Booking(client.get(),room.get(), date1, price);
                bookingRepository.save(booking);
                return booking;
            }
            return new Booking();
    }



    public void dateValidator(LocalDate date){
        if(date.isBefore(LocalDate.now())){
            throw new ApiRequestException("Invalid date");
        }
    }
    public LocalDate stringToDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date1 = LocalDate.parse(date,formatter);
        return date1;
    }
    public List<Room> getAvailableRoomsByDate(String date){
        LocalDate date1= stringToDate(date);
        dateValidator(date1);
        return availableRoomsByDate(date1);
    }
    public List<Room> availableRoomsByDate(LocalDate date){
        List<Room> availableRooms;

        List<Room> rooms = this.roomRepository.findAll();
        List<Booking> bookedRooms = this.bookingRepository.findAll();
        List<Room> bookedRoomsOnDate = bookedRooms.stream()
                .filter(booking -> booking.getDate().isBefore(date) && booking.getDate().isAfter(date))
                .map(Booking::getRoom)
                .collect(Collectors.toList());

        availableRooms = rooms.stream()
                .filter(room -> !bookedRoomsOnDate.contains(room))
                .collect(Collectors.toList());

        return availableRooms;
    }

    public List<Room> availableRoomsByType(String date, String roomType){
        LocalDate date1 =  stringToDate(date);
        dateValidator(date1);

        if (date1.isBefore(LocalDate.now())){
            throw new RuntimeException("Fecha de reserva inválida");
        }
        List<Room> availableRooms = availableRoomsByDate(date1);
        return availableRooms.stream()
                .filter(room -> room.getRoomType().equalsIgnoreCase(roomType))
                .collect(Collectors.toList());
    }



}