//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int a;
            a = Integer.parseInt(br.readLine());
            
            
            int b;
            b = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.solve(a, b);
            
            out.println(res);
            
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
      public static int solve(int a, int b) {
        if(a==b) return 0;
        int n1=0;
        int n2=0;
        int n=1;
        while(a>0||b>0)
        {
            if((a&1)==1 && (b&1)==0)
            {
                n1++;
            }
            if((a&1)==0 &&( b&1)==1)
            {
                n2++;
            }
            a=a>>1;b=b>>1;  
        }
        if(n1==0 || n2==0)
        {
            return 1;
        }
        return 2;
    }
}      
