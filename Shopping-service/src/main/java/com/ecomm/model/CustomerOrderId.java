package com.ecomm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerOrderId {
	@Id
	int orderId;
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    @JsonIgnore
	CustomerOrder cOrder;
}
