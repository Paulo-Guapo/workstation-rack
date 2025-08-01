package com.ctw.workstation.teammember.boudary;

import com.ctw.workstation.team.dto.TeamDto;
import com.ctw.workstation.team.dto.TeamMapper;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.repository.teamRepository;
import com.ctw.workstation.teammember.dto.TeammemberDto;
import com.ctw.workstation.teammember.dto.TeammemberMapper;
import com.ctw.workstation.teammember.entity.Teammember;
import com.ctw.workstation.teammember.repositoy.teammemberRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;

@Path("/teammember")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class TeammemberResource {

    @Inject
    teammemberRepository teammemberRepo;
    @Inject
    TeammemberMapper teammemberMapper;

    @GET
    public Response Teammembers(){

        List<TeammemberDto> dtoAllList = teammemberMapper.listToDto(teammemberRepo.allTeammembers());

        return Response.ok(dtoAllList).build();

    }

    @GET
    @Path("/{teammemberId}")
    public Response TeamsById(@PathParam("teammemberId") Long teammemberId){

        TeammemberDto newDto = teammemberMapper.toDto(teammemberRepo.findById(teammemberId));
        return Response.ok(newDto).build();

    }

    @POST
    public Response addTeammember(TeammemberDto teammemberDto, @Context UriInfo uriInfo) {

        Teammember newTeammember = teammemberMapper.dtoToTeam(teammemberDto);
        teammemberRepo.add(newTeammember);

        URI location = uriInfo.getAbsolutePathBuilder().path(newTeammember.toString()).build();
        return Response.created(location).entity(newTeammember).build();

    }

    @PUT
    @Path("/{teammemberId}")
    public Response updateTeammemberById(@PathParam("teammemberId") Long teammemberId, TeammemberDto updatedTeammemberDataDto) {

        if(teammemberRepo.findById(teammemberId) == null) return Response.status(Response.Status.BAD_REQUEST).build();

        teammemberRepo.update(teammemberId, updatedTeammemberDataDto);

        return Response.ok(updatedTeammemberDataDto).build();

    }

    @DELETE
    @Path("/{teammemberId}")
    public Response removeTeammemberById(@PathParam("teammemberId") Long teammemberId, @Context UriInfo uriInfo) {

        try {
            TeammemberDto teamRemovedDto = teammemberMapper.toDto(teammemberRepo.findById(teammemberId));
            teammemberRepo.remove(teammemberRepo.findById(teammemberId));
            return Response.ok(teamRemovedDto).build();
        }catch (Exception e){

            return Response.status(Response.Status.BAD_REQUEST).build();

        }

    }

}
