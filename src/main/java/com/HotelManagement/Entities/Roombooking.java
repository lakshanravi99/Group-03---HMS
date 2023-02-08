package com.HotelManagement.Entities;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "roombooking")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "addNewBooking", procedureName = "addNewBooking", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "uname",type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "unic",type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "pcount",type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "dcount",type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "roomid",type = Integer.class)
        }),
        @NamedStoredProcedureQuery(name = "deleteBookingById",procedureName = "deleteBookingById", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "bid",type = Integer.class)
        })
})
public class Roombooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "nic", nullable = false, length = 50)
    private String nic;

    @Column(name = "persons_count", nullable = false)
    private Integer personsCount;

    @Column(name = "days_count", nullable = false)
    private Integer daysCount;

    @JoinColumn(name = "room_id", nullable = false)
    private Integer room_id;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Integer getPersonsCount() {
        return personsCount;
    }

    public void setPersonsCount(Integer personsCount) {
        this.personsCount = personsCount;
    }

    public Integer getDaysCount() {
        return daysCount;
    }

    public void setDaysCount(Integer daysCount) {
        this.daysCount = daysCount;
    }

    public Integer getRoom() {
        return room_id;
    }

    public void setRoom(Integer room) {
        this.room_id = room_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}