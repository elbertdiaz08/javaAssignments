package com.capgemini.assignments;
import java.util.Scanner;

public class assignment10  
{ 
	//method to print permutations of specified array
	public static int count=0;
	void printPermutations(int array[], int n)  
	{ 
		count++;
		for (int i = 0; i < n; i++){  
			if(i == 0)
				System.out.print( "("+array[i] );
			else 
				System.out.print( ", " + array[i] );
		}
		System.out.println(")");
	}  
	//finds permutation using Heap Algorithm  
	void findPermutation(int array[], int size, int n)  
	{
		// if size becomes 1, it prints the obtained permutation 
		if (size == 1){  
			printPermutations(array, n);
		}
		for (int i = 0; i < size; i++)   
		{ 
			findPermutation(array, size - 1, n); 
			//if the length of the array is odd, it swaps the 0th element with the last element   
			if (size % 2 == 1)   
			{  
				//performing swapping     
				int temp = array[0];  
				array[0] = array[size - 1];  
				array[size - 1] = temp;			
			}  
			//if the size of the array is even, it swaps the ith element with the last element  
			else   
			{  
				//taking a temp variable for swapping     
				int temp;  
				//performing swapping   
				temp = array[i];  
				array[i] = array[size - 1];  
				array[size - 1] = temp; 
				//count++;
			}
		}  
	}  
	//main() method
	public static void main(String[] args)
	{  
		System.out.println("Enter set of number: ");
		Scanner myObj = new Scanner(System.in);
		int numx = myObj.nextInt();
		assignment10 p = new assignment10();  
		//defining an array whose permutation is to find  
		int array[] = new int [numx];
		for(int a=0;a<numx;a++){
			System.out.println("Enter #"+(a+1)+": ");
			Scanner myObj1 = new Scanner(System.in);
			int numy = myObj1.nextInt();
			array[a] = numy;
		}
		//calling the user-defined method
		p.findPermutation(array, array.length, array.length);
		for(int a=0;a<numx;a++){
			if(a == 0)
				System.out.print( "The permutations of ("+array[a] );
			else 
				System.out.print( ", " + array[a] );
		}System.out.println(") are: "+count);
	}  
}  	
