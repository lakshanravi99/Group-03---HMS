package com.HotelManagement.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "room_reserve")
public class RoomReserve {
    @Id
    @Column(name = "roomid", nullable = false, length = 11)
    private String id;

    @Column(name = "status", nullable = false, length = 11)
    private String status;

    @Column(name = "reserved_by", nullable = false)
    private Integer reservedBy;

    @Column(name = "date", nullable = false)
    private Instant date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(Integer reservedBy) {
        this.reservedBy = reservedBy;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

}