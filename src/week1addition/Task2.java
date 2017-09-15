package week1addition;

import java.util.Scanner;

public class Task2 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the first number - ");
		int firstNumber = scanner.nextInt();
		
		System.out.print("Enter the second number - ");
		int secondNumber = scanner.nextInt();

		System.out.print("Enter the thrid number - ");
		int thirdNumber = scanner.nextInt();
		int pow = 3;
		
		if (firstNumber > 0) firstNumber = (int) Math.pow(firstNumber, pow);
		else firstNumber = 0;
		
		if (secondNumber > 0) secondNumber = (int) Math.pow(secondNumber, pow);
		else secondNumber = 0;
		
		if (thirdNumber > 0) thirdNumber = (int) Math.pow(thirdNumber, pow);
		else thirdNumber = 0;

		System.out.println(firstNumber);
		System.out.println(secondNumber);
		System.out.println(thirdNumber);

	
	}
	


}
