package week1;

import java.util.Scanner;

public class task5 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the first number - ");
		int firstNumber = scanner.nextInt();
		
		System.out.print("Enter the second number - ");
		int secondNumber = scanner.nextInt();
		scanner.close();
		
		if (firstNumber > secondNumber) {
			System.out.println("Difference of numbers = " + (firstNumber - secondNumber));
		}else {
			System.out.println("Multiplication of numbers = " + (firstNumber * secondNumber));
		}

	}

}
