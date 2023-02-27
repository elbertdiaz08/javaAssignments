package com.capgemini.assignments.assignment18;

import java.util.Scanner;

public class assignment18 {
	public static void main(String[] args) {
		//Innings
		Scanner sc=new Scanner(System.in);
		int ic = 0;
		while(ic==0) {
			try{
				System.out.println("Enter the number of innings ");
				ic = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Enter a number!");
			} 
		}
		Innings[] in=new Innings[ic];
		for(int i=0;i<in.length;i++) {
			System.out.println("Enter innings "+(i+1)+" details: ");
			String data=sc.nextLine();
			new InningsBO().createInnings(data);
			in[i]=new InningsBO().createInnings(data);
			//System.out.println(in[i]);
		}
		//Delivery
		int dc = 0;
		while(dc==0) {
			try{
				System.out.println("Enter the number of deliveries");
				dc = Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Enter a number!");
			} 
		}
		Delivery[] dn=new Delivery[dc];
		for(int i=0;i<dn.length;i++) {
			System.out.println("Enter innings "+(i+1)+" details: ");
			String data=sc.nextLine();
			new DeliveryBO().createDelivery(data,in);
			dn[i]=new DeliveryBO().createDelivery(data,in);
			//System.out.println(dn[i]);
		}
		//find inning
		int found=0;
		Long find = 0L;
		while(find==0) {
			try{
				System.out.println("Enter the delivery number for which you need to find the innings number");
				find = Long.parseLong(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Enter a number!");
			} 
		}
		for(int i=0;i<dn.length;i++) {
			if(dn[i].getDeliveryNumber() == find) {
				found++;
				String finding = new DeliveryBO().findInningsNumber(in,find);
				System.out.println(finding);
			} 
		}if(found==0)
		{
			System.out.println("No Inning found terminating program");
			System.exit(1);
		}
	}
}


class Innings{
	private Long inningsNumber;
	private String battingTeam;
	public Long getInningsNumber() {
		return inningsNumber;
	}
	public String getBattingTeam() {
		return battingTeam;
	}
	public Innings(Long inningsNumber, String battingTeam) {
		super();
		this.inningsNumber = inningsNumber;
		this.battingTeam = battingTeam;
	}
	@Override
	public String toString() {
		return "Innings [inningsNumber=" + inningsNumber + ", battingTeam=" + battingTeam + "]";
	}

}

class Delivery {
	private Long deliveryNumber;
	private String batsman;
	private String bowler;
	private Long runs;
	private Long inningsNumber;
	private Innings innings;
	public Long getDeliveryNumber() {
		return deliveryNumber;
	}
	public String getBatsman() {
		return batsman;
	}
	public String getBowler() {
		return bowler;
	}
	public Long getRuns() {
		return runs;
	}
	public Long getInningsNumber() {
		return inningsNumber;
	}
	public Innings getInnings() {
		return innings;
	}
	public Delivery(Long deliveryNumber, String batsman, String bowler, Long runs, Long inningsNumber,
			Innings innings) {
		super();
		this.deliveryNumber = deliveryNumber;
		this.batsman = batsman;
		this.bowler = bowler;
		this.runs = runs;
		this.inningsNumber = inningsNumber;
		this.innings = innings;
	}
	@Override
	public String toString() {
		return "Delivery [deliveryNumber=" + deliveryNumber + ", batsman=" + batsman + ", bowler=" + bowler + ", runs="
				+ runs + ", inningsNumber=" + inningsNumber + ", innings=" + innings + "]";
	}

}

class InningsBO {
	Innings createInnings (String data) {
		String[] arrSplit = data.split(",");
		Long inningsNumber=Long.parseLong(arrSplit[0].trim());
		String battingTeam=arrSplit[1].trim();
		Innings created = new Innings(inningsNumber,battingTeam);
		return created;
	}
}

class DeliveryBO {
	public Delivery createDelivery(String data, Innings [] inningsList) {
		int found=0;
		String[] arrSplit = data.split(",");
		Long deliveryNumber=Long.parseLong(arrSplit[0].trim());
		String batsman=arrSplit[1].trim();
		String bowler=arrSplit[2].trim();
		Long runs=Long.parseLong(arrSplit[3].trim());
		Long inningsNumber=Long.parseLong(arrSplit[4].trim());
		Innings inningslist = null;
		for(int i=0;i<inningsList.length;i++)
		{
			if(inningsList[i].getInningsNumber() == inningsNumber) {
				found++;
				inningslist = inningsList[i];
			} 
		}if(found==0)
		{
			System.out.println("No Inning found terminating program");
			System.exit(1);
		}
		Delivery created = new Delivery(deliveryNumber,batsman,bowler,runs,inningsNumber,inningslist);
		return created;

	}
	public String findInningsNumber(Innings [] inningsList, long deliveryNumber) {
		String found = null;
		for(int i=0;i<inningsList.length;i++)
		{
			found = inningsList[i].getInningsNumber().toString();
		}
		return found;
	}
}
