//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        if(s.length() < 7) return 0;
        int arr[] = new int[26];
        for(char ch : s.toCharArray())
        arr[ch-'a']++;
        int singleOccuring = Math.min(arr['b'-'a'], Math.min(arr[0], arr['n'-'a']));
        int doubleOccuring = Math.min(arr['l'-'a'], arr['o'-'a']);
        doubleOccuring /= 2;
        return Math.min(doubleOccuring , singleOccuring);
    }
}