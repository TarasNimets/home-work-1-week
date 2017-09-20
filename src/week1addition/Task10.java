package week1addition;

import java.util.Scanner;

public class Task10 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the talk time in minutes - ");
		double talkTime = scanner.nextDouble();
		System.out.print("Enter the day of week (number from 1 to 7, when 1 - monday) - ");
		int day = scanner.nextInt();
		
		double cost = 0.5;
		
		if (day == 6 || day == 7) {
			System.out.println("The cost of talking - " + (talkTime * cost * 0.8) + " UAH");
		}else {
			System.out.println("The cost of talking - " + (talkTime * cost) + " UAH");
		}
		
	}

}
