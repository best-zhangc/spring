package com.zc.bean;

public class city {
	
	private int id ;
	private String name ;
	
	public city() {
		super();
	}
	
	public city(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
