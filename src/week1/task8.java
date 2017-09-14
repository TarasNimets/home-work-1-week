package week1;

import java.util.Scanner;

public class Task8 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the first number - ");
		int firstNumber = scanner.nextInt();
		
		System.out.print("Enter the second number - ");
		int secondNumber = scanner.nextInt();
		scanner.close();
		
		System.out.println((firstNumber % 10) == (secondNumber % 10));

	
	}

}
