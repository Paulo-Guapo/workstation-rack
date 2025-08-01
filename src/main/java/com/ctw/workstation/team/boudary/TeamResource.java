package com.ctw.workstation.team.boudary;

import com.ctw.workstation.rack.dto.RackDto;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.dto.TeamDto;
import com.ctw.workstation.team.dto.TeamMapper;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.repository.teamRepository;
import com.ctw.workstation.team.service.TeamService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;

@Path("/team")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class TeamResource {

    @Inject
    teamRepository teamRepo;
    @Inject
    TeamMapper teamMapper;

    @Inject
    TeamService teamService; // trocar para service

    @GET
    public Response Teams(){

        return Response.ok(teamService.GetTeams()).build();

    }

    @GET
    @Path("/{teamId}")
    public Response TeamsById(@PathParam("teamId") Long teamId){

        //TeamDto newDto = teamMapper.toDto(teamRepo.findById(teamId)); // neste aqui tenho e returnar o Dto snao ele tem um stroke
        //return Response.ok(newDto).build();

        return Response.ok(teamService.GetTeamById(teamId)).build();

    }

    @POST
    public Response addTeam(TeamDto teamDto, @Context UriInfo uriInfo) { // -> recebo o dto

        Team newTeam = teamMapper.dtoToTeam(teamDto);
        teamRepo.add(newTeam);

        URI location = uriInfo.getAbsolutePathBuilder().path(newTeam.toString()).build();
        return Response.created(location).entity(newTeam).build();

    }

    @PUT
    @Path("/{teamId}")
    public Response updateTeamById(@PathParam("teamId") Long teamId, TeamDto updatedTeamDataDto) {

        /*
        if(teamRepo.findById(teamId) == null) return Response.status(Response.Status.BAD_REQUEST).build();

        teamRepo.update(teamId, updatedTeamDataDto);

        return Response.ok(updatedTeamDataDto).build();
         */

        return Response.ok(teamService.UpdateTeamById(teamId,updatedTeamDataDto)).build();

    }

    @DELETE
    @Path("/{teamId}")
    public Response removeTeamById(@PathParam("teamId") Long teamId, @Context UriInfo uriInfo) {

        /*
        try {
            TeamDto teamRemovedDto = teamMapper.toDto(teamRepo.findById(teamId));
            teamRepo.remove(teamRepo.findById(teamId));
            return Response.ok(teamRemovedDto).build();
        }catch (Exception e){

            return Response.status(Response.Status.BAD_REQUEST).build();

        }
         */
        return Response.ok(teamService.RemoveTeamById(teamId)).build(); // adicionar verificação somehow

    }

}
