package june26;

import java.util.Scanner;

public class ArrangeNumbersToFormBiggestNumber {
	//Problem statement is given at the end of this program
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//Reading the input 'Number of test cases' from the user
		int numOfTestCases = Integer.parseInt(scan.nextLine());
		String result[] = new String[numOfTestCases];
		int index = -1;
		
		while(numOfTestCases-- > 0){
			//Reading the input 'number of elements in the array' from the user
			int inputCount = Integer.parseInt(scan.nextLine());
			
			//Reading the actual elements of the array from the user
			int array[] = new int[inputCount];
			for(int i=0;i<inputCount;i++)
				array[i] = scan.nextInt();
			int[] newArray = new int[array.length];
			
			//Merge sort technique is used to arrange the given numbers in-order to form biggest number
			//The sorted array 'newArray' will have the values sorted as per the required order
			//Time complexity : O(n log(n))
			sort(0,array.length-1,array,newArray);
			
			//Below commented code takes O(n^2) to arrange the given numbers in-order to form biggest number
			/*while(inputCount-->0){
				for(int i=0;i<array.length-1;i++){
					int compResult = compare(array[i],array[i+1]);
					//if concatenation of array[i]array[i+1] is greater than array[i+1]array[i], then return 1
					//else return -1
					if(compResult == -1){
						int temp = array[i];
						array[i] = array[i+1];
						array[i+1] = temp;
					}	
				}
			}*/
			
			String concatResult = "";
			//Calculating the biggest number(storing it as a string)
			for(int num:newArray){
				concatResult = concatResult+""+num;
			}	
			result[++index] = concatResult;
		}
		scan.close();
		for(int i=0;i<result.length;i++)
			System.out.println("Case #"+(i+1)+": "+result[i]);
	}
	
	//Merge Sort implementation
	public static void sort(int start,int end,int[] array,int[] newArray){
		int first = start, last = end, mid;
		if(first == last)
			return;
		else{
			mid = (first+last)/2;
			sort(first,mid,array,newArray);
			sort(mid+1,last,array,newArray);
			merge(first,mid,last,array,newArray);
		}
	}
	
	//Merging the arrays as per our requirement 
	//The elements here not sorted in ascending/descending fashion, but sorted as per the below criteria:
	//Let a,b be two integers that are being compared for merging
	// 		if((aUb)>(bUa)) 
	//			add 'b' to the newArray
	//		else
	//			add 'a' to the newArray
	private static void merge(int start,int mid,int end,int[] array,int[] newArray){
		
		int i=0;
		int first = start,last = end,middle = mid+1;
		while(first<=middle-1 && middle<=last){
			if(compare(array[first],array[middle]) == -1)
				newArray[i++] = array[middle++];
			else if(compare(array[first],array[middle]) == 1)
				newArray[i++] = array[first++];
		}
		while(first<=mid){
			if(first == mid)
				newArray[i++] = array[first++];
			else {
				if(compare(array[first],array[first+1]) == -1)
					newArray[i++] = array[++first];
				else if(compare(array[first],array[first+1]) == 1){
					newArray[i++] = array[first++];
				}
			}
		}
		while(middle<=end){
			if(middle == end)
				newArray[i++] = array[middle++];
			else{
				if(compare(array[middle],array[middle+1]) == -1)
					newArray[i++] = array[middle++];
				else if(compare(array[middle],array[middle+1]) == 1 ){
					newArray[i++] = array[middle];
					middle++;
				}
			} 
		}
		
		for(int j=0;j<end-start+1;j++)
			array[start+j] = newArray[j];
	}
	
	//if((aUb)>(bUa)) return 1, else return -1
	public static int compare(int a, int b){
		int num1 = Integer.parseInt(a+""+b);
		int num2 = Integer.parseInt(b+""+a);
		return (num1>num2)?1:-1;
	}
}

/*Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.
The result is going to be very large, hence return the result in the form of a string.

Input:
The first line of input consists number of the test cases. The description of T test cases is as follows:
The first line of each test case contains the size of the array, and the second line has the elements of the array.

Output:
In each separate line print the largest number formed by arranging the elements of the array in the form of a string.

Constraints:
1 = T = 70
1 = N = 100
0 = A[i] = 1000

Example:

Input:
2
5
3 30 34 5 9
4
54 546 548 60

Output:
9534330
6054854654

*/