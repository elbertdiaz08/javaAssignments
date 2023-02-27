	package com.capgemini.assignments.assignment21to26;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class assignment22 {
	public static void main(String[] args) throws NumberFormatException, ParseException{
		Scanner sc=new Scanner(System.in);
		int count = 0;
		while(count==0) {
			try{
				System.out.println("Enter number of customer ");
				count = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Enter a number!");
			} 
		}
		List<Customer> customer = new ArrayList<Customer>();
		for(int i=0;i<count;i++) {
			String arrcx = sc.nextLine().trim();
			customer.add(createCustomer(arrcx));
		}
		System.out.println("Enter the search type:");
		int cc = 0;
		try {
			System.out.println("1.By name");
			System.out.println("2.By birth date");
			System.out.println("3.By rating");
			cc = Integer.parseInt(sc.nextLine());
			if(cc == 1) {
				System.out.println("Enter the name of the customer to be searched:");
				String cname = sc.nextLine().trim();
				System.out.printf("%-5s %-15s %-15s %-15s %-20s %-15s %-15s %s\n", "Id","Name","Mobile Number","Date of Birth","Average spent amount","Total amount","Date Enrolled","Rating"); 
				List<Customer> fcx = findCustomer(customer,cname);
				for(Customer displaycx: fcx)
					System.out.println(toString(displaycx));
			}

			if(cc==2) {
				System.out.println("Enter the rating of the customer to be searched:");
				Date cdob = new SimpleDateFormat("dd-mm-yyyy").parse(sc.nextLine());
				System.out.printf("%-5s %-15s %-15s %-15s %-20s %-15s %-15s %s\n", "Id","Name","Mobile Number","Date of Birth","Average spent amount","Total amount","Date Enrolled","Rating"); 
				List<Customer> dcx = findCustomer(customer,cdob);
				for(Customer displaycx: dcx)
					System.out.println(toString(displaycx));
			}
			if(cc==3) {
				System.out.println("Enter the rating of the customer to be searched:");
				Double crating = Double.parseDouble(sc.nextLine());
				System.out.printf("%-5s %-15s %-15s %-15s %-20s %-15s %-15s %s\n", "Id","Name","Mobile Number","Date of Birth","Average spent amount","Total amount","Date Enrolled","Rating"); 
				List<Customer> rat = findCustomer(customer,crating);
				for(Customer displaycx: rat)
					System.out.println(toString(displaycx));
			}
			else if(cc>3) {
				System.out.println("Type 1 to 3 only");
			}

		}catch(Exception e) {
			System.out.println("Type 1 to 3 only");
			e.printStackTrace();
		} 
	}

	static Customer createCustomer(String line) throws NumberFormatException, ParseException {
		String[] arrSplit = line.split(",");
		Customer cx1 = new Customer(Long.parseLong(arrSplit[0]),arrSplit[1].trim(),arrSplit[2].trim(),new SimpleDateFormat("dd-mm-yyyy").parse(arrSplit[3]),Double.parseDouble(arrSplit[4]),
				Double.parseDouble(arrSplit[5]),new SimpleDateFormat("dd-mm-yyyy").parse(arrSplit[6]),Double.parseDouble(arrSplit[7]));
		return cx1;		
	}

	static List<Customer> findCustomer(List<Customer> customerList,String name) {
		List<Customer> cx1 = new ArrayList<Customer>();
		for(Customer cx:customerList) {
			if(cx.getName().equalsIgnoreCase(name)){
				cx1.add(cx);	
			}
		}
		return cx1;
	}
	static List<Customer> findCustomer(List<Customer> customerList,Date birth) {
		List<Customer> cx1 = new ArrayList<Customer>();
		for(Customer cx:customerList) {
			if(cx.getBirthdate().equals(birth)){
				cx1.add(cx);	
			}
		}
		return cx1;
	}
	static List<Customer> findCustomer(List<Customer> customerList,Double rating) {
		List<Customer> cx1 = new ArrayList<Customer>();
		for(Customer cx:customerList) {
			if(cx.getRating().equals(rating)){
				cx1.add(cx);	
			}
		}
		return cx1;
	}

	public static String toString(Customer customer) {
		return String.format("%-5s %-15s %-15s %-15s %-20s %-15s %-15s %s", ((Customer) customer).getId(),((Customer) customer).getName(),((Customer) customer).getMobileNumber(),
				new SimpleDateFormat("dd-mm-yyyy").format(((Customer) customer).getBirthdate()),((Customer) customer).getAverageSpendAmount(),((Customer) customer).getTotalAmount(),new SimpleDateFormat("dd-mm-yyyy").format(((Customer) customer).getDateEnrolled()),((Customer) customer).getRating()); 
	}



}
