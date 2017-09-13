package week1;

import java.util.Scanner;

public class task6 {

	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the first number - ");
		int firstNumber = scanner.nextInt();
		
		System.out.print("Enter the second number - ");
		int secondNumber = scanner.nextInt();
		scanner.close();
		
		int sum = firstNumber + secondNumber;
		
		if (sum >= 11 && sum <=19) {
			System.out.println("Sum of numbers in range with 11 to 19");
		}else {
			System.out.println("Sum of numbers isn't in range with 11 to 19");
		}

	}

}
