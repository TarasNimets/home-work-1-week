package week1;

import java.util.Scanner;

public class task7 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the first number - ");
		int firstNumber = scanner.nextInt();
		
		System.out.print("Enter the second number - ");
		int secondNumber = scanner.nextInt();
		scanner.close();
		
		int div;
		
		if (firstNumber == secondNumber) {
			System.out.println("true \nDivisible  = 1");
			return;
		}
		if (firstNumber > secondNumber) {
			div = firstNumber % secondNumber;
			if (div == 0) {
				System.out.println("true \nDivisible = " + (firstNumber / secondNumber));
			}else {
				System.out.println("false \nWhole part = " + (firstNumber / secondNumber) + "\nRemaining from division = " + div);
			}
		}else {
			div = secondNumber % firstNumber;
			if (div == 0) {
				System.out.println("true \nDivisible = " + (secondNumber / firstNumber));
			}else {
				System.out.println("false \nWhole part = " + (secondNumber / firstNumber) + "\nRemaining from division = " + div);
			}
			
		}
	
	
	}
	

}
