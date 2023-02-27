package com.capgemini.assignments.assignment21to26;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class assignment21 {
	public static void main(String[] args) throws NumberFormatException, ParseException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the details of Customer 1:");
		String customer1 = new Scanner(System.in).nextLine();
		String[] arrSplit = customer1.split(",");
		Customer cx1 = new Customer(Long.parseLong(arrSplit[0]),arrSplit[1].trim(),arrSplit[2].trim(),new SimpleDateFormat("dd-mmyyyy").parse(arrSplit[3]),Double.parseDouble(arrSplit[4]),
				Double.parseDouble(arrSplit[5]),new SimpleDateFormat("dd-MM-yyyy").parse(arrSplit[6]),Double.parseDouble(arrSplit[7]));
		
		System.out.println("Enter the details of Customer 2:");
		String customer2 = new Scanner(System.in).nextLine();
		arrSplit = customer2.split(",");
		Customer cx2 = new Customer(Long.parseLong(arrSplit[0]),arrSplit[1].trim(),arrSplit[2].trim(),new SimpleDateFormat("dd-mmyyyy").parse(arrSplit[3]),Double.parseDouble(arrSplit[4]),
				Double.parseDouble(arrSplit[5]),new SimpleDateFormat("dd-mm-yyyy").parse(arrSplit[6]),Double.parseDouble(arrSplit[7]));
		System.out.println("Details of customer 1: ");
		System.out.println(assignment21.toString(cx1));
		System.out.println("Details of customer 2: ");
		System.out.println(assignment21.toString(cx2));
		System.out.println("");
		boolean same = false;
		if(cx1.getName().equalsIgnoreCase(cx2.getName()) && cx1.getMobileNumber().equalsIgnoreCase(cx2.getMobileNumber()) && cx1.getBirthdate().equals(cx2.getBirthdate()))
			same = true;
		if(same)
			System.out.println("Customer 1 is same as Customer 2");
		else if(!same)
			System.out.println("Customer 1 and Customer 2 are different");
		
	}

	public static String toString(Customer customer) {
		return "id:" + customer.getId() + "\nName:" + customer.getName() + "\nMobile Number:" + customer.getMobileNumber() + "\nBirthdate:" + new SimpleDateFormat("dd-mm-yyyy").format(customer.getBirthdate())
				+ "\nDate Enrolled: " + new SimpleDateFormat("dd-mm-yyyy").format(customer.getDateEnrolled()) + "\nAverage Spend Amount:" + customer.getAverageSpendAmount() + "\nTotal Amount:"
				+ customer.getTotalAmount() + "\nRating=" + customer.getRating();
	}
	
	
}
