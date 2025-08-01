package com.ctw.workstation.team.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "T_TEAM")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teamIdGenerator")
    @SequenceGenerator(name = "teamIdGenerator", sequenceName = "SEQ_TEAM_ID")
    private Long id;

    //@Temporal(TemporalType.DATE) // -> deprecated
    @CreationTimestamp
    @Column(name = "created_at", insertable = false)
    private LocalDateTime createdAt;

    //@Temporal(TemporalType.DATE) // -> deprecated
    @UpdateTimestamp
    @Column(name = "modified_at",insertable = false)
    private LocalDateTime modifiedAt;

    @Column(name = "name",length = 50, nullable = false)
    private String name;

    @Column(name = "product",length = 50, nullable = false)
    private String product;

    @Column(name = "default_location")
    private String defaultLocation;

    public Team(String name, String product, String defaultLocation) {

        this.name = name;
        this.product = product;
        this.defaultLocation = defaultLocation;

    }

    public Team() {

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

    public void setName(String name) {
        this.name = name;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
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

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

}
