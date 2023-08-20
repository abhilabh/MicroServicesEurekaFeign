package com.ecomm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private int addressId;
    private Integer doorNo;
    private String streetName;
    private String city;
    private String layout;

    @JsonIgnore
    private Customer customer;
}
