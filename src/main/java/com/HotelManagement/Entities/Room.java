package com.HotelManagement.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "room")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "deleteRoomById", procedureName = "deleteRoomById", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "id",type = Integer.class)
        }),
        @NamedStoredProcedureQuery(name = "updateRoomById", procedureName = "updateRoomById", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "id",type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "rSize",type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "rCapacity",type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "rBed",type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "rServices",type = String.class)
        }),
        @NamedStoredProcedureQuery(name = "addNewRoom", procedureName = "addNewRoom", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "rSize",type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "rCapacity",type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "rBed",type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "rServices",type = String.class)
        })

})
public class Room {
    @Id
    @Column(name = "room_id", nullable = false)
    private Integer id;

    @Column(name = "Size")
    private Integer size;

    @Column(name = "Capacity",length = 50)
    private String capacity;

    @Column(name = "Bed", length = 12)
    private String bed;

    @Column(name = "Services",length = 150)
    private String services;

    @Column(name = "status", length = 150)
    private Integer status;

    @Column(name = "is_available")
    private Integer available;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}