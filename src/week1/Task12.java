package week1;

import java.util.Scanner;

public class Task12 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number - ");
		int number = scanner.nextInt();
		scanner.close();
		
//		int[] array = new int[number+1];
//		array[0] = 0;
//		array[1] = 1;
//		for (int i = 1; i < number; i++) {
//			array[i+1] = array[i] + array[i-1]; 
//		}
//		System.out.println(array[number]);
		if (number < 3) {
			if (number == 0) {
				System.out.println(0);
				return;
			}else {
				System.out.println(1);
				return;
			}
		}
		
		int a = 0, b = 1, c = 0;
		int i = 1;
		while (i < number) {
			c = a + b;
			a = b;
			b = c;
			i++;
		}
		System.out.println(c);

	}

}
