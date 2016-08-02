import java.util.*;

class EditDistance {
	//Problem statement is provided at the end of this program
	
	//Dynamic programming approach to calculate the edit distance
	public static int EditDist(String s, String t) {
		int rows = s.length()+1, cols = t.length()+1; //rows = 8, cols = 9
		if(rows ==1) return cols-1;
		if(cols ==1) return rows-1;
	    int[][] arr = new int[rows][cols];
	    for(int i=0;i<rows;i++)
	    	arr[i][0] = i;
	    for(int i=1;i<cols;i++)
	    	arr[0][i] = i;
	    for(int i=1;i<cols;i++){
	    	for(int j=1;j<rows;j++){
	    		if(s.charAt(j-1) == t.charAt(i-1)){
	    			arr[j][i] = arr[j-1][i-1];
	    		} else
	    			arr[j][i] = min(arr[j][i-1]+1,
	    					arr[j-1][i]+1,
	    					arr[j-1][i-1]+1);
	    	}
	    }
	    return arr[rows-1][cols-1];
	  }
	  
	//Method to find the minimum integer of the given three integers
	  private static int min(int a, int b, int c){
		  if(a<b && a<c)
			  return a;
		  else if(b<a && b<c)
			  return b;
		  else return c;
	  }

  
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    //Reading two strings as input from the user
    String s = scan.nextLine();
    String t = scan.nextLine();
    scan.close();
    
    //Calculating the edit distance between the two user specified string and printing the edit distance
    System.out.println(EditDist(s, t));
  }

}

/*
Problem: Compute the Edit Distance Between Two Strings
Problem Introduction
The edit distance between two strings is the minimum number of insertions, deletions, and mismatches in
an alignment of two strings.
Problem Description
Task. The goal of this problem is to implement the algorithm for computing the edit distance between two
strings.
Input Format. Each of the two lines of the input contains a string consisting of lower case latin letters.
Constraints. The length of both strings is at least 1 and at most 100.
Output Format. Output the edit distance between the given two strings.
Time Limits.
language C C++ Java Python C# Haskell JavaScript Ruby Scala
time in seconds 1 1 1.5 5 1.5 2 5 5 3
Memory Limit. 512Mb.
Sample 1.
Input:
ab
ab
Output:
0
Sample 2.
Input:
short
ports
Output:
3
Sample 3.
Input:
editing
distance
Output:
5
*/