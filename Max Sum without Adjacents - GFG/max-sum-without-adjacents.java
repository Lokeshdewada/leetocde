//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return findsum(arr,0,n,dp);
    }
    public static int findsum(int[] arr,int curr,int n,int[] dp){
        if(curr>=n)
            return 0;

        if(dp[curr] != -1)
            return dp[curr];

        int take =arr[curr] + findsum(arr,curr+2,n,dp);
        int notake = findsum(arr,curr+1,n,dp);

        return dp[curr] = Math.max(take,notake);
    }
}