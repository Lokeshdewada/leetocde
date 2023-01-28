//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[]=in.readLine().trim().split(" ");
            String a = s[0];
            String b = s[1];
            Solution g = new Solution();
            if(g.isScramble(a,b)){
                out.println("Yes");
            }
            else{
                out.println("No");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {

    HashMap<String , Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) 
    {        
        if(s1.length() != s2.length())
            return false;

       return solve(s1,s2);
    }

    private boolean solve( String a , String b)
    {
        if(a.equals(b))
            return true;

        if(a.length() <= 1)
            return false;

        String key = a + "_" + b;

        if(map.containsKey(key))
            return map.get(key);

        boolean flag = false;
        int n = a.length();

        for(int i=1; i<n; i++)
        {
           boolean on_swapping = solve(a.substring(0,i), b.substring(n-i)) &&
                           solve(a.substring(i), b.substring(0,n-i));       
           boolean not_swapping = solve(a.substring(0,i), b.substring(0,i)) &&
                             solve(a.substring(i), b.substring(i));

            if(on_swapping || not_swapping)
            {
                flag = true;
                break;
            }
        }
        map.put(key, flag);

        return flag;   
    }
}