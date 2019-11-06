package com.zc.dao;

import java.io.Serializable;

public class User  implements Serializable{
	private String name ;
	private int id ;
	private String pwd ;
	private String phone ;
	
	//构造参数 无参
	public User() {
	
	}
	//构造参数 有参
	public User(String name, int id, String pwd, String phone) {
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	// hashcode & equals
	@Override
	public int hashCode() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof User) {
			User other = (User) obj;
			return this.id == other.id;
		}
		return true;
	}
	
	//转换tostring
	@Override
	public String toString() {
		return id + "," + name + "," + pwd + "," + phone;
	}
		
}
