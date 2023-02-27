package com.capgemini.assignments.assignment21to26;

import java.util.Date;

class Customer implements Comparable<Customer>{
	private Long id;
	private String name, mobileNumber;
	private Date birthdate,dateEnrolled;
	private Double averageSpendAmount,totalAmount,rating;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Date getDateEnrolled() {
		return dateEnrolled;
	}
	public void setDateEnrolled(Date dateEnrolled) {
		this.dateEnrolled = dateEnrolled;
	}
	public Double getAverageSpendAmount() {
		return averageSpendAmount;
	}
	public void setAverageSpendAmount(Double averageSpendAmount) {
		this.averageSpendAmount = averageSpendAmount;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Customer(Long id, String name, String mobileNumber, Date birthdate,
			Double averageSpendAmount, Double totalAmount, Date dateEnrolled, Double rating) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.birthdate = birthdate;
		this.dateEnrolled = dateEnrolled;
		this.averageSpendAmount = averageSpendAmount;
		this.totalAmount = totalAmount;
		this.rating = rating;
	}
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", birthdate=" + birthdate
				+ ", dateEnrolled=" + dateEnrolled + ", averageSpendAmount=" + averageSpendAmount + ", totalAmount="
				+ totalAmount + ", rating=" + rating + "]";
	}
	
	@Override
	public int compareTo(Customer o) {
		return this.name.compareToIgnoreCase(o.name);
	}
	
}
