package com.capgemini.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class assignment27 {
	public static void main(String[] args) {
		int runs = 0,total = 0;
		double rate = 0;
		DecimalFormat df = new DecimalFormat("0.00");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the total runs scored ");
		try {
			runs = Integer.parseInt(input.readLine());
		}catch (NumberFormatException e) {
			System.out.println("java.lang.NumberFormatException");
			System.exit(0);
			//e.printStackTrace();
		}catch (IOException e) {
			//e.printStackTrace();
		}
		System.out.println("Enter the total runs scored ");
		try {
			total = Integer.parseInt(input.readLine());
		} catch (NumberFormatException e) {
			System.out.println("java.lang.NumberFormatException");
			//e.printStackTrace();
		}catch (IOException e) {
			//e.printStackTrace();
		}
		boolean valid = false;
		try {
			rate = runs/total;
			valid = true;
		}catch (ArithmeticException e) {
			System.out.println("java.lang.ArithmeticException");
			//e.printStackTrace();
		}
		if(valid)
		{
			rate = runs*1.0/total;
			System.out.println("Current Run Rate : "+df.format(rate));
		}
			
	}
}
