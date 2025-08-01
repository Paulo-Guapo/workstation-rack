package com.ctw.workstation.rack.boudary;

import com.ctw.workstation.team.boudary.TeamResource;
import com.ctw.workstation.team.dto.TeamDto;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@QuarkusTest
class RackResourceTest {

    @Inject
    TeamResource teamResource;

    @InjectMocks // necessario? maybe not
    RackResource rackResource;

    @DisplayName("Create Rack")
    @Test
    void create_Rack() {

//        //Given
//        UriInfo uriInfo = Mockito.mock(UriInfo.class);
//        Mockito.when(uriInfo.getAbsolutePathBuilder()).thenReturn(UriBuilder.fromPath("/team")); // wtf happn here
//
//        TeamDto teamDto = new TeamDto(LocalDateTime.parse("2022-03-10T12:15:50"),LocalDateTime.parse("2022-03-10T12:15:50"),"coco","xixi","Lisbon");
//        teamResource.addTeam(teamDto,uriInfo);
//
//        //When
//        //Then
//
//        //nao sei se gosto muito deste formato
//        RestAssured
//                .given()
//                .contentType(ContentType.JSON)
//                .body("""
//                {
//                  "serialNumber": "1000-10-01",
//                  "createdAt": "2022-03-10T12:15:50",
//                  "modifiedAt": "2022-03-10T12:15:50",
//                  "status": "ACTIVE",
//                  "defaultLocation": "Lisbon",
//                  "teamId": 1
//                }
//""")
//                .post("/rack")
//                .then()
//                .statusCode(201);

    }

}