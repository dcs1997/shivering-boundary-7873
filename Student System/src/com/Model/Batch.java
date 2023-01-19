package com.Model;

public class Batch {
	
	private int batchUid;
	private int batchNo;
	private int cId;
	private String sEmail;
	
	
	public Batch() {
		super();
	}


	public Batch(int batchUid, int batchNo, int cId, String sEmail) {
		super();
		this.batchUid = batchUid;
		this.batchNo = batchNo;
		this.cId = cId;
		this.sEmail = sEmail;
	}


	public int getBatchUid() {
		return batchUid;
	}


	public void setBatchUid(int batchUid) {
		this.batchUid = batchUid;
	}


	public int getBatchNo() {
		return batchNo;
	}


	public void setBatchNo(int batchNo) {
		this.batchNo = batchNo;
	}


	public int getcId() {
		return cId;
	}


	public void setcId(int cId) {
		this.cId = cId;
	}


	public String getsEmail() {
		return sEmail;
	}


	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}


	@Override
	public String toString() {
		return "Batch [batchUid=" + batchUid + ", batchNo=" + batchNo + ", cId=" + cId + ", sEmail=" + sEmail + "]";
	}
	
	
	
	
	

}
