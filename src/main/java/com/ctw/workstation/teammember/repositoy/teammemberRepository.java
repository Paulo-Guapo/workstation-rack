package com.ctw.workstation.teammember.repositoy;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.dto.TeamDto;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.teammember.dto.TeammemberDto;
import com.ctw.workstation.teammember.entity.Teammember;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
@ApplicationScoped
public class teammemberRepository implements PanacheRepository<Teammember> {

    public Teammember findById(Long id){
        return find("id", id).firstResult();
    }

    public List<Teammember> allTeammembers(){
        return listAll();
    }

    public Teammember add(Teammember teammember){
        persist(teammember);
        return teammember;
    }

    public Teammember remove(Teammember teammember){
        delete(teammember);
        return teammember;
    }

    public Teammember update(Long id, TeammemberDto teammemberDto){

        Teammember teammember = find("id", id).firstResult();
        if (teammember == null) {
            throw new WebApplicationException("Rack not found", 404);
        }

        teammember.setName(teammemberDto.getName());
        teammember.setCtwId(teammemberDto.getCtwId());
        teammember.setTeam_id(teammemberDto.getTeam_id());
        teammember.setModifiedAt(LocalDateTime.now());


        return teammember;

    }

}
