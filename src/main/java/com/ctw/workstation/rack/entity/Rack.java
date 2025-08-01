package com.ctw.workstation.rack.entity;

import com.ctw.workstation.team.entity.Team;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "T_RACK")
public class Rack {

    public enum Status {
        ACTIVE,
        RETURNED,
        REPAIR,
        OUTDATED,
        BRICKED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rackIdGenerator")
    @SequenceGenerator(name = "rackIdGenerator", sequenceName = "SEQ_RACK_ID")
    private Long id;

    @Column(name = "serial_number",length = 20, nullable = false)
    private String serialNumber;

    //@Temporal(TemporalType.DATE) // -> deprecated
    @CreationTimestamp
    @Column(name = "created_at",insertable = false)
    private LocalDateTime createdAt;

    //@Temporal(TemporalType.DATE) // -> deprecated
    @UpdateTimestamp
    @Column(name = "modified_at",insertable = false)
    private LocalDateTime modifiedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", insertable = false, columnDefinition = "rack_status_enum")
    private Status status;

    @Column(name = "default_location")
    private String defaultLocation;

    @Column(name = "team_id")
    private Long teamId;

    @ManyToOne(fetch = FetchType.EAGER) // isto aqui é para dar uma vista de olhos nele, mas ao precisso dele
    @JoinColumn(name = "team_id", updatable = false, insertable = false, nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Team team;



    public Rack(String serialNumber, long teamID, String defaultLocation) {

        this.serialNumber = serialNumber;
        this.teamId = teamID;
        this.defaultLocation = defaultLocation;

    }

    public Rack() {

    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public Long getTeamId() {
        return teamId;
    }

    public Team getTeam() {
        return team;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
