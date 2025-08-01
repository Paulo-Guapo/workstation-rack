package com.ctw.workstation.RackAsset.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "T_RACK_ASSET")
public class RackAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teamIdGenerator")
    @SequenceGenerator(name = "teamIdGenerator", sequenceName = "SEQ_TEAM_ID")
    private Long id;

    @Column(name = "asset_tag",length = 50, nullable = false) // problema aqui
    private String name;

    @Column(name = "rack_id")
    private Long rackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", updatable = false, insertable = false, nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Rack rack;

    public RackAsset(String name, Long rackId) {

        this.name = name;
        this.rackId = rackId;

    }

    public RackAsset() {



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

    public Rack getRack() {
        return rack;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRackId(Long rackId) {
        this.rackId = rackId;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }
}
