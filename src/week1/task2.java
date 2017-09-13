package week1;

import java.util.Scanner;

public class task2 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the first number - ");
		int firstNumber = scanner.nextInt();
		
		System.out.print("Enter the second number - ");
		int secondNumber = scanner.nextInt();

		System.out.print("Enter the third number - ");
		int thirdNumber = scanner.nextInt();
		scanner.close();

		if (firstNumber > secondNumber) {
			
			if (firstNumber > thirdNumber) {
				System.out.println("Max number is - " + firstNumber);
			}else{
				System.out.println("Max number is - " + thirdNumber);
			}
		}else {
			if (secondNumber > thirdNumber) {
				System.out.println("Max number is - " + secondNumber);
			}else {
				System.out.println("Max number is - " + thirdNumber);
			}
		}
		
		if (firstNumber < secondNumber) {
			
			if (firstNumber < thirdNumber) {
				System.out.println("Min number is - " + firstNumber);
			}else{
				System.out.println("Min number is - " + thirdNumber);
			}
		}else {
			if (secondNumber < thirdNumber) {
				System.out.println("Min number is - " + secondNumber);
			}else {
				System.out.println("Min number is - " + thirdNumber);
			}
		}
		
	}

}
