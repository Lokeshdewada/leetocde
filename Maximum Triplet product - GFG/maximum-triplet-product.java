//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution {
Long maxTripletProduct(Long arr[], int n)
{
    if (n < 3)
        return -1l;
    long maxA = Integer.MIN_VALUE,
        maxB = Integer.MIN_VALUE,
        maxC = Integer.MIN_VALUE;
    long minA = Integer.MAX_VALUE,
        minB = Integer.MAX_VALUE;
    for(int i = 0; i < n; i++)
    {
        if (arr[i] > maxA)
        {
            maxC = maxB;
            maxB = maxA;
            maxA = arr[i];
        }
        else if (arr[i] > maxB)
        {
            maxC = maxB;
            maxB = arr[i];
        }
        else if (arr[i] > maxC)
            maxC = arr[i];
        if (arr[i] < minA)
        {
            minB = minA;
            minA = arr[i];
        }
        else if(arr[i] < minB)
            minB = arr[i];
    }

    return Math.max(minA * minB * maxA,
                    maxA * maxB * maxC);
}
}


//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    Long[] arr = new Long[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Long.parseLong(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    Long res = obj.maxTripletProduct(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


// } Driver Code Ends