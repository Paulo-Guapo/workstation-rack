package com.ctw.workstation.rack.dto;

import com.ctw.workstation.rack.entity.Rack;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface RackMapper {

    RackDto toResource(Rack rack);
    Rack fromDto(RackDto dto);
    List<RackDto> listToDto(List<Rack> racks);

    List<Rack> listTest(List<Rack> racks);

}
