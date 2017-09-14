package week1;

import java.util.Scanner;

public class Task13 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number - ");
		int number = scanner.nextInt();
		
		if (number == 1) {
			System.out.println("1 and 2");
			return;
		} else if (number == 0) {
			System.out.println(0);
			return;
		}
		
		int a = 0, b = 1, c = 0;
		int i = 1;
		while (c < number) {
			c = a + b;
			a = b;
			b = c;
			i++;
		}
		if (c == number) {
			System.out.println(i);
		}else {
			System.out.println(-1);
		}
	}

}
