//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            long n=Long.parseLong(in.readLine());
            Solution ob=new Solution();
            out.println(ob.findNumber(n));
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long findNumber(long N)
    {
        long result = 0;
        List<Integer> list = new ArrayList<>();
        while (N > 0) {
            N--;
            list.add((int)(N % 5));
            N /= 5;
        }
        for (int i = list.size()-1; i >= 0; i--) {
            result = result * 10 + 2 * list.get(i) + 1;
        }
        return result;
    }
}