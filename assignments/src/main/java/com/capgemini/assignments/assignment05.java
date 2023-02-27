package com.capgemini.assignments;
import java.util.Scanner;

class assignment05{
	String word;
	void upper(String word) {
		System.out.println(word.toUpperCase());
	}
	void lower(String word) {
		System.out.println(word.toLowerCase());
	}
	void capital(String word) {
		char[] charArray = word.toCharArray();
		boolean foundSpace = true;
		for(int i = 0; i < charArray.length; i++) {
			if(Character.isLetter(charArray[i])) {
				if(foundSpace) {
					charArray[i] = Character.toUpperCase(charArray[i]);
					foundSpace = false;
				}
			}
			else {
				foundSpace = true;
			}
		}
		word = String.valueOf(charArray);
		System.out.println(word);
	}
	void sentence(String word){
		word = word.toLowerCase();
		char[] charArray = word.toCharArray();
		boolean foundSpace = true;

		for(int i = 0; i < charArray.length; i++) {
			if(Character.isLetter(charArray[i])) {
				if(foundSpace) {
					charArray[i] = Character.toUpperCase(charArray[i]);
					foundSpace = false;
				}
			}
			else if(charArray[i] == '.'){
				foundSpace = true;
			}
		}
		word = String.valueOf(charArray);
		System.out.println(word);
	}
	void invert(String word){
		char[] chars = word.toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			chars[i] = Character.isUpperCase(chars[i])
					? Character.toLowerCase(chars[i])
							: Character.toUpperCase(chars[i]);
		}
		word = String.valueOf(chars);
		System.out.println(word);
	}
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter a sentence:");
		String word = myObj.nextLine();  
		assignment05 cas = new assignment05();
		System.out.println("Upper case:");
		cas.upper(word);
		System.out.println("Lower case:");
		cas.lower(word);
		System.out.println("Capital case:");
		cas.capital(word);
		System.out.println("Sentence case:");
		cas.sentence(word);
		System.out.println("Inverted case:");
		cas.invert(word);
	}
}


