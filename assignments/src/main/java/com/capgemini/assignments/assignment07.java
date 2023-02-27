package com.capgemini.assignments;
import java.util.Scanner;

public class assignment07 {

	public static void printArea(double [] X, double [] Y){
		//find area of triangle
		double area = Math.abs(X[0]*(Y[1]-Y[2]) + X[1]*(Y[2]-Y[0]) + X[2]*(Y[0]-Y[1]))/2;
		System.out.println("Area = " + area);
	}

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		//Point A x,y
		System.out.println("Point A ");
		System.out.println("x");
		double Ax = myObj.nextDouble();
		System.out.println("y");
		double Ay = myObj.nextDouble();
		//Point B x,y
		System.out.println("Point B ");
		System.out.println("x");
		double Bx = myObj.nextDouble();
		System.out.println("y");
		double By = myObj.nextDouble();
		//Point C x,y
		System.out.println("Point C ");
		System.out.println("x");
		double Cx = myObj.nextDouble();
		System.out.println("y");
		double Cy = myObj.nextDouble();
		double [] x_coordinates = {Ax,Bx,Cx};
		double [] y_coordinates = {Ay,By,Cy};
		printArea(x_coordinates, y_coordinates);
	}
}
