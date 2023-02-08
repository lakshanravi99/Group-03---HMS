package com.HotelManagement.Entities;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "transactions")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "deleteTransactionById",procedureName = "deleteTransactionById",parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "tid",type = Integer.class)
        })
})
public class Transaction {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false, length = 50)
    private String type;

    @Column(name = "amount", nullable = false, length = 50)
    private String amount;

    @Column(name = "date", nullable = false)
    private Instant date;

    @Column(name = "is_deleted", nullable = false)
    private Integer isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

}