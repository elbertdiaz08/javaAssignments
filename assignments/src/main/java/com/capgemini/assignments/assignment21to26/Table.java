package com.capgemini.assignments.assignment21to26;

public class Table implements Comparable<Table>{
	private Long id;
	private int number,capacity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Table(Long id, int number, int capacity) {
		super();
		this.id = id;
		this.number = number;
		this.capacity = capacity;
	}
	@Override
	public int compareTo(Table table) {
		if(this.number <  table.number) return -1;
	    if(this.number == table.number) return 0;
	    return 1;
	}
	
	static Table createTable(String line) {
		String[] arrSplit = line.split(",");
		Table table = new Table(Long.parseLong(arrSplit[0]),Integer.parseInt(arrSplit[1]),Integer.parseInt(arrSplit[2]));
		return table;
	}
}
