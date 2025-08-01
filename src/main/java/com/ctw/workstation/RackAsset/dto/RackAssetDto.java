package com.ctw.workstation.RackAsset.dto;

import com.ctw.workstation.rack.entity.Rack;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

public class RackAssetDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String name;
    private Long rackId;
    //private Rack rack;

    public RackAssetDto(String name, Long rackId) {
        this.name = name;
        this.rackId = rackId;
        //this.rack = rack;
    }

    public RackAssetDto() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getRackId() {
        return rackId;
    }

    /*
    public Rack getRack() {
        return rack;
    }
     */




    public void setName(String name) {
        this.name = name;
    }

    public void setRackId(Long rackId) {
        this.rackId = rackId;
    }

    /*
    public void setRack(Rack rack) {
        this.rack = rack;
    }
     */



}
