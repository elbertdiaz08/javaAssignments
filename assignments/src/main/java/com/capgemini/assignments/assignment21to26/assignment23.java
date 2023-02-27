package com.capgemini.assignments.assignment21to26;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class assignment23 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int cc = 0;
		try {
			System.out.println("1.Validate Age");
			System.out.println("2.Validate Name");
			System.out.println("3.Lucky Customer");
			System.out.println("Enter your choice:");
			cc = Integer.parseInt(sc.nextLine());
			if(cc==1) {
				System.out.println("Enter birthdate:");
				Date bd = new SimpleDateFormat("dd-mm-yyyy").parse(sc.nextLine());
				Boolean age = validateAge(bd);
				if(age)
					System.out.println("Age is valid");
				else
					System.out.println("Age is invalid");
			}
			if(cc==2) {
				System.out.println("Enter Name:");
				String entername = sc.nextLine();
				Boolean name = validateName(entername);
				if(name)
					System.out.println("Name is valid");
				else
					System.out.println("Name is invalid");
			}
			if(cc==3) {
				System.out.println("Enter Mobile Number:");
				String enternumber = sc.nextLine().trim();
				Boolean mobilenumber = validateLuckyCustomer(enternumber);
				if(mobilenumber)
					System.out.println("Lucky Customer");
				else
					System.out.println("Unlucky Customer");
			}
			else if(cc>3) {
				System.out.println("Type 1 to 3 only");
			}

		}catch(Exception e) {
			System.out.println("Type 1 to 3 only");
			e.printStackTrace();
		} 
	}
	
	static Boolean validateAge(Date birth) {
		LocalDate today = LocalDate.now();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date today1 = java.sql.Date.valueOf(today);
		//System.out.println(today1);
		//System.out.println(formatter.format(today1));
		//create calendar object for birth day
	    Calendar birthDay = Calendar.getInstance();
	    birthDay.setTimeInMillis(birth.getTime());
	    //create calendar object for today
	    Calendar today2 = Calendar.getInstance();
	    today2.setTimeInMillis(today1.getTime());
	    int years = today2.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
	    //System.out.println(years);
	    if(years>=18)
	    	return true;
	    else
	    	return false;
		
	}
	
	static Boolean validateName(String name) {
		int count = 0;
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isLetter(name.charAt(i)))
				count++;
		}
		if(count==0)
			return true;
		else
			return false;
	}
	
	static Boolean validateLuckyCustomer(String mobile) {
		//step1
		int digitsSum = 0;
		for (int i = 0; i < mobile.length(); i++) {
			char character = mobile.charAt(i);
            boolean isDigit = Character.isDigit(character);
            if (isDigit) {
                digitsSum = digitsSum + Character.getNumericValue(character);
            }
		}
		//System.out.println(digitsSum);
		//step2
		String step2 = String.valueOf(digitsSum);
		int digitsSum2 = 0;
		for (int i = 0; i < step2.length(); i++) {
			char character = step2.charAt(i);
            boolean isDigit = Character.isDigit(character);
            if (isDigit) {
                digitsSum2 = digitsSum2 + Character.getNumericValue(character);
            }
		}
		//System.out.println(digitsSum2);
		//step3
		String step3 = String.valueOf(digitsSum2);
		int digitsSum3 = 0;
		for (int i = 0; i < step3.length(); i++) {
			char character = step3.charAt(i);
            boolean isDigit = Character.isDigit(character);
            if (isDigit) {
                digitsSum3 = digitsSum3 + Character.getNumericValue(character);
            }
		}
		//System.out.println(digitsSum3);
		if(digitsSum3==1)
			return true;
		else
			return false;
		
	}
}
