package june26;

import java.util.Scanner;

public class KaratsubaMultiplication {
	//Time complexity - O(n^log3)
	//Recurrence Relation --> T(n) = 3T(n/2)+c
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.next();
		String b = scanner.next();
		scanner.close();
		System.out.println(multiply(a,b));
	}
	
	public static long multiply(String a,String b){
		//Finding the lengths of the inputs
		int countOfDigits_a = a.length();
		int countOfDigits_b = b.length();
		
		//If the lengths of input string are not equal, padding zeros to the beginning of the string that has lesser length
		//In simple words, we are making the lengths of both input strings to be equal
		if(countOfDigits_a<countOfDigits_b){
			int tempCount = 0;
			while(++tempCount < countOfDigits_b)
				a = "0"+a;
		} else if(countOfDigits_a>countOfDigits_b){
			int tempCount = 0;
			while(++tempCount < countOfDigits_a)
				b = "0"+b;
		}
		
		int countOfDigits = a.length();
		
		//Base case for the recursion
		//If the number of digits in both the given inputs are equal to 1, 
		//then the multiplication operation is performed on the 1 digit numbers and the value is returned
		if(countOfDigits_a == 1 && countOfDigits_b == 1)
			return Long.parseLong(a)*Long.parseLong(b);
		
		if(countOfDigits%2 ==1)
			countOfDigits--;
		//else the 'multiply' method is called recursively to calculate the below:
		// (a0a1)*(b0b1) = [(a0b0)*10^(length_of_number)]+[[(a0+a1)(b0+b1)-(a0b0)-(a1b1)]*10^(length_of_number/2)]+[(a1b1)]
		int power = (int) Math.pow(10,(countOfDigits/2));
		int a0 = Integer.parseInt(a)/power;
		int a1 = Integer.parseInt(a)%power;
		int b0 = Integer.parseInt(b)/power;
		int b1 = Integer.parseInt(b)%power;

		long result =0;
		long a0b0 = multiply(String.valueOf(a0),String.valueOf(b0));
		long a1b1 = multiply(String.valueOf(a1),String.valueOf(b1));
		long midTerm = multiply(String.valueOf(a0+a1),String.valueOf(b0+b1))-a0b0-a1b1;
		result = (long) (a0b0*Math.pow(10,(countOfDigits))+midTerm*power+a1b1);

		//returning the final result value
		return result;
	}
}
