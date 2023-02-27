package com.capgemini.assignments;
import java.util.Scanner;

class assignment01{
	double nec,ffa,edu,ltss,play,give,inc;
	
	double NEC(double inc){
	    int nec = (int)(inc*.55);
		System.out.println("NEC: "+nec);
		return nec;
	}
	double FFA(double inc){
		int ffa = (int)(inc*.10);
		System.out.println("FFA: "+ffa);
		return ffa;		
	}
	double EDU(double inc){
		int edu = (int)(inc*.10);
		System.out.println("EDU: "+edu);
		return edu;		
	}
	double LTSS(double inc){
		int ltss = (int)(inc*.10);
		System.out.println("LTSS: "+ltss);
		return ltss;		
	}
	double PLAY(double inc){
		int play = (int)(inc*.10);
		System.out.println("PLAY: "+play);
		return play;		
	}
	double GIVE(double inc){
		int give = (int)(inc*.05);
		System.out.println("GIVE: "+give);
		return give;		
	}
	
	public static void main(String[] args) {
	    Scanner myObj = new Scanner(System.in);
	    System.out.println("Enter your income this month:");
	    double income = myObj.nextInt();  
	    double inc = income;
	    assignment01 a = new assignment01();
	    System.out.println("Here s how you should manage your money:");
		int nec=(int)a.NEC(inc);
		int ffa=(int)a.FFA(inc);
		int edu=(int)a.EDU(inc);
		int ltss=(int)a.LTSS(inc);
		int play=(int)a.PLAY(inc);
		int give=(int)a.GIVE(inc);
	  }
}
