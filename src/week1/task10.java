package week1;

import java.util.Scanner;

public class Task10 {

	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number of decimal system - ");
		int number = scanner.nextInt();
		
		String strngNumber = "", revers = "";
	
		while (number >= 1) {
			strngNumber = strngNumber.concat(number % 2 == 0 ? "0" : "1");
			number /=2;
		}
		for(int i = strngNumber.length()-1; i >= 0; i--) {
			revers += strngNumber.charAt(i);
		}
		System.out.println(revers);
		
		
		System.out.print("Enter the number of binary system - ");
		String binary = scanner.next();
		scanner.close();
		int decimal = 0;
		
		for (int i = 0; i < binary.length(); i++) {
			decimal += Math.pow(2, i) * (binary.charAt((binary.length()-1) - i) == '1' ? 1 : 0) ;
		}
		System.out.println(decimal);
	}

}
