package week1;

import java.util.Scanner;

public class Task12 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number - ");
		int number = scanner.nextInt();
		scanner.close();
		
		int[] array = new int[number];
		array[0] = 0;
		array[1] = 1;
		
		for (int i = 2; i < number; i++) {
			array[i] = array[i-1] + array[i-2]; 
		}
		System.out.println(array[number-1]);

	}

}
