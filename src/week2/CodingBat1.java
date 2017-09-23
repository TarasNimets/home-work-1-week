package week2;

public class CodingBat1 {
	
	public static void main(String[] args) {
		
		System.out.println(front3("ahha"));
		System.out.println(backAround("s"));
		System.out.println(or35(7));
		System.out.println(front22("ssdfslkd"));
		System.out.println(startHi("hi my frien"));
		System.out.println(icyHot(-2, 99));
		System.out.println(in1020(5, 15));
		System.out.println(hasTeen(19, 20, 1));
		System.out.println(loneTeen(18, 20));
		
	}
	
//	Given a string, we'll say that the front is the first 3 chars of the string. If the string length is less than 3, 
//	the front is whatever is there. Return a new string which is 3 copies of the front.
//
//	front3("Java") → "JavJavJav"
//	front3("Chocolate") → "ChoChoCho"
//	front3("abc") → "abcabcabc"
	public static String front3(String str) {
		  return str.length() >=3 ? str.substring(0, 3) + str.substring(0, 3) + str.substring(0, 3) : str + str + str;
		}
	
//	Given a string, take the last char and return a new string with the last char added at the front and back,
//			so "cat" yields "tcatt". The original string will be length 1 or more.
//
//			backAround("cat") → "tcatt"
//			backAround("Hello") → "oHelloo"
//			backAround("a") → "aaa"
	public static String backAround(String str) {
		  return str.charAt(str.length()-1) + str + str.charAt(str.length()-1);
		}
	
//	Return true if the given non-negative number is a multiple of 3 or a multiple of 5. Use the % "mod" operator -- see Introduction to Mod
//
//	or35(3) → true
//	or35(10) → true
//	or35(8) → false
	public static boolean or35(int n) {
		  return n % 3 == 0 || n % 5 == 0;
		}
	
//	Given a string, take the first 2 chars and return the string with the 2 chars added at both the front and back, 
//			so "kitten" yields"kikittenki". If the string length is less than 2, use whatever chars are there.
//
//			front22("kitten") → "kikittenki"
//			front22("Ha") → "HaHaHa"
//			front22("abc") → "ababcab"
	public static String front22(String str) {
		  return str.length() >= 2 ? str.substring(0, 2) + str + str.substring(0, 2) : str + str + str;
		}
	
//	Given a string, return true if the string starts with "hi" and false otherwise.
//
//			startHi("hi there") → true
//			startHi("hi") → true
//			startHi("hello hi") → false
	public static boolean startHi(String str) {
			return str.startsWith("hi");
		}
	
//	Given two temperatures, return true if one is less than 0 and the other is greater than 100.
//
//			icyHot(120, -1) → true
//			icyHot(-1, 120) → true
//			icyHot(2, 120) → false
	
	public static boolean icyHot(int temp1, int temp2) {
		  return temp1 < 0 && temp2 > 100 || temp1 > 100 && temp2 < 0; 
		}
	
//	Given 2 int values, return true if either of them is in the range 10..20 inclusive.
//
//			in1020(12, 99) → true
//			in1020(21, 12) → true
//			in1020(8, 99) → false
	public static boolean in1020(int a, int b) {
		  return a >= 10 && a <= 20 || b >=10 && b <=20;
		}
	
//	We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given 3 int values, return true if 1 or more of them are teen.
//
//	hasTeen(13, 20, 10) → true
//	hasTeen(20, 19, 10) → true
//	hasTeen(20, 10, 13) → true
	public static boolean hasTeen(int a, int b, int c) {
		return a <= 19 && a >= 13 || b >= 13 && b <= 19 || c >= 13 && c <= 19;
	}
	
//	We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given 2 int values,
//	return true if one or the other is teen, but not both.
//
//	loneTeen(13, 99) → true
//	loneTeen(21, 19) → true
//	loneTeen(13, 13) → false
	public static boolean loneTeen(int a, int b) {
		  return (a >= 13 && a <= 19 || b >=13 && b <=19) && !(a >= 13 && a <= 19 == b >=13 && b <=19);
		}

}
