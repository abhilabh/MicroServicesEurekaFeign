package com.ecomm.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int productId;
	 private String productName;

	 private String productDescription;
	 private Long productPrice;

}
