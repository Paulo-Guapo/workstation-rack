package com.ctw.workstation.RackAsset.repository;

import com.ctw.workstation.RackAsset.dto.RackAssetDto;
import com.ctw.workstation.RackAsset.entity.RackAsset;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.dto.TeamDto;
import com.ctw.workstation.team.entity.Team;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
@ApplicationScoped
public class rackAssetRepository implements PanacheRepository<RackAsset> {

    public RackAsset findById(Long id){
        return find("id", id).firstResult();
    }

    public RackAsset add(RackAsset rackAsset){
        persist(rackAsset);
        return rackAsset;
    }

    public List<RackAsset> allRackAssets(){

        return listAll();
    }

    public RackAsset remove(RackAsset rackAsset){
        delete(rackAsset);
        return rackAsset;
    }

    public RackAsset update(Long id, RackAssetDto rackAssetDto){

        RackAsset rackAsset = find("id", id).firstResult();
        if (rackAsset == null) {
            throw new WebApplicationException("rackAsset not found", 404);
        }

        rackAsset.setName(rackAssetDto.getName());
        rackAsset.setRackId(rackAssetDto.getRackId());
        //rackAsset.setRack(rackAssetDto.getRack());

        return rackAsset;

    }


}
