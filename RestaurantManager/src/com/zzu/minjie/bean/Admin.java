package com.zzu.minjie.bean;

public class Admin {
	private String ID;
	private String password;
	private String name;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", password=" + password + ", name=" + name + "]";
	}

}
