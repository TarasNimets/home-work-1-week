package week1addition;

import java.util.Scanner;

public class Task1 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the first cathetus 'a' - ");
		int a = scanner.nextInt();
		
		System.out.print("Enter the second cathetus 'b' - ");
		int b = scanner.nextInt();

		System.out.print("Enter hypotenuse 'c' - ");
		int c = scanner.nextInt();
		
		if ((c*c) == (a*a + b*b)) {
			System.out.println("Rectangular triangle");
		}else {
			System.out.println("Triangle is not rectangular");
		}
		
	}
}
