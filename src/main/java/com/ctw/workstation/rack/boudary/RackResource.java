package com.ctw.workstation.rack.boudary;

import com.ctw.workstation.rack.dto.RackDto;
import com.ctw.workstation.rack.dto.RackMapper;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.repository.RackRepository;
import com.ctw.workstation.team.dto.TeamDto;
import com.ctw.workstation.team.dto.TeamMapper;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.repository.teamRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.jboss.logging.Logger;


import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("/rack")
@Consumes(MediaType.APPLICATION_JSON)
@Produces("text/html")


public class RackResource {

    @Inject
    RackRepository rackRepo;
    @Inject
    RackMapper rackMapper;

    public static final Logger log = Logger.getLogger(RackResource.class);

    private ArrayList<Rack> racks = new ArrayList<>();

    public RackResource() {

        // Adicionar cenas ja aqui para nao ter de estar sempre a fazer
        // Se fizer o mesmo com otros resources, ele sabe a ordem? deve dar coco

        //racks.add(new Rack("nome", "descricao" ));
        //racks.add(new Rack("32146","1000-12021-01","Active",1));
        //racks.add(new Rack("32142","1000-12021-01","NOT Active",1));
        //racks.add(new Rack("32134","1000-12021-01","Diactive",1));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Racks(@QueryParam("Status") Rack.Status status){

        if(status != null) {

            List<RackDto> dtoList = rackMapper.listToDto(rackRepo.racksByStatus(status));

            return Response.ok(dtoList).build();
        }

        //List<RackDto> dtoAllList = rackMapper.listToDto(rackRepo.allRacks()); // works

        //return Response.ok(dtoAllList).build();

        List<Rack> rackList = rackMapper.listTest(rackRepo.allRacks());
        return Response.ok(rackList).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{rackId}")
    public Response RacksById(@PathParam("rackId") Long rackId){

        try { // devo usar try catch aqui? acho que sim, rackRepo deve dar uma expection qualquer
            RackDto newDto = rackMapper.toResource(rackRepo.findById(rackId)); // neste aqui tenho e returnar o Dto snao ele tem um stroke
            return Response.ok(newDto).build();
        }catch (Exception e){
            return  Response.status(Response.Status.NOT_FOUND).build();
        } // -> nao retorna o erro certo quando a rack nao existe -> usar ifs em vez de try catch

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{rackSerialNumber}")
    public Response RacksBySerialNumber(@PathParam("rackSerialNumber") String rackSerialNumber){

        try { // devo usar try catch aqui? acho que sim, rackRepo deve dar uma expection qualquer
            RackDto newDto = rackMapper.toResource(rackRepo.findBySerialNumber(rackSerialNumber)); // neste aqui tenho e returnar o Dto snao ele tem um stroke
            return Response.ok(newDto).build();
        }catch (Exception e){
            return  Response.status(Response.Status.NOT_FOUND).build();
        } // -> nao retorna o erro certo quando a rack nao existe -> usar ifs em vez de try catch

    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRack(RackDto rackDto, @Context UriInfo uriInfo) {

        Rack addedRack = rackMapper.fromDto(rackDto);
        rackRepo.add(addedRack);

        RackDto newDto = rackMapper.toResource(addedRack); // isto é silly maybe

        URI location = uriInfo.getAbsolutePathBuilder().path(newDto.toString()).build(); // estou a usar DTO
        return Response.created(location).entity(newDto).build(); // -> ver melhor como isto funciona

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{rackId}")
    public Response updateRackById(@PathParam("rackId") Long rackId, RackDto updatedRackDataDto) {

        if(rackRepo.findById(rackId) == null) return Response.status(Response.Status.BAD_REQUEST).build();

        //Rack updatedRack = rackRepo.updateData(rackId, updatedRackDataDto);
        rackRepo.updateData(rackId, updatedRackDataDto);

        return Response.ok(updatedRackDataDto).build();

    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeRackByJson(RackDto rackDto, @Context UriInfo uriInfo) {

        Rack newRack = rackMapper.fromDto(rackDto);
        rackRepo.remove(newRack);

        return Response.ok(newRack).build(); // o que acotece se o rack que quero eleminar nao existir?


    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{rackId}") // nestes casos nao é melhor só usar isto? maybe not. update: secalhar usa-se Post para isso tmb
    public Response removeRackById(@PathParam("rackId") Long rackId, @Context UriInfo uriInfo) {

        try {
            RackDto rackRemovedDto = rackMapper.toResource(rackRepo.findById(rackId));
            rackRepo.remove(rackRepo.findById(rackId));
            return Response.ok(rackRemovedDto).build(); // retorno o rack? // yes, for now
        }catch (Exception e){

            return Response.status(Response.Status.BAD_REQUEST).build();

        }

    }

}
