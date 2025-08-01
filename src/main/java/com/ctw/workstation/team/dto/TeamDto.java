package com.ctw.workstation.team.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Date;

public class TeamDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String name;
    private String product;
    private String defaultLocation;

    public TeamDto(LocalDateTime createdAt, LocalDateTime modifiedAt, String name, String product, String defaultLocation) {

        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.name = name;
        this.product = product;
        this.defaultLocation = defaultLocation;
    }

    public TeamDto() {

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
}
