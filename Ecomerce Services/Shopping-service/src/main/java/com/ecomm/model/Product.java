package com.ecomm.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	 private int productId;
	 private String productName;

	 private String productDescription;
	 private Long productPrice;

}
