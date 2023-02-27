package com.capgemini.assignments.assignment21to26;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Booking {
	private Long id;
	private String customerName;
	private Table table;
	private int tableNumber, membersPresent;
	private double billamount;
	private Date bookingTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public int getMembersPresent() {
		return membersPresent;
	}

	public void setMembersPresent(int membersPresent) {
		this.membersPresent = membersPresent;
	}

	public double getBillamount() {
		return billamount;
	}

	public void setBillamount(double billamount) {
		this.billamount = billamount;
	}

	public Date getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}

	public Booking(Long id, String customerName, Table table, int membersPresent, double billamount, Date bookingTime) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.table = table;
		this.membersPresent = membersPresent;
		this.billamount = billamount;
		this.bookingTime = bookingTime;
	}
	
	
	
	public Booking(Long id, String customerName, int tableNumber, int membersPresent, double billamount,
			Date bookingTime) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.tableNumber = tableNumber;
		this.membersPresent = membersPresent;
		this.billamount = billamount;
		this.bookingTime = bookingTime;
	}

	static Booking createBooking(String line) throws ParseException {
		String[] arrSplit = line.split(",");
		Long id = Long.parseLong(arrSplit[0]);
		String name = arrSplit[1];
		int number = Integer.parseInt(arrSplit[2]);
		int member = Integer.parseInt(arrSplit[3]);
		double bill = Double.parseDouble(arrSplit[4]);
		Date time = new SimpleDateFormat("dd-mm-yyyy").parse(arrSplit[5]);
		Booking booked = new Booking(id, name, number, member, bill, time);
		return booked;
	}

	static void createBooking(List<Table> tableList, List<Booking> bookingList, String line) throws ParseException {
		String[] arrSplit = line.split(",");
		Long id = Long.parseLong(arrSplit[0]);
		String name = arrSplit[1];
		int number = Integer.parseInt(arrSplit[2]);
		int member = Integer.parseInt(arrSplit[3]);
		double bill = Double.parseDouble(arrSplit[4]);
		Date time = new SimpleDateFormat("dd-mm-yyyy").parse(arrSplit[5]);

		boolean available = true;
		for (Booking book : bookingList) {
			if (book.getTable().getNumber() == number) {
				available = false;
				System.out.println("Sorry the table is not available");
				System.out.println("The available tables are:");
				System.out.format("%-5s %-10s %s\n", "ID", "Number", "Capacity");
				for (Table table : tableList) {
					if (table.getNumber() != book.getTable().getNumber()) {
						System.out.format("%-5s %-10s %s\n", table.getId(), table.getNumber(), table.getCapacity());
					}
				}
			}

		}

		if (available) {
			int tableFound = 0;
			Table tableNumberFound = new Table(id, number, member);
			for (Table table : tableList) {
				if (table.getNumber() == number) {
					tableNumberFound = table;
					tableFound++;
				}
			}
			if (tableFound > 0) {
				Booking booked = new Booking(id, name, tableNumberFound, member, bill, time);
				bookingList.add(booked);
				System.out.println("Table successfully booked");
			} else if (tableFound == 0) {
				System.out.println("Sorry the table is not available");
				System.out.println("The available tables are:");
				System.out.format("%-5s %-10s %s\n", "ID", "Number", "Capacity");
				for (Table table : tableList) {
					for (Booking book : bookingList) {
						if (table.getNumber() != book.getTable().getNumber()) {
							System.out.format("%-5s %-10s %s\n", table.getId(), table.getNumber(), table.getCapacity());
						}
					}
				}
			}
		}
	}
	
	static Map<Date,Double> calculateDayBilling(List<Booking> bookings){
		Map<Date,Double> hashMap = new HashMap<>();
		for(Booking book:bookings) {
			Date date = book.getBookingTime();
			double amount = hashMap.containsKey(date) ? hashMap.get(date):0;
			amount+=book.getBillamount();
			hashMap.put(date,amount);
		}
		return hashMap;
		
	}
}
