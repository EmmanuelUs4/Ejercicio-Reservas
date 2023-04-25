package com.example.Reservas.Services;

import com.example.Reservas.Model.Room;
import com.example.Reservas.Repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoomService {
    private RoomRepository roomRepository;


    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;

    }

    public Room createRoom(Room room){
        if(room.getRoomType()==null){
            throw new RuntimeException("The room type isn't defined yet.");
        }else if(room.getRoomPrice()<=0){
            throw new RuntimeException("The room price isn't defined yet.");
        } else if (room.getRoomNumber()<=0) {
            throw new RuntimeException("The room number isn't defined yet.");
        }
        this.roomRepository.save(room);
        return room;
    }



}
/*public List<Room> roomsByType(LocalDate date, String roomType){
    List<Reservation> reservations = research();
    List<Room> roomList = new ArrayList<>();

    if(roomType.equals("basic")){
        List<Reservation> reservationBasic = reservations.stream()
                .filter(reservation -> reservation.getRoom() != null && reservation.getRoom().getRoomType().equals("basic") && reservation.getReserveDate().equals(date))
                .collect(Collectors.toList());
        reservationBasic.stream().forEach(reservation -> {
            Optional<Room> auxRoom = roomService.researchById(reservation.getRoom().getNumberRoom());
            roomList.add(auxRoom.get());

        });
    }else if (roomType.equals("premium")) {
        List<Reservation> reservationBasic = reservations.stream()
                .filter(reservation -> reservation.getRoom() != null && reservation.getRoom().getRoomType().equals("premium") && reservation.getReserveDate().equals(date))
                .collect(Collectors.toList());
        reservationBasic.stream().forEach(reservation -> {
            Optional<Room> auxRoom = roomService.researchById(reservation.getRoom().getNumberRoom());
            roomList.add(auxRoom.get());

        });

    }
    return roomList;











}
modificado
public List<Room> roomsByType(String roomType){
        List<Room> roomList = new ArrayList<>();

        if(roomType.equals("Standar")){
            List<Room> roomBasic = roomList.stream()
                    .filter(room -> room.getRoomType() != null && room.getRoomType().equals("Standar"))
                    .collect(Collectors.toList());
            roomBasic.stream().forEach(room ->
                    roomList.add(room));


        }else if (roomType.equals("Premium")) {
            List<Room> roomBasic = roomList.stream()
                    .filter(room -> room.getRoomType() != null && room.getRoomType().equals("Premium"))
                    .collect(Collectors.toList());
            roomBasic.stream().forEach(room ->
                    roomList.add(room));

        }
        return roomList;
    }









             public Room availableRoomsByDate(String bookingDay) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Room> query = em.createQuery( "   SELECT    ", Room.class);
            query.setParameter("bookingDay", bookingDay);
            return availableRoomsByDate(bookingDay);

        } finally {
            em.close();
        }
    }*/