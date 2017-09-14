package week1;

import java.util.Scanner;

public class task9 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number - ");
		int number = scanner.nextInt();
		scanner.close();
		
		int lastNumber, count = 0;
		
		while (number > 0) {
			lastNumber = number % 10;
			number /= 10;
			if (lastNumber == 5) {
				count +=1;
			}
		}
		if (count == 0) {
			System.out.println("The number hasn't '5'");
		}else {
			System.out.println("The number has '5' " + count + " times");
		}
		
		
	}

}
