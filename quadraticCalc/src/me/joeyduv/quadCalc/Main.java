package me.joeyduv.quadCalc;

import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;

public class Main {
	
	public static double[] calculateQuadraticRoots(double a, double b, double c) {

		double addCase = (-b + Math.sqrt((Math.pow(b, 2.0) - 4.0 * a * c)) / 2.0 * a);
		double subtractCase = (-b - Math.sqrt((Math.pow(b, 2.0) - 4.0 * a * c)) / 2.0 * a);
		
		double[] results = {addCase, subtractCase};
		return results;
	}
	
	public static void main(String args[]) {
		// get user input
		Scanner scanner = new Scanner(System.in);
		
		try {
			// input
			System.out.println("Enter 'a':"); // prompt
			double a = scanner.nextDouble(); // get a
			
			System.out.println("Enter 'b':"); // prompt
			double b = scanner.nextDouble(); // get b
			
			System.out.println("Enter 'c':"); // prompt
			double c = scanner.nextDouble(); // get c
			
			// calculate roots and display them
			double[] results = calculateQuadraticRoots(a, b, c);
			
			System.out.println("Roots:");
			
			for (double root : results) {
				if (!Double.isFinite(root)) {
					System.out.println("Non-real");
				}
				else {
					System.out.println(root);
				}
			}
		}
		catch (InputMismatchException e) {
			scanner.close(); // stop leak
			throw e;
		}	
		scanner.close(); // stop leak
	}
}