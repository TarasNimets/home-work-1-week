package week1addition;

import java.util.Scanner;

public class Task13 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the first number - ");
		double firstNumber = scanner.nextDouble();

		System.out.print("Enter the second number - ");
		double secondNumber = scanner.nextDouble();

		System.out.print("Enter the thrid number - ");
		double thridNumber = scanner.nextDouble();
		
		if ( (firstNumber + secondNumber + thridNumber) > 0) {
			firstNumber *= 2;
			secondNumber *= 2;
			thridNumber *= 2;
		}else {
			firstNumber = 0;
			secondNumber = 0;
			thridNumber = 0;
		}
		System.out.printf("First number = %.1f \nSecond number = %.1f \nThrid number = %.1f", firstNumber, secondNumber, thridNumber );

	}

}
