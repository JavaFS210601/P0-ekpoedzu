package com.revature.models;

public class Teddy {
	
	//Declare all variables needed for the project
private int teddy_id;	
private String teddy_name;
private String teddy_colors; 
private String teddy_description;




//all-args constructor (chose constructor from fields)
public Teddy( int teddy_id , String teddy_name, String teddy_colors,  String teddy_description) {
super();

//this.TeddyId = TeddyId;
this.teddy_id = teddy_id;
this.teddy_name = teddy_name;
this.teddy_colors = teddy_colors;
this.teddy_description = teddy_description;

}

//to for new items insertion
public Teddy(String teddy_name, String teddy_colors, String teddy_description) {
	super();
	this.teddy_name = teddy_name;
	this.teddy_colors = teddy_colors;
	this.teddy_description = teddy_description;
}

//to print out each object's field instead of its memory location
//(source@GenerateToString for all
@Override
public String toString() {
	return "Teddy [teddy_id=" + teddy_id + ", teddy_name=" + teddy_name + ", teddy_colors=" + teddy_colors
			+ ", teddy_description=" + teddy_description + "]";
}

//to assign each object a hashcode
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((teddy_colors == null) ? 0 : teddy_colors.hashCode());
	result = prime * result + ((teddy_description == null) ? 0 : teddy_description.hashCode());
	result = prime * result + teddy_id;
	result = prime * result + ((teddy_name == null) ? 0 : teddy_name.hashCode());
	return result;
}

//to compare objects by their hashcode (source@Generate hashcode and equals for all
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Teddy other = (Teddy) obj;
	if (teddy_colors == null) {
		if (other.teddy_colors != null)
			return false;
	} else if (!teddy_colors.equals(other.teddy_colors))
		return false;
	if (teddy_description == null) {
		if (other.teddy_description != null)
			return false;
	} else if (!teddy_description.equals(other.teddy_description))
		return false;
	if (teddy_id != other.teddy_id)
		return false;
	if (teddy_name == null) {
		if (other.teddy_name != null)
			return false;
	} else if (!teddy_name.equals(other.teddy_name))
		return false;
	return true;
}

//to make them accessible
public int getTeddy_id() {
	return teddy_id;
}


public String getTeddy_name() {
	return teddy_name;
}


public void setTeddy_name(String teddy_name) {
	this.teddy_name = teddy_name;
}


public String getTeddy_colors() {
	return teddy_colors;
}


public void setTeddy_colors(String teddy_colors) {
	this.teddy_colors = teddy_colors;
}


public String getTeddy_description() {
	return teddy_description;
}


public void setTeddy_description(String teddy_description) {
	this.teddy_description = teddy_description;
}

}


