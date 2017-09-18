package week1addition;

import java.util.Scanner;

public class Task6 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the speed in m/s - ");
		double speed = scanner.nextDouble();
		
		System.out.print("Enter the distance in m - ");
		double distance = scanner.nextDouble();
		
		double time = distance / speed * 100;
		time /= 100;
		System.out.println("Time of ride = " + time + "s");
	
	}


}
