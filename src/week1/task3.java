package week1;

import java.util.Scanner;

public class task3 {

	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter number -  ");
		
		int number = scanner.nextInt();
		scanner.close();
		
		int division = number % 7;
		
		if (division == 0) {
			System.out.println("Square number - " + (number * 2));
		}else {
			System.out.println("The number is not divisible by 7 without a residual");
		}
	
	}

}
