package com.capgemini.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class assignment30 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the team name");
		String teamName = input.readLine().trim();
		System.out.println("Enter the number of players suggested ");
		int n = Integer.parseInt(input.readLine().trim());
		int[] playerId = new int[n];
		String[] playerName = new String[n];
		for(int i=0;i<n;i++) {
			try {
				System.out.println("Enter player "+(i+1)+" details");
				int check=Integer.parseInt(input.readLine().trim());
				playerName[i]=input.readLine().trim();
				int found=0;
				for(int a=0;a<n;a++) {
					if(check == playerId[a]) {
						found++;
					}					
				}
				if(found!=0) {
					throw new DuplicateIdException();
				}
				if(found == 0)
					playerId[i]=check;
			}catch(DuplicateIdException e) {
				System.out.println("DuplicateIdException: Player Id must be unique");  
				System.exit(0);
			}
		}
		for(int i=0;i<n;i++) {
			System.out.println(playerId[i]+" "+playerName[i]);
		}
	}
}

class DuplicateIdException extends Exception{


}