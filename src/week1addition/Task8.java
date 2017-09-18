package week1addition;

import java.util.Scanner;

public class Task8 {
	
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the cost of the purchase - ");
		double cost = scanner.nextDouble();
		
		if (cost >= 1000) {
			double discountCost = cost * 0.9 * 100; 
			System.out.println("Discount is charged \nPurchase Cost - " + (discountCost / 100));
		}else {
			System.out.println("Discount is not charged \nPurchase Cost - " + cost);
		}
		
	}

}
