package com.ctw.workstation.RackAsset.boudary;

import com.ctw.workstation.RackAsset.dto.RackAssetDto;
import com.ctw.workstation.RackAsset.dto.RackAssetMapper;
import com.ctw.workstation.RackAsset.entity.RackAsset;
import com.ctw.workstation.RackAsset.repository.rackAssetRepository;
import com.ctw.workstation.team.dto.TeamDto;
import com.ctw.workstation.team.dto.TeamMapper;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.repository.teamRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;

@Path("/rackAssets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RackAssetResource {

    @Inject
    rackAssetRepository rackAssetRepo;
    @Inject
    RackAssetMapper rackAssetMapper;

    @GET
    public Response RackAsset(){

        List<RackAssetDto> dtoAllList = rackAssetMapper.listToDto(rackAssetRepo.allRackAssets());

        return Response.ok(dtoAllList).build();

    }

    @GET
    @Path("/{rackAssetId}")
    public Response RackAssetById(@PathParam("rackAssetId") Long rackAssetId){

        RackAssetDto newDto = rackAssetMapper.toDto(rackAssetRepo.findById(rackAssetId)); // neste aqui tenho e returnar o Dto snao ele tem um stroke
        return Response.ok(newDto).build();

    }

    @POST
    public Response addRackAsset(RackAssetDto rackAssetDto, @Context UriInfo uriInfo) { // -> recebo o dto

        RackAsset newRackAsset = rackAssetMapper.fromDto(rackAssetDto);
        rackAssetRepo.add(newRackAsset);

        URI location = uriInfo.getAbsolutePathBuilder().path(newRackAsset.toString()).build();
        return Response.created(location).entity(newRackAsset).build();

    }

    @PUT
    @Path("/{rackAssetId}")
    public Response updateRackAssetById(@PathParam("rackAssetId") Long rackAssetId, RackAssetDto updatedRackAssetDataDto) {

        if(rackAssetRepo.findById(rackAssetId) == null) return Response.status(Response.Status.BAD_REQUEST).build();

        rackAssetRepo.update(rackAssetId, updatedRackAssetDataDto);

        return Response.ok(updatedRackAssetDataDto).build();

    }

    @DELETE
    @Path("/{rackAssetId}")
    public Response removeRackAssetById(@PathParam("rackAssetId") Long rackAssetId, @Context UriInfo uriInfo) {

        try {
            RackAssetDto teamRemovedDto = rackAssetMapper.toDto(rackAssetRepo.findById(rackAssetId));
            rackAssetRepo.remove(rackAssetRepo.findById(rackAssetId));
            return Response.ok(teamRemovedDto).build();
        }catch (Exception e){

            return Response.status(Response.Status.BAD_REQUEST).build();

        }

    }

}
