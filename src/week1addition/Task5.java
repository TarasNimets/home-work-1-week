package week1addition;

import java.util.Scanner;

public class Task5 {
	
	public static void main(String[] arg) {
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the first number - ");
		int firstNumber = scanner.nextInt();
		
		System.out.print("Enter the second number - ");
		int secondNumber = scanner.nextInt();
		
		System.out.print("Enter the thrid number - ");
		int thridNumber = scanner.nextInt();
				
		if (firstNumber == secondNumber && firstNumber == thridNumber) {
			System.out.println("All nambers are the same");
			return;
		}else if(firstNumber == secondNumber) {
			System.out.println("First and second numbers are the same");
			return;
		}else if(firstNumber == thridNumber) {
			System.out.println("First and thrid numbers are the same");
			return;
		}else if (secondNumber == thridNumber) {
			System.out.println("Second and third numbers are the same");
			return;
		}else {
			System.out.println("They are not the same");
		}
			
	
	}
			
}
