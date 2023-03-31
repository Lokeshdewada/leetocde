//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{

	void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	void sort(int [] arr, int i, int j) {
		Arrays.sort(arr, i, j);
		while(i < j) {
			swap(arr, i++, --j);
		}
	}

	int [] lexicographicallyLargest(int [] arr, int n) {
		int i=0;
        while(i<n)
        {
            int j=i+1;
            while(j<n && arr[j]%2 == arr[j-1]%2)
            {
                j++;
            }
            sort(arr, i, j);
            i=j;
        }
        return arr;
	}
}