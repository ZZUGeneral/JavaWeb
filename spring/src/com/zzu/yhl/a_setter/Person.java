package com.zzu.yhl.a_setter;

public class Person {
	private String name;
	private int age;
	private Address homeAddr;
	private Address companyAddr;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the homAddr
	 */
	public Address getHomeAddr() {
		return homeAddr;
	}

	/**
	 * @param homAddr the homAddr to set
	 */
	public void setHomeAddr(Address homeAddr) {
		this.homeAddr = homeAddr;
	}

	/**
	 * @return the companyAddr
	 */
	public Address getCompanyAddr() {
		return companyAddr;
	}

	/**
	 * @param companyAddr the companyAddr to set
	 */
	public void setCompanyAddr(Address companyAddr) {
		this.companyAddr = companyAddr;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", homAddr=" + homeAddr + ", companyAddr=" + companyAddr + "]";
	}

}
