package com.example.Reservas.Repositories;

import com.example.Reservas.Model.Booking;
import com.example.Reservas.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    /*@Query("Select h FROM Room h, Booking r WHERE h.roomNumber not in(SELECT room.roomNumber from Booking) " +
            "OR h.roomNumber not in(select distinct r.room.roomNumber from  Booking r where r.date= ?1)")
    public Set<Room> findByDate(String date);


    @Query("SELECT r FROM Booking r WHERE r.client.dni = ?1")
    public List<Booking> findAllByDni(Integer dni);

    @Query("Select  h FROM Room h, Booking r WHERE (h.roomNumber not in(SELECT room.roomNumber from Booking) " +
            "OR h.roomNumber not in(select distinct r.room.roomNumber from  Booking r where r.date= ?1)) AND h.roomType=?2")
    public List<Room> findByDateType(String date, String roomType);

    @Query("select count(*) from Reserva")
    public Integer cantidadReservas();
    @Query("Select h.numero FROM Habitacion h, Reserva r WHERE h.numero not in(SELECT habitacion.numero from Reserva) " +
            "OR h.numero not in(select distinct r.habitacion.numero from  Reserva r where r.fechaReserva= ?1)")
    public List<Integer> getAvailability(String fecha);*/
}
