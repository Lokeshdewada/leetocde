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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int characterReplacement(String s, int k)
    {
        // code here
        char ch[]=s.toCharArray();
        int n = s.length();
		int f[]=new int[26];
		int start = 0, maxCount = 0, maxLength = 0;
		for(int end = 0; end < n; end++){
			maxCount = Math.max(maxCount, ++f[ch[end] - 'A']);
			while(end - start + 1 - maxCount > k){
				f[ch[start]  - 'A']--;
				start++;
			}
			maxLength = Math.max(maxLength, end - start + 1);
		}
		return maxLength;
    }
}