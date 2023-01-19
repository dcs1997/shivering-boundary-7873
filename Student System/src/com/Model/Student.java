package com.Model;

public class Student {
	private int sid;
	private String name;
	private String email;
	private String password;
	
	
	public Student() {
		super();
	}


	public Student(int sid, String name, String email, String password) {
		super();
		this.sid = sid;
		this.name = name;
		this.email = email;
		this.password = password;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}



	
	
	

}
