package com.Model;

public class Course {
	
	private int cId;
	private String Cname;
	private int fees;
	private int cSeats;
	
	
	public Course() {
		super();
	}


	public Course(int cId, String cname, int fees, int cSeats) {
		super();
		this.cId = cId;
		Cname = cname;
		this.fees = fees;
		this.cSeats = cSeats;
	}


	public int getcId() {
		return cId;
	}


	public void setcId(int cId) {
		this.cId = cId;
	}


	public String getCname() {
		return Cname;
	}


	public void setCname(String cname) {
		Cname = cname;
	}


	public int getFees() {
		return fees;
	}


	public void setFees(int fees) {
		this.fees = fees;
	}


	public int getcSeats() {
		return cSeats;
	}


	public void setcSeats(int cSeats) {
		this.cSeats = cSeats;
	}


	@Override
	public String toString() {
		return "Course [cId=" + cId + ", Cname=" + Cname + ", fees=" + fees + ", cSeats=" + cSeats + "]";
	}

	

	
	
	

}
