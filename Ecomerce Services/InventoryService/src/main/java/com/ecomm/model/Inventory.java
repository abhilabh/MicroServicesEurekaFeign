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
public class Inventory {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int inventoryId;
	 private int productId;
	 private int quantity;

}
