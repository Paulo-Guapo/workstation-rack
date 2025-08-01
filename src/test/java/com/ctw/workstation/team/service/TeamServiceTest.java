package com.ctw.workstation.team.service;

import com.ctw.workstation.team.boudary.TeamResource;
import com.ctw.workstation.team.dto.TeamDto;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@QuarkusTest
class TeamServiceTest {
// este aqui era para explicar o mock do quarkus
    //@InjectMock

    @Inject
    TeamService teamService;
    @Inject
    TeamResource teamResource;

    @Test
    @DisplayName("Create Team")
    void create_Team() {
        //given

        //TeamResource teamResource = new TeamResource("nome","projeto"); // nao sei o que é isto tbh
        //TeamDto teamDto = teamService.create(teamResource); // nao tenho o create aqui dentro ainda fkk

        //when

        //then

        //verificações nos asserts todos

        /*
        org.junit.jupiter.api.Assertions.assertNotNull(teamDto);
        org.junit.jupiter.api.Assertions.assertNotNull(teamDto.getId());
        org.junit.jupiter.api.Assertions.assertNotNull(teamDto.getName());
         */



    }

}