package week1addition;

import java.util.Scanner;

public class Task15 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the area of the circle - ");
		double areaCircle = scanner.nextDouble();
		System.out.print("Enter the area of the square - ");
		double areaSquare = scanner.nextDouble();
		
		double aSquare = Math.sqrt(areaSquare);
		double dCircle = Math.sqrt((areaCircle * 4 / Math.PI));
		double diagonalSquare = Math.sqrt((2 * aSquare * aSquare));
		
		System.out.println("aSquare " + aSquare);
		System.out.println("dCircle " + dCircle);
		System.out.println("diagonalSquare " + diagonalSquare);
		
		if (dCircle <= aSquare) {
			System.out.println("Condition 'a' is true");
		}else if (diagonalSquare <= dCircle) {
			System.out.println("Condition 'b' is true");
		}else {
			System.out.println("Condition 'a' and 'b' is false");
		}
		
	}

}
