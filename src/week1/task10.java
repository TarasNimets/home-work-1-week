package week1;

import java.util.Scanner;

public class Task10 {

	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number of decimal system - ");
		int number = scanner.nextInt();
		
//		String binaryNumber = Integer.toBinaryString(number);
//		System.out.println(binaryNumber);
		int a,b;
		a = number % 2;
		
		System.out.println("number - " + number);
		
//		System.out.print("Enter the number of binary system - ");
//		String binary = scanner.next();
//		scanner.close();
//		int decimal = 0;
//		
//		for (int i = 0; i < binary.length(); i++) {
//			decimal += Math.pow(2, i) * (binary.charAt((binary.length()-1) - i) == '1' ? 1 : 0) ;
//		}
//		System.out.println(decimal);
	}

}
