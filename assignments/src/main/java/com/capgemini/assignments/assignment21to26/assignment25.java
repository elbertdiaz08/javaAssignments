package com.capgemini.assignments.assignment21to26;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class assignment25 {
	public static void main(String[] args) throws ParseException {
		List<Booking> booking = new ArrayList<>();
		List<Table> table = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of tables:");
		int n = Integer.parseInt(input.nextLine());
		//enter tables
		for(int i=0;i<n;i++) {
			String string = input.nextLine().trim();
			try {
				table.add(Table.createTable(string));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		String choice = "yes";
		do {
			if(choice.equalsIgnoreCase("yes")) {
				System.out.println("Enter the booking details:");
				String string1 = input.nextLine().trim();
				Booking.createBooking(table, booking, string1);
				System.out.println("Do you want to continue(yes/no)");
				choice = input.nextLine();
			}else {
				System.out.println("Yes or No only!");
				System.out.println("Do you want to continue(yes/no)");
				choice = input.nextLine();
			}
		}while(!choice.equalsIgnoreCase("no"));
		
		
	}
}
