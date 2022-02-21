package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private Long id;
	private Long userID;
	private Double totalCost;
	
	private List<ItemOrder> items;
	
	

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Order(Long userID) {
		super();
		this.userID = userID;
		this.items = new ArrayList<ItemOrder>();
	}

	public Order(Long id, Long userID) {
		super();
		this.id = id;
		this.userID = userID;
		this.items = new ArrayList<ItemOrder>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserID() {
		return userID;
	}

	

	public List<ItemOrder> getItems() {
		return items;
	}

	public void setItems(List<ItemOrder> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userID=" + userID + ", items=" + items + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}

	

}
