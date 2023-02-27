package com.capgemini.assignments.assignment21to26;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class assignment26 {
	public static void main(String[] args) throws ParseException {
		List<Booking> booking = new ArrayList<>();
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy"); 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of booking details:");
		int n = Integer.parseInt(input.nextLine());
		for(int i=0;i<n;i++) {
			String string = input.nextLine().trim();
			try {
				booking.add(Booking.createBooking(string));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		System.out.format("%-20s %s\n","Date","Amount");
		TreeMap<Date, Double> sorted = new TreeMap<>();
		sorted.putAll(Booking.calculateDayBilling(booking));
		for (Map.Entry<Date, Double> entry : sorted.entrySet()) {
			System.out.format("%-20s %s\n",dateFormat.format(entry.getKey()),entry.getValue());
		}
	}
}
