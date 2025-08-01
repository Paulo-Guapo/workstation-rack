package com.ctw.workstation.teammember.dto;

import com.ctw.workstation.team.entity.Team;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.Date;

public class TeammemberDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String name;
    private Long team_id;
    private String ctwId;
    private LocalDateTime modifiedAt;

    public TeammemberDto(String name, Long team_id, String ctwId) {
        this.name = name;
        this.team_id = team_id;
        this.ctwId = ctwId;
    }

    public String getName() {
        return name;
    }

    public Long getTeam_id() {
        return team_id;
    }

    public String getCtwId() {
        return ctwId;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }

    public void setCtwId(String ctwId) {
        this.ctwId = ctwId;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

}
