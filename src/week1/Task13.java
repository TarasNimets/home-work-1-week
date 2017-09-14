package week1;

import java.util.Scanner;

public class Task13 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number - ");
		int number = scanner.nextInt();
		
		if (number == 1) {
			System.out.println("2 and 3");
			return;
		}
		
		int[] array = new int[40];
		array[0] = 0;
		array[1] = 1;
		int i = 1;
		while (array[i] <= number) {

			array[i+1] = array[i] + array[i-1];
			System.out.print(array[i]);
			i++;

		}
		if (array[i-1] == number) {
			System.out.println(i);
		}else {
			System.out.println(-1);
		}
	}

}
