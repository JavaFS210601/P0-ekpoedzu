package com.revature.dao;
import java.util.List;

import com.revature.models.Order;
public interface OrderDaoIntreface {
public List<Order> getOrderByQuantity(int quantity); 
	
	public void updateOrderQuantity(int newQuantity, int OrderUnit_price);
	

}
