import java.math.BigInteger;
import java.util.*;

public class DotProduct {
	//The problem statement is provided at the end of this program
    private static long minDotProduct(int[] a, int[] b) {
        long result = 0;
		Arrays.sort(a);
		Arrays.sort(b);
		for(int left=0,right = b.length-1;left<right;left++,right--){
			int temp = b[left];
			b[left] = b[right];
			b[right] = temp;
		}
		BigInteger bi = null; 
        for (int i = 0; i < a.length; i++) {
        	if(bi == null){
        		bi = BigInteger.valueOf(a[i]).multiply(BigInteger.valueOf(b[i]));
        	} else
        		bi = bi.add(BigInteger.valueOf(a[i]).multiply(BigInteger.valueOf(b[i])));
        }
        result = bi.longValue();
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long score = -1;

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
        	a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
        	b[i] = scanner.nextInt();
        }
        score = minDotProduct(a,b);
        System.out.println(score);

        scanner.close();
    }
}

/*
Problem: Minimum Dot Product
Problem Introduction
The dot product of two sequences a1; a2; : : : ; an and b1; b2; : : : ; bn of the same length is equal to
Xn
i=1
aibi = a1b1 + a2b2 +    + anbn :
Problem Description
Task. The goal is, given two sequences a1; a2; : : : ; an and b1; b2; : : : ; bn, nd a permutation  of the second
sequence such that the dot product of a1; a2; : : : ; an and b1 ; b2 ; : : : ; bn is minimum.
Input Format. The rst line contains an integer n, the second one contains a sequence of integers
a1; a2; : : : ; an, the third one contains a sequence of integers b1; b2; : : : ; bn.
Constraints. 1  n  103; 105  ai; bi  105 for all 1  i  n.
Output Format. Output the minimum possible dot product.
Time Limits. C: 1 sec, C++: 1 sec, Java: 1.5 sec, Python: 5 sec. C#: 1.5 sec, Haskell: 2 sec, JavaScript:
3 sec, Ruby: 3 sec, Scala: 3 sec.
Memory Limit. 512Mb.
Sample 1.
Input:
1
23
39
Output:
897
Explanation:
In this case, 897 is just the only possible dot product.
Sample 2.
Input:
3
1 3 -5
-2 4 1
Output:
-25
Explanation:
25 = 1  1 + 3  (2) + (5)  4.
*/