package com.example.Reservas.Controllers;

import com.example.Reservas.Model.Room;
import com.example.Reservas.Repositories.RoomRepository;
import com.example.Reservas.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class RoomController {

    private RoomService roomService;
    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/room")
    public Room createRoom(@RequestBody Room room){
        return this.roomService.createRoom(room);
    }


}
