package com.DAO;

import java.util.Map;

public class SearchBean {

	String isbn ;
	String fname;
	String lname;
	String title ;
	boolean availablie ;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean getAvailable() {
		return availablie;
	}
	public void setAvailable(boolean availablie) {
		this.availablie = availablie;
	}
    	
}
