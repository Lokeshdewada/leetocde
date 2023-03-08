//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N, K, W;
			String [] str = br.readLine().trim().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);
			W = Integer.parseInt(str[2]);
			str = br.readLine().trim().split(" ");
			int [] arr = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution obj = new Solution();
			System.out.println(obj.maximizeMinHeight(N, K, W,arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    boolean isOK(int[] arr, int days, int cs, long h){
        int n = arr.length;
        long[] waterSupply = new long[n];
        if (arr[0] < h){
            waterSupply[0] = h - arr[0];
            days -= h - arr[0];
        }
        if (days < 0){
            return false;
        }
        for (int i = 1; i < n; i++){
            waterSupply[i] = waterSupply[i - 1];
            int actualHeight = arr[i];
            if (i >= cs){
                actualHeight += waterSupply[i] - waterSupply[i - cs];
            } else {
                actualHeight += waterSupply[i];
            }
            if (actualHeight < h){
                waterSupply[i] += h - actualHeight;
                days -= h - actualHeight;
            }
            if (days < 0){
                return false;
            }
        }
        return true;
    }

	long maximizeMinHeight(int N, int K, int W,int [] a)
    {
        long res = -1;
        long mnHeight = Arrays.stream(a).min().getAsInt();
        long mxHeight = Integer.MAX_VALUE / 2;
        while (mnHeight <= mxHeight){
            long guessHeight = (mxHeight + mnHeight) / 2;
            if (isOK(a, K, W, guessHeight)){
                res = guessHeight;
                mnHeight = guessHeight + 1;
            } else {
                mxHeight = guessHeight - 1;
            }
        }
        return res;
    }
}