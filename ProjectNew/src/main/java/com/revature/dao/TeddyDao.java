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

import com.revature.models.Order;
import com.revature.models.Teddy;
import com.revature.utils.ConnectionUtil;

public class TeddyDao implements TeddyDaoInterface {
	
	
	
		//private static final Teddy teddy = null;
		public List<Teddy> getTeddies(){// to select functionality
			//to establish a DB connection
			try(Connection conn = ConnectionUtil.getConnection()){
				
				//Result set to store the results of queries
				ResultSet rs = null;
			// assign query to a String variable
				String sql = "SELECT * FROM \"Teddy\".teddies;";
				
				//to create an object that sent the query to the DB
				Statement s = conn.createStatement();
				
				//to execute the query
				rs = s.executeQuery(sql);
				
				//list to be populated with returned items
				List<Teddy> teddyList = new ArrayList<>();
				
				//to know if result are left in the ResultSet
				while(rs.next()) {
					//to create a new Teddy object
					Teddy teddy = new Teddy(
					          rs.getInt("teddy_id"),
					          rs.getString("teddy_name"),
					          rs.getString("teddy_colors"),
					          rs.getString("teddy_description")
					          );
					//to add new Teddy object into the ArrayList of Teddies
					teddyList.add(teddy);
					
				}
				//to successfully return the lst of Teddies
				return teddyList;
				
				//to catch any event that wrongly access our data
				
			} catch (SQLException e) {
				System.out.println(" Oof! Something went wrong when trying to access your DB");
				
				//is a tool used to handle exceptions and errors. It is a method of Java's throwable class which prints the throwable along with other details like the line number and class 
				//name where the exception occurred.
				e.printStackTrace();
			}
			//to confirm that the try is successful
			return null;
		}
		
		@Override

		public void addTeddy(Teddy t) {
			
			try(Connection conn = ConnectionUtil.getConnection()){
				
				//Statement using parameters to insert a new Teddy
				String sql = "INSERT INTO \"Teddy\".teddies (teddy_name, teddy_colors, teddy_description)"
				             
						    + "VALUES (?, ?, ?);";
				
				
				//let's use PreparedStatement(a pre-compiled SQL statement. A subinterface of Statement
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				//this requires two arguments, the number of the "?", and the value to give it
				
				ps.setString(1, t.getTeddy_name());
				ps.setString(2, t.getTeddy_colors());
				//ps.setDate(3, java.sql.Date.valueOf(currentDate)); //this takes our Java Date, and turns it into a SQL Date.
				ps.setString(3, t.getTeddy_description());
				//this method actually sends and executes the SQL command that we built
				ps.executeUpdate();
				
				//to send successful confirmation to the console
				System.out.println("Teddy" + t.getTeddy_name() + "created. Order is placed. Thanks!");
			} 
			catch(SQLException e) {
				System.out.println("Add teddy failed!");
				e.printStackTrace();
			}
			}
		
		public void changeTeddyColors(int teddy_Id, String teddy_colorsInput) {
			try(Connection conn = ConnectionUtil.getConnection()){
				
				String sql = "UPDATE \"Teddy\".teddies SET teddy_colors = ? WHERE teddy_id = ?;";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				//To add value to the wilcard parameters based on the user's input
				
				ps.setString(1, teddy_colorsInput);
				//String teddyId = null;
				//ps.setInt(2, teddy_Id);
				ps.setInt(2, teddy_Id);
				
				//to run the PreparedStatement that we've given values to its parameters
				ps.executeUpdate();
				
				System.out.println("Teddy teddy_colors  changed to : " + teddy_colorsInput);
				
			} catch (SQLException e) {
				System.out.println("Change role failed!");
				e.printStackTrace();
			}
			}
		
			
			@Override
			public void removeTeddy(int  tId) {
				
				 try(Connection conn = ConnectionUtil.getConnection()){
					 
					 String sql = "DELETE FROM \"Teddy\".teddies WHERE teddy_id = ?;";
					 
					 PreparedStatement ps = conn.prepareStatement(sql);
					 
					 ps.setInt(1, tId);
					 ps.executeUpdate();
					 
					 System.out.println("This item is no longer exist, please check later" + tId);
					 
				 } catch (SQLException e) {
						System.out.println("Delete teddy failed!");
						e.printStackTrace();
					}
				 }
			public List<Teddy> getTeddiesByUnitPrice(int unit_price){
				
				try(Connection conn = ConnectionUtil.getConnection()){
					ResultSet rs = null;
					
					String sql = "select * from \"Teddy\".teddies join \"Teddy\".orders "
							        + "on teddies.teddy_id = teddies_order_Id where orders.unit_price = ?;";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1,  unit_price);
					
					rs = ps.executeQuery();
					
					List<Teddy> teddyList = new ArrayList<>();
					
					while(rs.next()) {
						
						Teddy t = new Teddy(
								       rs.getInt("teddy_id"),
								       rs.getString("teddy_name"),
								       rs.getString("teddy_colors"),
								       rs.getString("teddy_description")
								       );
						
						teddyList.add(t);
								       		
					}
					return teddyList;
					
				} catch (SQLException e) {
					System.out.println("Something went wrong with your SQL!");
					e.printStackTrace();
				}
				
				return null;
					
			}

			@Override
			public void replaceColors(String tedName, String teddyColors) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void removeTeddy(String tedName) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public List<Teddy> getTeddyByUnitPrice(int unit_price) {
				// TODO Auto-generated method stub
				return null;
			}

			public List<Order> getOrdersById(String orderInput) {
				// TODO Auto-generated method stub
				return null;
			}

			public void changeTeddyColors(int idInput, int teddy_colorsInput) {
				// TODO Auto-generated method stub
				
			}

					
}







