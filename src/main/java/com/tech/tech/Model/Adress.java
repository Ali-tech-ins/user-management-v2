package com.tech.tech.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Adress {

    @Id
    @GeneratedValue
    private Long id;

    private String streetName;
    private String houseNumber;
    private String zipCode;


    //add getters and setters
    /**@OneToOne(mappedBy = "adress")//adress is the att in UserModel
    private UserModel userModel;*/

    /**@OneToMany(mappedBy = "adress")
    private List<UserModel> userslist;*/

    /**@ManyToMany(mappedBy = "adresses")
    private List<UserModel> userModels;*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
