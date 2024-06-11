package com.dmanso.pizzashackSpringboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
	private String orderId;
	
	@Column
	private String pizzaType;
	
	@Column
	private int quantity;
	
	@Column
	private String customerName;
	
	@Column
	private String creditCardNumber;

	@Column
	private String address;
	
	@Column
	private boolean delivered;	
	
}
