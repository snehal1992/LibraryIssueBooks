package com.DAO;

import java.sql.Date;

public class DisplayBean {
   int loanid ;
   int cardid ;
   java.sql.Date date_out;
   java.sql.Date date_in;
   java.sql.Date due_date;
   String isbn;
   int amt ;
public int getAmt() {
	return amt;
}
public void setAmt(int amt) {
	this.amt = amt;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public int getLoanid() {
	return loanid;
}
public void setLoanid(int loanid) {
	this.loanid = loanid;
}
public int getCardid() {
	return cardid;
}
public void setCardid(int cardid) {
	this.cardid = cardid;
}
public Date getDate_out() {
	return date_out;
}
public void setDate_out(Date date_out) {
	this.date_out = date_out;
}
public Date getDate_in() {
	return date_in;
}
public void setDate_in(Date date_in) {
	this.date_in = date_in;
}
public Date getDue_date() {
	return due_date;
}
public void setDue_date(Date due_date) {
	this.due_date = due_date;
}
   
}
