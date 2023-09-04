package com.tech.tech.Model;

import java.io.Serializable;

public class UserDTO {

    String name ;
    String email ;
    Long addressId;

    public UserDTO(String name, String email,Long addressId) {
        this.name = name;
        this.email = email;
        this.addressId=addressId;
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

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
