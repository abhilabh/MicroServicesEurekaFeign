package com.ecomm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.model.Inventory;
import java.util.List;


public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	
	public Inventory findByProductId(int productId);

}
