package com.cts.pss.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Inventory {

	@Id
	@GeneratedValue
	private int inventoryId;
	private int count;

	public int getInventoryId() {
		return inventoryId;
	}

	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	public Inventory(int count) {
		super();
		this.count = count;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
