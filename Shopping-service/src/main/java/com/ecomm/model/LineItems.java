package com.ecomm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineItems {
    
    private Integer itemId;
    private Integer productId;
    private String productName;
    private int quantity;
    private Long price;

    @JsonIgnore
    private Order orderC;
}
