package com.revature.models;

public class Teddy {
	public int TeddyId; //we'll use this to uniquely identify each LegoSet object
	  //setting this to be public so that we can set the id in the addLegoSet method
String colors; 
String name;
String description;
double price;
public int length;



//boilerplate code below: Constructors and toString()-----------------------------------------

//no args constructor (chose constructor from super class)
public Teddy() {
super();
//TODO Auto-generated constructor stub
}


//all-args constructor (chose constructor from fields)
public Teddy( String colors, String name, String description, double price ) {
super();
//this.TeddyId = TeddyId;
this.colors = colors;
this.name = name;
this.description = description;
this.price = price;
}




}
