package com.revature.db;

import com.revature.models.Teddy;

public interface TeddyCollectionInterface {
	//I'm going to write out abstract methods that reflect the methods LegoCollection should have/implement
	
	Teddy[] getAllTeddies(); //this method will show the user all LegoSets in the database
	
	Teddy getTeddyById(int idInput); //this method will return one LegoSet of a given id 
	
	void addTeddy(Teddy Teddy); //this method will let the user input a new LegoSet into their collection
	

}
