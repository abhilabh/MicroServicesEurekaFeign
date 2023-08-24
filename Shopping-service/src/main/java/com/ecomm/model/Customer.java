package com.ecomm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    
    private int customerId;
    private String customerName;
    private String email;

    private List<Address> billingAddresses;

    private List<Address> shippingAddresses;
}