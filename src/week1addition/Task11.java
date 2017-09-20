package week1addition;

import java.util.Scanner;

public class Task11 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number from 1 to 99 - ");
		int number = scanner.nextInt();
		int lastNumber,firstNumber, result = number;

		if (number < 10) {
			lastNumber = number;
			firstNumber = 0;
		}else {
			lastNumber = number % 10;
			number -=lastNumber;
			firstNumber = number / 10;
		}
		
		if (firstNumber != 1 && lastNumber == 1) {
			System.out.println(result + " kopeyka");
		}else if (firstNumber != 1 && (lastNumber == 2 || lastNumber == 3 || lastNumber == 4) ) {
			System.out.println(result + " kopeyki");
		}else {
			System.out.println(result + " kopeek");
		}
		
	}


}
