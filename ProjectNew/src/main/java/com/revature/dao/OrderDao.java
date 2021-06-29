package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.revature.models.Teddy;
import com.revature.models.Order;
import com.revature.utils.ConnectionUtil;


public class OrderDao implements OrderDaoIntreface{
	
	
	public List<Order> getOrderByOrderId(int  order_id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //date formatter formats dates 
			
			Date date = new Date(); //new date from java.util package
			
			String currentOrderDate = dateFormat.format(date);
			
			//initialize an empty ResultSet that will store the results of our query 
			ResultSet rs = null; //we need this for select statements, so that the returned data can get stored
			
			//write the query, assign it to a String variable
			String sql = "SELECT * FROM \"Teddy\".orders where order_id = ?;"; 
			
			//creating an object to send the query to our DB using our Connection object's createStatement() method
			PreparedStatement ps = conn.prepareStatement(sql); 
			
			//set the wildcard to the title the user inputs
			ps.setInt(1, order_id);
			
			//execute the query (sql)  
			rs = ps.executeQuery(); 
			
			
			List<Order> returnedOrder = new ArrayList<>(); //create a List that will be populated with the returned role

			
			while(rs.next()) { //while there are results left in the ResultSet (rs)
				
				//to create new Teddy from each returned record
				Order order = new Order(
						rs.getInt("order_id"),
						rs.getInt("teddy_Id"),
						rs.getInt("quantity"),
						rs.getInt("unit_price"),
						rs.getInt("total_price"),
						rs.getDate("order_date")
						
					);
				
				//add the newly created teddy object into the ArrayList of Employees
				returnedOrder.add(order);

			}
			
			return returnedOrder; //Finally, if successful, return the List of Employees
			
			
			
		} catch(SQLException e) {
			System.out.println("get teddy item  by order_id failed");
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<Order> getOrderByQuantity(int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderQuantity(int newQuantity, int OrderUnit_price) {
		// TODO Auto-generated method stub
		
	}

	
}
