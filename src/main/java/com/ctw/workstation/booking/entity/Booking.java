package com.ctw.workstation.booking.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.teammember.entity.Teammember;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "T_BOOKING")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingIdGenerator")
    @SequenceGenerator(name = "bookingIdGenerator", sequenceName = "SEQ_BOOKING_ID")
    private Long id;

    @Column(name = "book_from")
    private LocalDateTime bookFrom;

    @Column(name = "book_to")
    private LocalDateTime bookTo;

    //@Temporal(TemporalType.DATE) // -> deprecated
    @CreationTimestamp
    @Column(name = "created_at",insertable = false)
    private LocalDateTime createdAt;

    //@Temporal(TemporalType.DATE) // -> deprecated
    @UpdateTimestamp
    @Column(name = "modified_at",insertable = false)
    private LocalDateTime modifiedAt;

    @Column(name = "requester_id")
    private Long requesterId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id", updatable = false, insertable = false, nullable = false)
    private Teammember member;

    @Column(name = "rack_id")
    private Long rackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", updatable = false, insertable = false, nullable = false)
    private Rack rack;

    public Booking(Long requesterId, LocalDateTime bookFrom, LocalDateTime bookTo) {

        this.requesterId = requesterId;
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;

    }

    public Booking() {

    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getBookFrom() {
        return bookFrom;
    }

    public LocalDateTime getbookTo() {
        return bookTo;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getRequesterId() {
        return requesterId;
    }

    public Long getRackId() {
        return rackId;
    }

    public Teammember getMember() {
        return member;
    }

    public Rack getRack() {
        return rack;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookFrom(LocalDateTime bookFrom) {
        this.bookFrom = bookFrom;
    }

    public void setbookTo(LocalDateTime bookTo) {
        this.bookTo = bookTo;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    public void setMember(Teammember member) {
        this.member = member;
    }

    public void setRackId(Long rackId) {
        this.rackId = rackId;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

}
