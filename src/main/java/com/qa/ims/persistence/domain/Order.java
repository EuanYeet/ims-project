package com.qa.ims.persistence.domain;

public class Order {
	
	private Long id;
	private Long userID;
	private Long itemID;
	private Integer quantity;
	
	

	public Order(Long userID, Long itemID, Integer quantity) {
		super();
		this.setUserID(userID);
		this.setItemID(itemID);
		this.setQuantity(quantity);
	}




	public Order(Long id, Long userID, Long itemID, Integer quantity) {
		super();
		this.setId(id);
		this.setUserID(userID);
		this.setItemID(itemID);
		this.setQuantity(quantity);
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


	public void setUserID(Long userID) {
		this.userID = userID;
	}


	public Long getItemID() {
		return itemID;
	}


	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}




	@Override
	public String toString() {
		return "Order [id=" + id + ", userID=" + userID + ", itemID=" + itemID + ", quantity=" + quantity + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		return result;
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
		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}

	
	

}
