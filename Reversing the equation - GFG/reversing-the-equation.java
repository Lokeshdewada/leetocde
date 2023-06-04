//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{

    String reverseEqn(String s){
        // your code here
        if(s.length() == 0) return "";
        Stack<String> stk = new Stack<>();
        int j = 0;
        for(int i = 0;i < s.length(); ++i){
            if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'){
               stk.push(s.substring(j, i));
               stk.push(s.charAt(i) + "");
               j = i + 1;
            }
            if(i == s.length() - 1){
                stk.push(s.substring(j, i + 1));
            }

        } 

        StringBuilder sb = new StringBuilder();
        while(stk.size() > 0){
            sb.append(stk.pop());
        }

        return sb.toString();
    }
}