//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            String W = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.numberOfSubsequences(S,W));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int numberOfSubsequences(String S, String W){
        // code here
        int count=0;
        boolean[] ans = new boolean[S.length()];
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)==W.charAt(0) && !ans[i]){
                ans[i] = true;
                int j=i+1;
                int k=1;
                while(j<S.length() && k<W.length()){
                    if(S.charAt(j)==W.charAt(k) && !ans[j]){
                        ans[j] = true;
                        k++;
                    }
                    j++;
                }
                if(k==W.length()){
                    count++;
                }else break;
            }
        }
        return count;


    }
}