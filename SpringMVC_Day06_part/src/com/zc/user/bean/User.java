package com.zc.user.bean;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.Serializable;

public class User implements Serializable{
	private int id ;
	private String name ;
	private String pwd ;
	private String phone ;
	
	/** 构造参数	 */
	public User() {
		super();
	}

	public User(int id, String name, String pwd, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
	}
	public User(String name, String pwd, String phone) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
	}

	/**get set方法 */
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

	/** hashcode requals */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof User) {
				User o = (User) obj;
				return this.id == o.id ;
		}
		return true;
	}

	/**转换字符*/
	@Override
	public String toString() {
		return id + "," + name + "," + pwd + "," + phone;
	}
	

}
