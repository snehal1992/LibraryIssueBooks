package com.DAO;

public class Fines {

	int loanid;
	double fine_amount;
	boolean paid;
	public int getLoanid() {
		return loanid;
	}
	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}
	public double getFine_amount() {
		return fine_amount;
	}
	public void setFine_amount(double fine) {
		this.fine_amount = fine;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
}
