package week1addition;

import java.util.Scanner;

public class Task4 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the speed in km/h - ");
		double speedKMH = scanner.nextDouble();
		
		System.out.print("Enter the speed in m/s - ");
		double speedMS = scanner.nextDouble();
		
		double resultKMH = speedKMH / 3.6;
		
		if (resultKMH == speedMS) {
			System.out.println("Speeds are the same");
			return;
		}
		
		if (resultKMH > speedMS ) {
			System.out.println("Speed in km/h is bigger");
		}else {
			System.out.println("Speed in m/s is bigger");
		}
	}

}
