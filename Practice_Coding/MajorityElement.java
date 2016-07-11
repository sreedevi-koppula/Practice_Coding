import java.util.*;
import java.io.*;

public class MajorityElement {
	//Problem statement is provided at the end of this program
	
	//This is a recursive method that computes the majority element from the given array 'a'
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
        	return a[left];
        }
        
        int mid = (left+right)/2;
        int leftMaj = getMajorityElement(a,left,mid);
        int rightMaj = getMajorityElement(a,mid+1,right);
        int overallMajority = majority(a,leftMaj,rightMaj,left,right);
        return overallMajority;
    }

    //This method finds the number of occurrences of the majority element in the left half
    //and then the number of occurrences of the majority element in the right half
    //Compares the count of the occurrences and returns the appropriate majority element
    //that lies in the range 'left' - 'right' of the array 'a'
    private static int majority(int[] a, int leftMaj, int rightMaj, int left, int right) {
    	int lcount = findCount(a,leftMaj,left,right);
        if(leftMaj == rightMaj)
        	return leftMaj;
        int rcount = findCount(a,rightMaj,left,right);
        if(lcount>rcount) return leftMaj;
        else if(lcount<rcount) return rightMaj;
        else return -1;
	}

    //This method finds the number of occurrences of 'ele' in the array 'a' 
    //beginning at index 'left' until the index 'right'
	private static int findCount(int[] a, int ele, int left, int right) {
		int count = 0;
		for(int i=left;i<=right;i++){
			if(a[i] == ele)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        //Reading inputs from the user
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int len = a.length -1;
        
        //Finding the majority element 'ele' in the given array
        int ele = getMajorityElement(a, 0, len);
        if (ele != -1 && (findCount(a,ele,0,len) > (a.length/2))) {
        		System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

/*2 Problem: Majority Element
Problem Introduction
An element of a sequence of length n is called a majority element if it appears in the sequence strictly more
than n=2 times.
Problem Description
Task. The goal in this code problem is to check whether an input sequence contains a majority element.
Input Format. The rst line contains an integer n, the next one contains a sequence of n non-negative
integers a0,a1,a2,....,a(n-1).
Constraints. 1<=n<=10power(5); 0<=ai<=10power(9) for all 0<=i < n.
Output Format. Output 1 if the sequence contains a majority element and 0 otherwise.
Time Limits. C: 1 sec, C++: 1 sec, Java: 1.5 sec, Python: 5 sec. C#: 1.5 sec, Haskell: 2 sec, JavaScript:
3 sec, Ruby: 3 sec, Scala: 3 sec.
Memory Limit. 512Mb.
Sample 1.
Input:
5
2 3 9 2 2
Output:
1
Explanation:
2 is the majority element.
Sample 2.
Input:
4
1 2 3 4
Output:
0
Explanation:
There is no majority element in this sequence.
Sample 3.
Input:
4
1 2 3 1
Output:
0
Explanation:
This sequence also does not have a majority element (note that the element 1 appears twice and hence
is not a majority element).*/