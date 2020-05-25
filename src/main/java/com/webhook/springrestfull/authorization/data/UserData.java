package com.webhook.springrestfull.authorization.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "userdatas")
@ApiModel(description = "All details about the user")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size(min = 5, message = "Name should have at least 5 characters")
    private String name;
    @Size(min = 8)
    private String email;
    private String phone;
    @Past
    @ApiModelProperty(notes="Birth date should be in the past")
    private Date dob;

    public UserData(){}
    public UserData(String name, String email, String phone, Date dob) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;

    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob(){
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }

}
