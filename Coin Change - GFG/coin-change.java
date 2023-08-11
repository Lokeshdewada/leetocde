//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java
class Solution {
    static long memo[][];
    static long findways(int arr[],int n,int sum){
        if(n==0 || sum<0){
            return 0;
        }
        if(sum==0){
            return 1;
        }
        if(memo[n][sum]!= -1) return memo[n][sum];
        long a=findways(arr,n,sum-arr[n-1]);
        long b=findways(arr,n-1,sum);

        return memo[n][sum]=a+b;
    }
    public long count(int coins[], int n, int sum) {
        memo=new long[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                memo[i][j]=-1;
            }
        }
        return findways(coins,n,sum);
    }
}