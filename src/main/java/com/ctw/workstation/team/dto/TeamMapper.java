package com.ctw.workstation.team.dto;

import com.ctw.workstation.rack.dto.RackDto;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.entity.Team;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface TeamMapper {

    TeamDto toDto(Team team); // o gajo cria o methodo algures, posso dar nomes diferentes pelos vistos
    Team dtoToTeam(TeamDto dto);
    List<TeamDto> listToDto(List<Team> team);

}
