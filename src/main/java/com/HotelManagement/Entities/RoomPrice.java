package com.HotelManagement.Entities;

import javax.persistence.*;

@Entity
@Table(name = "room_prices")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "updateRoomPriceById", procedureName = "updateRoomPriceById",parameters = {
                @StoredProcedureParameter(name = "rid",mode = ParameterMode.IN,type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "rroomid",type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "rtype",type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "rprice",type = Double.class)
        }),
        @NamedStoredProcedureQuery(name = "deleteRoomPriceById",procedureName = "deleteRoomPriceById",parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "rid",type = Integer.class)
        }),
        @NamedStoredProcedureQuery(name = "addNewRoomPrice",procedureName = "addNewRoomPrice",parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "rroomid",type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "rtype",type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "rprice",type = Double.class),
        })
})
public class RoomPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "room_id", nullable = false)
    private Integer roomId;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @Column(name = "price", nullable = false)
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}