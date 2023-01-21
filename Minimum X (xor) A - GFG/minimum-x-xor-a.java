//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int minVal(int a, int b) {
        int bitA=Integer.bitCount(a);
        int bitB=Integer.bitCount(b);

        if(bitA==bitB){
            return a;
        }else if(bitA<bitB){
            while(bitA<bitB){
                //set least unset bit
                a|=a+1;
                bitA++;
            }
        }else{
            while(bitA>bitB){
                //unset least set bit
                a&=a-1;
                bitA--;
            }
        }

        return a;
    }
}