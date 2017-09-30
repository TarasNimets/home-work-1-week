package week2;

public class CodingBat2 {

	private static CodingBat2 codingBat = new CodingBat2();

	public static void main(String[] args) {

		System.out.println(codingBat.delDel("adelxcv"));
		System.out.println(codingBat.mixStart("Mix sfd"));
		System.out.println(codingBat.startOz("osdf"));
		System.out.println(codingBat.intMax(8, 9, 1));
		System.out.println(codingBat.close10(17, 4));
		System.out.println(codingBat.in3050(40, 47));
		System.out.println(codingBat.max1020(17, 21));
		System.out.println(codingBat.stringE("sdesdfsdf"));
		System.out.println(codingBat.lastDigit(18, 118));
		System.out.println(codingBat.endUp("sdfdsgfd"));
		System.out.println(codingBat.everyNth("qazwsxedcrfv", 2));

	}

	// Given a string, if the string "del" appears starting at index 1, return a
	// string where that "del" has been deleted.
	// Otherwise, return the string unchanged.
	//
	//
	// delDel("adelbc") → "abc"
	// delDel("adelHello") → "aHello"
	// delDel("adedbc") → "adedbc"

	public String delDel(String str) {
		return str.startsWith("del", 1) ? str.replace("del", "") : str;
	}

	// Return true if the given string begins with "mix", except the 'm' can be
	// anything, so "pix", "9ix" .. all count.
	//
	//
	// mixStart("mix snacks") → true
	// mixStart("pix snacks") → true
	// mixStart("piz snacks") → false

	public boolean mixStart(String str) {
		return str.startsWith("ix", 1);
	}

	// Given a string, return a string made of the first 2 chars (if present),
	// however include first char only if it is 'o' and include the second only if
	// it is 'z', so "ozymandias" yields "oz".
	//
	// startOz("ozymandias") → "oz"
	// startOz("bzoo") → "z"
	// startOz("oxx") → "o"
	public String startOz(String str) {
		return str.startsWith("o") ? (str.startsWith("z", 1) ? "oz" : "o") : (str.startsWith("z", 1) ? "z" : "");
	}

	// Given three int values, a b c, return the largest.
	//
	//
	// intMax(1, 2, 3) → 3
	// intMax(1, 3, 2) → 3
	// intMax(3, 2, 1) → 3
	public int intMax(int a, int b, int c) {
		if (Math.max(a, b) > c) {
			return Math.max(a, b);
		}
		return c;
	}

	// Given 2 int values, return whichever value is nearest to the value 10, or
	// return 0 in the event of a tie.
	// Note that Math.abs(n) returns the absolute value of a number.
	//
	//
	// close10(8, 13) → 8
	// close10(13, 8) → 8
	// close10(13, 7) → 0
	public int close10(int a, int b) {
		if (Math.abs(10 - a) == Math.abs(10 - b))
			return 0;
		if (Math.abs(10 - a) > Math.abs(10 - b))
			return b;
		return a;
	}

	// Given 2 int values, return true if they are both in the range 30..40
	// inclusive, or they are both in the range 40..50 inclusive.
	//
	//
	// in3050(30, 31) → true
	// in3050(30, 41) → false
	// in3050(40, 50) → true
	public boolean in3050(int a, int b) {
		return (a >= 30 && a <= 40) && (b >= 30 && b <= 40) || (a >= 40 && a <= 50) && (b >= 40 && b <= 50);
	}

	// Given 2 positive int values, return the larger value that is in the range
	// 10..20 inclusive, or return 0 if neither is in that range.
	//
	//
	// max1020(11, 19) → 19
	// max1020(19, 11) → 19
	// max1020(11, 9) → 11
	public int max1020(int a, int b) {
		boolean aTrue = a >= 10 && a <= 20;
		boolean bTrue = b >= 10 && b <= 20;
		if (aTrue && bTrue)
			return Math.max(a, b);
		if (aTrue)
			return a;
		if (bTrue)
			return b;
		return 0;
	}

	// Return true if the given string contains between 1 and 3 'e' chars.
	//
	//
	// stringE("Hello") → true
	// stringE("Heelle") → true
	// stringE("Heelele") → false
	public boolean stringE(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'e')
				count++;
		}
		return count >= 1 && count <= 3;
	}

	// Given two non-negative int values, return true if they have the same last
	// digit, such as with 27 and 57.
	// Note that the % "mod" operator computes remainders, so 17 % 10 is 7.
	//
	//
	// lastDigit(7, 17) → true
	// lastDigit(6, 17) → false
	// lastDigit(3, 113) → true
	public boolean lastDigit(int a, int b) {
		return a % 10 == b % 10;
	}

	// Given a string, return a new string where the last 3 chars are now in upper
	// case.
	// If the string has less than 3 chars, uppercase whatever is there.
	// Note that str.toUpperCase() returns the uppercase version of a string.
	//
	//
	// endUp("Hello") → "HeLLO"
	// endUp("hi there") → "hi thERE"
	// endUp("hi") → "HI"
	public String endUp(String str) {
		return str.length() >= 3
				? str.substring(0, str.length() - 3) + str.substring(str.length() - 3, str.length()).toUpperCase()
				: str.toUpperCase();
	}

	// Given a non-empty string and an int N, return the string made starting with
	// char 0, and then every Nth char of the string.
	// So if N is 3, use char 0, 3, 6, ... and so on. N is 1 or more.
	//
	//
	// everyNth("Miracle", 2) → "Mrce"
	// everyNth("abcdefg", 2) → "aceg"
	// everyNth("abcdefg", 3) → "adg"
	public String everyNth(String str, int n) {
		String charAdd = "";
		int iter = n;
		n = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i > n) n += iter;
			if (i == n)
				charAdd += str.charAt(i);
		}
		return charAdd;
	}

}
