//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

 class Solution {
        static int mod = (int)1e9 + 7; 
        public int CountWays(String str){
            int n = str.length();
            if(n == 0) return 0;
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return f(0, str, dp);
        }
        private int f(int i, String s, int[] dp){
            if(i == s.length()) return 1;
            if(s.charAt(i) == '0') return 0;
            if(dp[i] != -1) return dp[i];
            int take = f(i + 1, s, dp);
            int no_take = 0;
            if(i < s.length() - 1 && Integer.parseInt(s.substring(i, i + 2)) <= 26)
                no_take = f(i + 2, s, dp);
            return dp[i] = (take + no_take)%mod;
        }
}