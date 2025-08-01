package com.ctw.workstation.teammember.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.entity.Team;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "T_TEAM_MEMBER")
public class Teammember {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teammemberIdGenerator")
    @SequenceGenerator(name = "teammemberIdGenerator", sequenceName = "SEQ_TEAM_MEMBER_ID")
    private Long id;

    @Column(name = "name",length = 50, nullable = false)
    private String name;

    @Column(name = "team_id")
    private Long team_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", updatable = false, insertable = false, nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Team team;

    @Column(name = "ctw_id",length = 50, nullable = false)
    private String ctwId;

    //@Temporal(TemporalType.DATE) // -> deprecated
    @Column(name = "created_at",insertable = false)
    private LocalDateTime createdAt;

    //@Temporal(TemporalType.DATE) // -> deprecated
    @Column(name = "modified_at",insertable = false)
    private LocalDateTime modifiedAt;

    public Teammember(String name, Long team_id, String ctwId) {
        this.name = name;
        this.team_id = team_id;
        this.ctwId = ctwId;
    }

    public Teammember() {

    }

    public String getName() {
        return name;
    }

    public Long getTeam_id() {
        return team_id;
    }

    public Team getTeam() {
        return team;
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

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setCtwId(String ctwId) {
        this.ctwId = ctwId;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

}
