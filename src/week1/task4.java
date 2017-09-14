package week1;

import java.util.Scanner;

public class Task4 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter fractional number -  ");
		double number = scanner.nextDouble();
		scanner.close();
		
		if (number >= 0 && number <= 1) {
			System.out.println("Number in range with 0 to 1");
		}else {
			System.out.println("Number is not in range with 0 to 1");
		}
		
		
	
	}

}
