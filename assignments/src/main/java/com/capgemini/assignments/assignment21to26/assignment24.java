package com.capgemini.assignments.assignment21to26;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class assignment24 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//List
		List<Customer> customerList = new ArrayList<>();
		//enter number to input
		System.out.println("Enter the number of customers:");
		int n = Integer.parseInt(input.nextLine());
		//enter customer info
		for(int i=0;i<n;i++) {
			String string = input.nextLine().trim();
			try {
				customerList.add(createCustomer(string));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		int choice = 0;
		do {
			System.out.println("Enter a type to sort:\n1.Name\n2.Amount Spent\n3.Rating");
		    choice = input.nextInt();

		    switch (choice)
		    {
		        case 1:
		        	sortName(customerList);
		            break;
		        case 2: 
		        	sortAmountSpent(customerList);
		            break;
		        case 3: 
		        	sortRating(customerList);
		            break;
		        default:
		            System.out.println("Invalid choice");
		    }   
		}
		while(choice !=3);
	}
	
	static Customer createCustomer(String line) throws NumberFormatException, ParseException {
		String[] arrSplit = line.split(",");
		Customer cx1 = new Customer(Long.parseLong(arrSplit[0]),arrSplit[1].trim(),arrSplit[2].trim(),new SimpleDateFormat("dd-mm-yyyy").parse(arrSplit[3]),Double.parseDouble(arrSplit[4]),
				Double.parseDouble(arrSplit[5]),new SimpleDateFormat("dd-mm-yyyy").parse(arrSplit[6]),Double.parseDouble(arrSplit[7]));
		return cx1;		
	}
	
	static void sortName(List<Customer> list) {
		Collections.sort(list);
		list.stream().map(s -> toString(s)).forEach(System.out::print);
	}
	
	static void sortAmountSpent(List<Customer> list) {
		Collections.sort(list,new namedAmountComparator());
		list.stream().map(s -> toString(s)).forEach(System.out::print);
	}
	
	static void sortRating(List<Customer> list) {
		Collections.sort(list,new namedRatingComparator());
		list.stream().map(s -> toString(s)).forEach(System.out::print);
	}
	
	public static String toString(Customer customer) {
		return String.format("%-5s %-15s %-15s %-15s %-20s %-15s %-15s %s\n", ((Customer) customer).getId(),((Customer) customer).getName(),((Customer) customer).getMobileNumber(),
				new SimpleDateFormat("dd-mm-yyyy").format(((Customer) customer).getBirthdate()),((Customer) customer).getAverageSpendAmount(),((Customer) customer).getTotalAmount(),new SimpleDateFormat("dd-mm-yyyy").format(((Customer) customer).getDateEnrolled()),((Customer) customer).getRating()); 
	}
}

