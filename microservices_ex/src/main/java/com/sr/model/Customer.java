package com.sr.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Customer {
  
	@Id
	private ObjectId _id;
	private String name;
	private String city;
	
	
	public Customer(ObjectId _id, String name, String city) {
		super();
		this._id = _id;
		this.name = name;
		this.city = city;
	}
	
		public String get_id() {
		return _id.toHexString();
	}
    	public void set_id(ObjectId _id) {
		this._id = _id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	

}
