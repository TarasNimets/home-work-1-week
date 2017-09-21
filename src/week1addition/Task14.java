package week1addition;

import java.util.Scanner;

public class Task14 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the six-digit number - ");
		int number = scanner.nextInt();
		
		if (number / 1000000 != 0 || number < 100000) {
			System.out.println("Enter incorrect nubmer");
			return;
		}
		
		int lastNumber, lastSum = 0, firstSum = 0;
		while (number > 999) {
			lastNumber = number % 10;
			number /= 10;
			lastSum += lastNumber;
		}
		while (number > 0) {
			lastNumber = number % 10;
			number /= 10;
			firstSum += lastNumber; 
		}
		if (firstSum == lastSum) {
			System.out.println("Your ticket are happy");
		}else {
			System.out.println("Your ticket aren't happy");
		}
		
		
	}

}
