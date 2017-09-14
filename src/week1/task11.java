package week1;

import java.util.Scanner;

public class Task11 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number - ");
		int number = scanner.nextInt();
		scanner.close();
		
		int result = 1;
		for (int i = number; i > 0; i--) {
			result *= i; 
		}
		System.out.println(result);
	}
	
}
