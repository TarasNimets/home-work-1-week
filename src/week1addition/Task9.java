package week1addition;

import java.util.Scanner;

public class Task9 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Are you man or woman? (m/w) - ");
		String family = scanner.next();
		
		if (!(family.equals("m") || family.equals("w"))) {
			System.out.println("Enter incorrect data");
			return;
		}
		
		System.out.print("Enter your height - ");
		int height = scanner.nextInt();

		if (height < 110 || height > 230) {
			System.out.println("Enter incorrect height");
			return;
		}

		System.out.print("Enter your weight - ");
		int weight = scanner.nextInt();
		
		if (family.equals("m")) {
			int etalonWeight =(int) ((height - 100) * 1.15);
			outMassage(height, etalonWeight, weight);
		}
		
		if (height < 166) {
			int etalonWeight =(int) ((height - 100) * 1.15);
			outMassage(height, etalonWeight, weight);
		}else if (height >= 166 && height < 175) {
			int etalonWeight =(int) ((height - 105) * 1.15);
			outMassage(height, etalonWeight, weight);
		}else if (height >= 175) {
			int etalonWeight =(int) ((height - 110) * 1.15);
			outMassage(height, etalonWeight, weight);
		}
		
	}
	
	public static void outMassage(int height, int etalonWeight, int weight) {
		if (weight == etalonWeight) {
			System.out.println("Your weight is perfect :-)");
		}else if (weight > etalonWeight) {
			System.out.printf("You need to lose weight.\nPerfect weight is %d, but you weight  - %d", etalonWeight, weight);
		}else {
			System.out.printf("You need to increase weight.\nPerfect weight is %d, but you weight  - %d", etalonWeight, weight);
		}
		
	}

}
