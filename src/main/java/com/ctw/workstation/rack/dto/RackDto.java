package com.ctw.workstation.rack.dto;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.teammember.entity.Teammember;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

public class RackDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String serialNumber;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Rack.Status status;
    private String defaultLocation;
    private Long teamId;
    //private Team team; // nao tenho de ter isto aqui, ele faz sozinho

    public RackDto(String serialNumber, LocalDateTime createdAt, LocalDateTime modifiedAt, Rack.Status status, Long teamId, String defaultLocation) {

        this.serialNumber = serialNumber;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.status = status;
        this.teamId = teamId;
        this.defaultLocation = defaultLocation;
        //this.team = team;
    }

    public RackDto() {

    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public Rack.Status getStatus() {
        return status;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public Long getTeamId() {
        return teamId;
    }

    /*
    public Team getTeam() {
        return team;
    }
     */


    public void setId(Long id) {
        this.id = id;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setStatus(Rack.Status status) {
        this.status = status;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /*
    public void setTeam(Team team) {
        this.team = team;
    }
     */

}
