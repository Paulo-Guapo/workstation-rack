package com.ctw.workstation.booking.dto;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.rack.dto.RackDto;
import com.ctw.workstation.rack.entity.Rack;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface BookingMapper {

    BookingDto toDto(Booking booking);
    Booking fromDto(BookingDto dto);
    List<BookingDto> listToDto(List<Booking> booking);

}
