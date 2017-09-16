package week1addition;

import java.util.Scanner;

public class Task3 {
	
	   public static void main(String[] arg) {

	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the number - ");
	        int number = scanner.nextInt();

	        int countA = 0, a = number, tempA = 0, tempEtalonA = a % 10;
	        int countB = 0, b, tempB;
	        int i = 0;
	        while (a > 0) {
	            tempA = a % 10;
	            a /= 10;
	            i++;
	            if (tempA  == tempEtalonA) {
	                countA++;
	            }
	            b = number;
	            countB = 0;
	            while (b > 0) {
	                tempB = b % 10;
	                b /= 10;
	                if (tempB == tempA) {
	                    countB++;
	                }
	            }

	        }

	        if (countB > 1) {
	            System.out.println("Condition 'b' is true \nNumber " + tempA + " repeats " + countB + " times");
	        } else {
	            System.out.println("Condition 'b' is false");
	        }


	        if (countA == i) {
	            System.out.println("Condition 'a' is true \nAll numbers are equal");
	        }else {
	            System.out.println("Condition 'a' is false");
	        }

	    }
	
}
