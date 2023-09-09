package me.joeyduv.findLargestNum;

public class Main {
	
	public static void main(String[] args) {
		// array of numbers to examine
		int[] numArray = {0,5,4,2,3,1,8,9,6,7};
		int largestNum = numArray[0];
		
		// examine array
		for (int currentNumber : numArray) {
			// discover if current number is the largest thus far
			if (currentNumber > largestNum) {
				largestNum = currentNumber;
			}
		}
		// display largest number
		System.out.println(largestNum);
	}
}