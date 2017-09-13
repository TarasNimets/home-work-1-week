package week1;

import java.util.Scanner;

public class task1 {
	
	public static void main(String[] arg) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter time with 0 to 24 hour ");
		System.out.print("Your time - ");
	
		int time = scanner.nextInt();
		scanner.close();
	
		if (time >= 9 && time <= 18) {
			System.out.println("I'm at work");
		} else {
			System.out.println("I rest");
		}
	
	
	}

}
