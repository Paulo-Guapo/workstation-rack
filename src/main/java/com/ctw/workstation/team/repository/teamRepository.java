package com.ctw.workstation.team.repository;

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
public class teamRepository implements PanacheRepository<Team> {

    public Team findById(Long id){
        return find("id", id).firstResult();
    }

    public List<Team> allTeams(){
        return listAll();
    }

    public Team add(Team team){
        persist(team);
        return team;
    }

    public Team remove(Team team){
        delete(team);
        return team;
    }

    public Team update(Long id, TeamDto teamDto){

        Team team = find("id", id).firstResult();
        if (team == null) {
            throw new WebApplicationException("Rack not found", 404);
        }

        team.setName(teamDto.getName());
        team.setDefaultLocation(teamDto.getDefaultLocation());
        team.setProduct(teamDto.getProduct());
        team.setModifiedAt(LocalDateTime.now());

        return team;

    }



}
