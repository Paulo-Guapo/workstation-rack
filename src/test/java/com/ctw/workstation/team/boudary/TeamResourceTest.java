package com.ctw.workstation.team.boudary;

import com.ctw.workstation.team.dto.TeamDto;
import com.ctw.workstation.team.service.TeamService;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(MockitoExtension.class)
//@QuarkusTest
////@TestHTTPEndpoint(value = "/team") // -> isto nao funciona por alguma razao -> por porque
//class TeamResourceTest {
//
//    @Mock // isto é mock? deveria ser injeto (maybe)
//    TeamService teamService;

//    @Inject
//    TeamResource teamResource;
//
//    @BeforeEach
//    void setUp() {
//
////        //huh
//
//        UriInfo uriInfo = Mockito.mock(UriInfo.class);
//        Mockito.when(uriInfo.getAbsolutePathBuilder()).thenReturn(UriBuilder.fromPath("/team")); // wtf happn here
//
//
//        TeamDto teamDto = new TeamDto(LocalDateTime.parse("2022-03-10T12:15:50"),LocalDateTime.parse("2022-03-10T12:15:50"),"coco","xixi","isbon");
//        teamResource.addTeam(teamDto,uriInfo);
//

//    }

//    @DisplayName("Create Team")
//    @Test
//    void create_Team() {
//
//        //given
//        //when
//        //then

//        RestAssured.given().contentType(ContentType.JSON).body("""
//        {
//          "createdAt": "2022-03-10T12:15:50",
//          "modifiedAt": "2022-03-10T12:15:50",
//          "name": "coco",
//          "product": "xixi",
//          "defaultLocation": "Lisbon"
//        }
//        """)
//                        .when()
//                        .post("/team")
//                        .then()
//                        .statusCode(HttpStatus.SC_CREATED); // HttpStatus.SC_CREATED // 201
//
//        //var response = RestAssured.given().contentType(ContentType.JSON); // -> wtf is this
//

//    }
//
//    @DisplayName("Get Team by Id")
//    @Test
//    void get_Team_By_Id() {

        //given
        //when
        //then

        //RestAssured.get("/team").then().contentType(ContentType.JSON).statusCode(200);
//        RestAssured.given().param("teamId", "1").when().get("/team/{teamId}");

//    }
//
//
//}