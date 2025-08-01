package com.ctw.workstation.booking.boudary;

import com.ctw.workstation.booking.dto.BookingDto;
import com.ctw.workstation.booking.dto.BookingMapper;
import com.ctw.workstation.booking.repository.bookingRepository;
import com.ctw.workstation.rack.boudary.RackResource;
import com.ctw.workstation.rack.dto.RackDto;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.boudary.TeamResource;
import com.ctw.workstation.team.dto.TeamDto;
import com.ctw.workstation.teammember.boudary.TeammemberResource;
import com.ctw.workstation.teammember.dto.TeammemberDto;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@QuarkusTest
//@TestHTTPEndpoint("")
class BookingResourceTest {

    @Inject
    TeamResource teamResource;
    @Inject
    RackResource rackResource;
    @Inject
    TeammemberResource teammemberResource;

    @InjectMocks
    BookingResource bookingResource;

    @Mock
    bookingRepository bookingRepo;

    @Mock
    BookingMapper bookingMapper;

    // nota: Resource NUNCA trabalha com entidades -> nunca se espoes -> por isso é que se usa um service

    @BeforeAll
    @Transactional // precisso disto? for some reason
    public static void setup() {



    }

    @Test
    @DisplayName("Create booking")
    void create_Booking(){

        //given //criar os objetos que precisso

        BookingDto bookingDto; // oof

        //****
        UriInfo uriInfo = Mockito.mock(UriInfo.class);
        Mockito.when(uriInfo.getAbsolutePathBuilder()).thenReturn(UriBuilder.fromPath("/team")); // wtf happn here

        UriInfo uriInfo2 = Mockito.mock(UriInfo.class);
        Mockito.when(uriInfo2.getAbsolutePathBuilder()).thenReturn(UriBuilder.fromPath("/teammember"));

        UriInfo uriInfo3 = Mockito.mock(UriInfo.class);
        Mockito.when(uriInfo3.getAbsolutePathBuilder()).thenReturn(UriBuilder.fromPath("/rack"));
        //*** eu sei, trash code, arranjar later

        TeamDto teamDto = new TeamDto(LocalDateTime.parse("2022-03-10T12:15:50"),LocalDateTime.parse("2022-03-10T12:15:50"),"coco","xixi","Lisbon");
        teamResource.addTeam(teamDto,uriInfo);

        TeammemberDto  teammemberDto = new TeammemberDto("coco",1L,"12345");
        teammemberResource.addTeammember(teammemberDto,uriInfo2);

        RackDto rackDto = new RackDto("2000-12-01", LocalDateTime.parse("2022-03-10T12:15:50"), LocalDateTime.parse("2022-03-10T12:15:50"), Rack.Status.ACTIVE, 1L, "Lisbon");
        rackResource.addRack(rackDto,uriInfo3);

        //when

        //then

        RestAssured.given().contentType(ContentType.JSON).body("""
          {
          "bookFrom": "2022-03-10T12:15:50",
          "bookTo": "2022-03-10T12:15:50",
          "createdAt": "2022-03-10T12:15:50",
          "modifiedAt": "2022-03-10T12:15:50",
          "requesterId": 1,
          "rackId": 1
        }""").when().post("/booking").then().statusCode(HttpStatus.SC_CREATED);



    }

}