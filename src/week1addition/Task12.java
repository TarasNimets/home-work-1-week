package week1addition;

import java.util.Scanner;

public class Task12 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the character of the wind (from 1 to 4) - ");
		int character = scanner.nextInt();
		
		switch (character) {
		case 1 : {
			System.out.println("Low wind. Him speed from 1 to 4 m/s");
			break;
		}
		case 2 : {
			System.out.println("Moderate wind. Him speed from 5 to 10 m/s");
			break;
		}
		case 3 : {
			System.out.println("Strong wind. Him speed from 11 to 18 m/s");
			break;
		}
		case 4 : {
			System.out.println("Hurricane wind. Him speed more 19 m/s");
			break;
		}
		default : System.out.println("Enter incorrect charakter of the wind");
		}
	}

}
