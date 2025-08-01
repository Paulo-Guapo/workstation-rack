package com.ctw.workstation.booking.dto;

import com.ctw.workstation.teammember.entity.Teammember;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

public class BookingDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private LocalDateTime bookFrom;
    private LocalDateTime bookTo;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Long requesterId;
    private Long rackId;

    public BookingDto(LocalDateTime bookFrom, LocalDateTime bookTo, LocalDateTime modifiedAt, Long requesterId, Long rackId) {
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
        this.modifiedAt = modifiedAt;
        this.requesterId = requesterId;
        this.rackId = rackId;
    }

    public BookingDto() {


    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getBookFrom() {
        return bookFrom;
    }

    public LocalDateTime getBookTo() {
        return bookTo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public Long getRackId() {
        return rackId;
    }

    public Long getRequesterId() {
        return requesterId;
    }

    public void setBookFrom(LocalDateTime bookFrom) {
        this.bookFrom = bookFrom;
    }

    public void setBookTo(LocalDateTime bookTo) {
        this.bookTo = bookTo;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    public void setRackId(Long rackId) {
        this.rackId = rackId;
    }
}
