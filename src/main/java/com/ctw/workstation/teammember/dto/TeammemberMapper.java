package com.ctw.workstation.teammember.dto;

import com.ctw.workstation.team.dto.TeamDto;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.teammember.entity.Teammember;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface TeammemberMapper {

    TeammemberDto toDto(Teammember teammember);
    Teammember dtoToTeam(TeammemberDto dto);
    List<TeammemberDto> listToDto(List<Teammember> teammember);

}
