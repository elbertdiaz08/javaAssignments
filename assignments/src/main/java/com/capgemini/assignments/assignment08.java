package com.capgemini.assignments;
import java.util.*;
import static java.util.Collections.shuffle;

public class assignment08 {
	//distribute to 4 player
	public static List[] split(List<String> list)
	{
		List<String> first = new ArrayList<String>();
		List<String> second = new ArrayList<String>();
		List<String> third = new ArrayList<String>();
		List<String> fourth = new ArrayList<String>(); 

		for (int i = 0; i < 13; i++)
			first.add(list.get(i));
		for (int i = 13; i < 26; i++)
			second.add(list.get(i));
		for (int i = 26; i < 39; i++)
			third.add(list.get(i));
		for (int i = 39; i < 52; i++)
			fourth.add(list.get(i));
		return new List[] { first, second, third, fourth };
	}

	//Cards
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();
		//Clubs
		list.add("Ac");
		list.add("2c");
		list.add("3c");
		list.add("4c");
		list.add("5c");
		list.add("6c");
		list.add("7c");
		list.add("8c");
		list.add("9c");
		list.add("10c");
		list.add("Jc");
		list.add("Qc");
		list.add("Kc");
		//Diamond
		list.add("Ad");
		list.add("2d");
		list.add("3d");
		list.add("4d");
		list.add("5d");
		list.add("6d");
		list.add("7d");
		list.add("8d");
		list.add("9d");
		list.add("10d");
		list.add("Jd");
		list.add("Qd");
		list.add("Kd");
		//Hearts
		list.add("Ah");
		list.add("2h");
		list.add("3h");
		list.add("4h");
		list.add("5h");
		list.add("6h");
		list.add("7h");
		list.add("8h");
		list.add("9h");
		list.add("10h");
		list.add("Jh");
		list.add("Qh");
		list.add("Kh");
		//Spade
		list.add("As");
		list.add("2s");
		list.add("3s");
		list.add("4s");
		list.add("5s");
		list.add("6s");
		list.add("7s");
		list.add("8s");
		list.add("9s");
		list.add("10s");
		list.add("Js");
		list.add("Qs");
		list.add("Ks");
		//random
		Collections.shuffle(list);

		List[] lists = split(list);

		System.out.println("Player 1 "+lists[0]);
		System.out.println("Player 2 "+lists[1]);
		System.out.println("Player 3 "+lists[2]);
		System.out.println("Player 4 "+lists[3]);
	}
}
