package com.ctw.workstation.RackAsset.dto;

import com.ctw.workstation.RackAsset.entity.RackAsset;
import com.ctw.workstation.rack.dto.RackDto;
import com.ctw.workstation.rack.entity.Rack;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface RackAssetMapper {

    RackAssetDto toDto(RackAsset rackAsset);
    RackAsset fromDto(RackAssetDto dto);
    List<RackAssetDto> listToDto(List<RackAsset> racksAssets);

}
