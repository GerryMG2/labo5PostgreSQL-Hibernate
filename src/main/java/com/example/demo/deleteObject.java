package com.example.demo;

import org.hibernate.validator.constraints.NotEmpty;

public class deleteObject {
	
	@NotEmpty
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
