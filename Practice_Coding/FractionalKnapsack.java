import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FractionalKnapsack {
	//Problem statement is given at the end of this program
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int length = values.length;
        
        double[] units = new double[length];
        for(int i=0;i<length;i++){
        	units[i] = ((double)values[i]/weights[i]);
        }
        
        int[] sorted = new int[length];
        int max = 0,j=0;
        double maxVal =0;
        while(length>0){
        	maxVal = 0;
        	for(int i=0;i<units.length;i++){
            	if(units[i]>maxVal)
            	{
            		max = i;
            		maxVal = units[i];		
            	}
            }
        	units[max] = -1;
        	sorted[j++] = max;
        	--length;
        }
        
        int a;
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        for(int i =0;i<units.length;i++){
        	if(capacity > 0){
        		a = getMinimum(weights[sorted[i]],capacity);
        		Double v = Double.parseDouble((df.format(a*((double)values[sorted[i]]/weights[sorted[i]]))));
        		value = Double.parseDouble(df.format(value + v));
        		capacity = capacity - a;
        		weights[sorted[i]] = weights[sorted[i]] - a;
         	}        		
        	else {		
        		return Double.parseDouble(df.format(value));
        	}
        }
        return value;
    }
    
	private static int getMinimum(int a,int b){
    	if(a<b) return a;
    	return b;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
        scanner.close();
    }
} 

/*Problem: Fractional Knapsack
Problem Introduction
Given a set of items and total capacity of a knapsack, nd the maximal value of fractions of items that t
into the knapsack.
Problem Description
Task. The goal of this code problem is to implement an algorithm for the fractional knapsack problem.
Input Format. The rst line of the input contains the number n of items and the capacity W of a knapsack.
The next n lines dene the values and weights of the items. The i-th line contain integers vi and wi |
the value and the weight of i-th item, respectively.
Constraints. 1  n  103, 0  W  2  106; 0  vi  2  106, 0 < wi  2  106 for all 1  i  n. All the
numbers are integers.
Output Format. Output the maximal value of fractions of items that t into the knapsack. The absolute
value of the dierence between the answer of your program and the optimal value should be at most
103. To ensure this, output your answer with at least four digits after the decimal point (otherwise
your answer, while being computed correctly, can turn out to be wrong because of rounding issues).
Time Limits. C: 1 sec, C++: 1 sec, Java: 1.5 sec, Python: 5 sec. C#: 1.5 sec, Haskell: 2 sec, JavaScript:
3 sec, Ruby: 3 sec, Scala: 3 sec.
Memory Limit. 512Mb.
Sample 1.
Input:
3 50
60 20
100 50
120 30
Output:
180.0000
Explanation:
To achieve the value 180, we take the rst item and the third item into the bag.
Sample 2.
Input:
1 10
500 30
Output:
166.6667
Explanation:
Here, we just take one third of the only available item.
*/