package com.ctw.workstation.teammember.boudary;

import com.ctw.workstation.team.boudary.TeamResource;
import com.ctw.workstation.team.dto.TeamDto;
import com.ctw.workstation.teammember.dto.TeammemberDto;
import com.ctw.workstation.teammember.dto.TeammemberMapper;
import com.ctw.workstation.teammember.entity.Teammember;
import com.ctw.workstation.teammember.repositoy.teammemberRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
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
class TeammemberResourceTest {

    @Mock
    teammemberRepository teammemberRepo; // precisso disto? ver
    @Mock
    TeammemberMapper teammemberMapper;

    @Inject
    TeamResource  teamResource;

    @InjectMocks
    TeammemberResource teammemberResource;

    @DisplayName("Create Teammember")
    @Test
    void create_Teammember() {

//        //Given
//        UriInfo uriInfo = Mockito.mock(UriInfo.class);
//        Mockito.when(uriInfo.getAbsolutePathBuilder()).thenReturn(UriBuilder.fromPath("/team")); // wtf happn here
//
//
//        TeamDto teamDto = new TeamDto(LocalDateTime.parse("2022-03-10T12:15:50"),LocalDateTime.parse("2022-03-10T12:15:50"),"coco","xixi","isbon");
//        teamResource.addTeam(teamDto,uriInfo);
//
//        //When
//        //Then
//
//        RestAssured.given().contentType(ContentType.JSON).body("""
//        {
//          "name": "coco",
//          "team_id": 1,
//          "ctwId": "12345",
//          "modifiedAt": "2022-03-10T12:15:50"
//        }
//        """)
//                .post("/teammember")
//                .then()
//                .statusCode(201);

    }


}