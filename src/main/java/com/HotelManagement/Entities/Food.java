package com.HotelManagement.Entities;

import javax.persistence.*;

@Entity
@Table(name = "foods")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "deleteFood",procedureName = "deleteFood",parameters = {
                @StoredProcedureParameter(name = "id",type = Integer.class,mode = ParameterMode.IN)
        }),
        @NamedStoredProcedureQuery(name = "addFood",procedureName = "addFood",parameters = {
                @StoredProcedureParameter(name = "foodName",mode = ParameterMode.IN,type = String.class),
                @StoredProcedureParameter(name = "price",mode = ParameterMode.IN,type = Integer.class)
        })
})
public class Food {
    @Id
    @Column(name = "f_id", nullable = false, length = 11)
    private Integer id;

    @Column(name = "foodname", nullable = false, length = 11)
    private String foodname;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "Availability", nullable = false,length = 5)
    private Integer Availability;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAvailability() {
        return Availability;
    }

    public void setAvailability(Integer availability) {
        Availability = availability;
    }
}