package com.revature.models;

import java.sql.Date;

import javax.sound.sampled.DataLine;
public class Order {
	
	private int order_id;
	private int teddy_id;
	private int quantity;
	private int unit_price;
	private int total_price;
	private Date order_date;
	public Order() {
		super();
		
	}
	public Order(int order_id, int teddy_Id, int quantity, int unit_price, int total_price, Date order_date) {
	     super();
	     this.order_id = order_id;
	     this.teddy_id = teddy_Id;
	     this.quantity = quantity;
	     this.unit_price = unit_price;
	     this.total_price = total_price;
	     this.order_date = order_date;
	}
	
	public Order(int quantiy, int unit_price)
	{
		super();
		this.order_id = order_id;
		this.unit_price = unit_price;
		
		
	
}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", unit_price=" + unit_price + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order_date == null) ? 0 : order_date.hashCode());
		result = prime * result + order_id;
		result = prime * result + quantity;
		result = prime * result + teddy_id;
		result = prime * result + total_price;
		result = prime * result + unit_price;
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
		if (order_date == null) {
			if (other.order_date != null)
				return false;
		} else if (!order_date.equals(other.order_date))
			return false;
		if (order_id != other.order_id)
			return false;
		if (quantity != other.quantity)
			return false;
		if (teddy_id != other.teddy_id)
			return false;
		if (total_price != other.total_price)
			return false;
		if (unit_price != other.unit_price)
			return false;
		return true;
	}
	
	public int getOrder_id() {
		return order_id;
	}
	
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	public int getTeddy_id() {
		return teddy_id;
	}
	
	public void setTeddy_id(int teddy_id) {
		this.teddy_id = teddy_id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}
	
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	
}