package com.ctw.workstation.booking.boudary;

import com.ctw.workstation.RackAsset.dto.RackAssetMapper;
import com.ctw.workstation.RackAsset.repository.rackAssetRepository;
import com.ctw.workstation.booking.dto.BookingDto;
import com.ctw.workstation.booking.dto.BookingMapper;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.repository.bookingRepository;
import com.ctw.workstation.team.dto.TeamDto;
import com.ctw.workstation.team.entity.Team;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.logging.Logger;

import java.net.URI;
import java.util.Date;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/booking")
public class BookingResource {

    @Inject
    bookingRepository bookingRepo;
    @Inject
    BookingMapper bookingMapper;

    private static final Logger log = Logger.getLogger(BookingResource.class);

    @GET
    public Response Bookings(){

        List<BookingDto> dtoAllList = bookingMapper.listToDto(bookingRepo.allBookings());

        return Response.ok(dtoAllList).build();

    }

    @GET
    @Path("/{bookingId}")
    public Response BookingById(@PathParam("bookingId") Long bookingId){

        BookingDto newDto = bookingMapper.toDto(bookingRepo.findById(bookingId));
        return Response.ok(newDto).build();

    }

    @POST
    public Response addBooking(BookingDto bookingDto, @Context UriInfo uriInfo) {

        Booking newBooking = bookingMapper.fromDto(bookingDto);
        bookingRepo.add(newBooking);

        URI location = uriInfo.getAbsolutePathBuilder().path(newBooking.toString()).build();
        return Response.created(location).entity(newBooking).build();

    }

    @PUT
    @Path("/{bookingId}")
    public Response updateBookingById(@PathParam("bookingId") Long bookingId, BookingDto updatedBookingDataDto) {

        if(bookingRepo.findById(bookingId) == null) return Response.status(Response.Status.BAD_REQUEST).build();

        bookingRepo.updateData(bookingId, updatedBookingDataDto);

        return Response.ok(updatedBookingDataDto).build();

    }

    @DELETE
    @Path("/{bookingId}")
    public Response removeBookingById(@PathParam("bookingId") Long bookingId, @Context UriInfo uriInfo) {

        try {
            BookingDto bookingRemovedDto = bookingMapper.toDto(bookingRepo.findById(bookingId));
            bookingRepo.remove(bookingRepo.findById(bookingId));
            return Response.ok(bookingRemovedDto).build();
        }catch (Exception e){

            return Response.status(Response.Status.BAD_REQUEST).build();

        }

    }

}
