package com.ctw.workstation.booking.repository;

import com.ctw.workstation.booking.dto.BookingDto;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.rack.dto.RackDto;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.entity.Team;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
@ApplicationScoped
public class bookingRepository implements PanacheRepository<Booking> {

    public Booking findById(Long id){
        return find("id", id).firstResult();
    }

    public Booking add(Booking booking){
        persist(booking);
        return booking;
    }

    public Booking remove(Booking booking){
        delete(booking);
        return booking;
    }

    public List<Booking> allBookings(){
        return listAll();
    }

    public Booking updateData(Long id, BookingDto bookingDto){

        //Verificar se o rack existe primeiro
        Booking booking = findById(id);
        if (booking == null) {
            throw new WebApplicationException("booking not found", 404);
        }

        booking.setBookFrom(bookingDto.getBookFrom());
        booking.setModifiedAt(LocalDateTime.now());
        booking.setbookTo(bookingDto.getBookTo());
        booking.setRequesterId(bookingDto.getRequesterId());
        booking.setRackId(bookingDto.getRackId());

        return booking;

    }

}
