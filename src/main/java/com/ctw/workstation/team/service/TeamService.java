package com.ctw.workstation.team.service;

import com.ctw.workstation.team.dto.TeamDto;
import com.ctw.workstation.team.dto.TeamMapper;
import com.ctw.workstation.team.repository.teamRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class TeamService {

    @Inject
    teamRepository teamRepo;
    @Inject
    TeamMapper teamMapper;

    public List<TeamDto> GetTeams(){

        List<TeamDto> dtoAllList = teamMapper.listToDto(teamRepo.allTeams());
        return dtoAllList;

    }

    public TeamDto GetTeamById(@PathParam("teamId") Long teamId){

        return teamMapper.toDto(teamRepo.findById(teamId));

    }

    public TeamDto UpdateTeamById(@PathParam("teamId") Long teamId, TeamDto updatedTeamDataDto){

        //if(teamRepo.findById(teamId) == null) return Response.status(Response.Status.BAD_REQUEST).build();
        //Como é que retorno isto

        teamRepo.update(teamId, updatedTeamDataDto);

        return updatedTeamDataDto;

    }

    public TeamDto RemoveTeamById(@PathParam("teamId") Long teamId){

        TeamDto teamRemovedDto = teamMapper.toDto(teamRepo.findById(teamId));
        teamRepo.remove(teamRepo.findById(teamId));
        return teamRemovedDto;

    }


}
