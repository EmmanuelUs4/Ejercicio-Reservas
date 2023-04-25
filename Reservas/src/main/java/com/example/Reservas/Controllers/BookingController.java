package com.example.Reservas.Controllers;


import com.example.Reservas.Model.Booking;

import com.example.Reservas.Model.Room;
import com.example.Reservas.Services.BookingService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/v1")
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }



    @PostMapping("/booking")
    public Booking bookingRoom(@RequestBody Integer dni, Integer roomNumber, String date, Integer price){
        return this.bookingService.bookRoom(dni, roomNumber, date, price);

    }
    @GetMapping("/booking/{date}")
    public List<Room> getAvailableRoomsByDate(@PathVariable("date")String date) {
        return this.bookingService.getAvailableRoomsByDate(date);
    }
    @GetMapping("/booking/{type}")
    public List<Room> availableRoomsByType(@PathVariable("date")String date,
                                           @PathVariable("roomType")String roomType) {
        return this.bookingService.availableRoomsByType(date, roomType);
    }

}

/*@PostMapping("/booking")
    public Booking bookingRoom(@RequestParam("dni") Integer dni,
                               @RequestParam("roomNumber") Integer roomNumber,
                               @RequestParam("date") String date,
                               @RequestParam("price") Integer price){
        return this.bookingService.bookRoom(dni, roomNumber, date, price);

    }*/
