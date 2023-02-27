package com.capgemini.assignments;
import java.util.Scanner;

class assignment04{
	public static void main(String args[])
	{  
		int n1=0,n2=1,n3=0,i,count;  
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter a number:");
		int number = myObj.nextInt();  
		count = number;
		System.out.print(+n2);//printing 0 and 1  
		for(i=2;i<count;i++)//loop starts from 2 because 0 and 1 are already printed  
		{  
			n3=n1+n2;  
			if (n3<count){
				System.out.print(" "+n3);
				n1=n2;  
				n2=n3;	
			}
		}  
	}
}
