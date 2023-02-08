package com.HotelManagement.Entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "foodorder")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "cancelOrderadmin",procedureName = "cancelOrderadmin",parameters = {
                @StoredProcedureParameter(name = "id",mode = ParameterMode.IN,type = Integer.class)
        }),
        @NamedStoredProcedureQuery(name = "approveOrder",procedureName = "approveOrder",parameters = {
                @StoredProcedureParameter(name = "id",mode = ParameterMode.IN,type = Integer.class)
        }),
        @NamedStoredProcedureQuery(name = "orderFood",procedureName = "orderFood",parameters = {
                @StoredProcedureParameter(name = "foodName",mode = ParameterMode.IN,type = String.class),
                @StoredProcedureParameter(name = "room",mode = ParameterMode.IN,type = Integer.class),
                @StoredProcedureParameter(name = "qty",mode = ParameterMode.IN,type = Integer.class),

        })
})
public class Foodorder {
    @Id
    @Column(name = "orderid", nullable = false)
    private Integer id;

    @Column(name = "foodName")
    private String foodName;

    @Column(name = "room")
    private Integer room;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "kitchen_status")
    private String kitchen_status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {

        this.createdAt = createdAt;
    }

    public String getKitchen_status() {
        return kitchen_status;
    }

    public void setKitchen_status(String kitchen_status) {
        this.kitchen_status = kitchen_status;
    }
}