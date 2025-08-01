package com.ctw.workstation.rack.repository;

import com.ctw.workstation.rack.dto.RackDto;
import com.ctw.workstation.rack.dto.RackMapper;
import com.ctw.workstation.rack.entity.Rack;
import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
@ApplicationScoped
public class RackRepository implements PanacheRepository<Rack> {

    public Rack findById(Long id){
        return find("id", id).firstResult();
    }

    public Rack findBySerialNumber(String serialNumber){
        return find("serialNumber", serialNumber).firstResult();
    }

    public Rack add(Rack rack){
        persist(rack);
        return rack;
    }

    public Rack remove(Rack rack){
        delete(rack);
        return rack;
    }


    public List<Rack> racksByStatus(Rack.Status status){
        return list("status", status);
    }


    public List<Rack> allRacks(){
        return listAll();
    }

    public Rack updateData(Long id, RackDto rackDto){

        //Verificar se o rack existe primeiro
        Rack rack = findById(id);
        if (rack == null) {
            throw new WebApplicationException("Rack not found", 404);
        }

        rack.setModifiedAt(LocalDateTime.now());
        rack.setDefaultLocation(rackDto.getDefaultLocation());
        rack.setTeamId(rackDto.getTeamId());
        rack.setStatus(rackDto.getStatus());
        rack.setSerialNumber(rackDto.getSerialNumber());

        //persist(rack); //Aparentemente nao precisso de presist quando é para dar update, ele faz automaticamente?

        return rack;

    }




}
