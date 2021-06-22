package com.revature.db;

import com.revature.models.Teddy;

//
public abstract class TeddyCollection  implements TeddyCollectionInterface{
	private static final Teddy[] Teddy = null;
	private static com.revature.models.Teddy[] Teddies = null;


	public Teddy[] getAllTeddies() {
		return Teddies; //return the entire array of Teddies
	}


	public Teddy getTeddyById(int idInput) {
		return Teddy[idInput - 1]; //return the Teddy at index idInput - 1
		//we need to put idInput - 1 for the index, because arrays are zero indexed!
		//If the user searches for Teddy id 3, and we don't include -1...
			//The Teddy of id 4 would be returned. 
		
		//we could have avoided this if we make Ids start with 0,
		//but in SQL, they tend to start with 1 so you'll usually be doing stuff like this
	}


	//This method takes a Teddy object as a parameter (The menu will ask for inputs to construct a LegoSet object)
	public void addTeddy(com.revature.models.Teddy Teddy) {
		
		//if we want to add a new LegoSet to the Array, we'll need a bigger Array (since they're fixed in size)
		Teddy[] newArray = new Teddy[Teddy.length + 1];
		
		//populate the new array with the contents of the old one (note this will leave one null spot)
		for(int i = 0; i<Teddies.length; i++) {
			newArray[i] = Teddies[i];
		}
		
		//we're setting the ID of the new LegoSet to the size of the Array. effectively incrementing the Ids by 1
		Teddy.TeddyId = newArray.length; //normally, we'd use private variables and a setter method
		
		//"Set the last (null) index of the newArray to the new user-inputted LegoSet.
		newArray[Teddies.length] = Teddy;
		
		//assign the new Array to the main Array we're using
		Teddies = newArray;
	}



	


}
