package com.HotelManagement.Entities;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@DynamicInsert
@Data

@Table(name = "user")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "deleteUserById", procedureName = "deleteUserById", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Integer.class)}),
        @NamedStoredProcedureQuery(name = "updateUser", procedureName = "updateUser", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Integer.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "uusername",type = String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "utype",type = String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "uName",type = String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "ugender",type = String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "ucountry",type = String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "ureigion",type = String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "upassword",type = String.class)}),
        @NamedStoredProcedureQuery(name = "addNewUser", procedureName = "addNewUser", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "uusername",type = String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "utype",type = String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "uName",type = String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "ugender",type = String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "unic",type = String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "upassport",type = String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "ucountry",type = String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "ureigion",type = String.class),@StoredProcedureParameter(mode = ParameterMode.IN,name = "upassword",type = String.class)})
})

public class User {
    @Id
    @Column(name = "u_id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "user_type", nullable = false, length = 12)
    private String userType;

    @Column(name = "Name", nullable = false, length = 20)
    private String name;

    @Column(name = "gender", nullable = false, length = 7)
    private String gender;

    @Column(name = "nic", nullable = false, length = 20)
    private String nic;

    @Column(name = "passport", nullable = false, length = 20)
    private String passport;

    @Column(name = "country", nullable = false, length = 20)
    private String country;

    @Column(name = "reigion", nullable = false, length = 20)
    private String reigion;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getReigion() {
        return reigion;
    }

    public void setReigion(String reigion) {
        this.reigion = reigion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}