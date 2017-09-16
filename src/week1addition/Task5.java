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
				
		if (firstNumber < 11 && secondNumber < 11 && thridNumber < 11) {
			System.out.println("All nambers hasn't the same pairs");
			return;
		}
		math(firstNumber);
		math(secondNumber);
		math(thridNumber);
	
	}
	
	public static void math(int number) {
		int numberInA = number, numberInB = number;
		int tempA = numberInA, tempB, lastNumberB, count = 0, lastNumberA;
		
		while (tempA > 0) {
			lastNumberA = tempA % 10;
			tempA /= 10;
			tempB = numberInB;
			count = 0;
			while (tempB> 0) {
				lastNumberB = tempB % 10;
				tempB /= 10;
				if (lastNumberA == lastNumberB) {
					count++;
				}
			}
		}
		if (count > 1) {
			System.out.println("Number " + numberInA + " has the same pairs");
			return;
		}

		
	}
		
}
