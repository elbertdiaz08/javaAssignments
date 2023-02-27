package com.capgemini.assignments;
import java.util.Scanner;

class assignment06{  
 public static void main(String args[]){  
  int i,fact=1;  
  Scanner myObj = new Scanner(System.in);
  System.out.println("Enter a number:");
  int number = myObj.nextInt();    
  for(i=1;i<=number;i++){    
      fact=fact*i;    
  }    
  System.out.println("Factorial of "+number+" is: "+fact);    
 }  
}  
