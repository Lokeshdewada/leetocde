//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    }
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 
    
class GFG {
    public static void main(String args[]) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
    
            Solution ob = new Solution();
            int ans = ob.solve(a, b, c);
            
            out.println(ans);
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int solve(int a, int b, int c) {
        int ans=a+b+c;
        if(a==b && b==c) return ans;
        if(a>b && a>c) return a%2==0 ? (b+c >= (a/2)-1 ? ans : -1 ) : (b+c >= a/2 ? ans : -1);
        if(b>c && b>a) return b%2==0 ? (a+c >= (b/2)-1 ? ans : -1 ) : (a+c >= b/2 ? ans : -1);
        if(c>a && c>b) return c%2==0 ? (b+a >= (c/2)-1 ? ans : -1 ) : (b+a >= c/2 ? ans : -1);
        return ans;
    }
};