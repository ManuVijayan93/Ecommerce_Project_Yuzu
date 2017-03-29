package com.yuzu.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cart implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int quantity;
	private double totalPrice;

}
