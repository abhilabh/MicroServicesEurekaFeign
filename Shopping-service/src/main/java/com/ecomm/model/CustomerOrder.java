package com.ecomm.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerOrder {
	@Id
	int cutomerId;
	 @OneToMany(mappedBy = "cOrder", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	 List<CustomerOrderId> orderIdList;
}
