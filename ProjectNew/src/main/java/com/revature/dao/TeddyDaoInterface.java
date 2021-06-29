package com.revature.dao;
import java.util.List;
import com.revature.models.Teddy;

public interface TeddyDaoInterface {
	
	//to return a List of all teddies
	
	public List<Teddy> getTeddies();
	
	//to take a new Teddy object and add it to the database
	 public void addTeddy(Teddy ted);
	 
	 //to replace teddy's colors by teddy_name
	 public void replaceColors(String tedName, String teddyColors);
	 
	 //to delete an item (teddy)
	 public void removeTeddy(String tedName); 
	 
	 //to return a List of teddies with specific unit price
	 
	 public List<Teddy> getTeddyByUnitPrice(int unit_price);

	void removeTeddy(int tId);

}
