package com.fj.model;

public class Section {
	private int id;
	private String sname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "Section [id=" + id + ", sname=" + sname + "]";
	}
	

}
