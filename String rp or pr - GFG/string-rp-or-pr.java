//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
            
            String input_line1[] = br.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line1[0]);
            int Y = Integer.parseInt(input_line1[1]);
            
            String S = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.solve(X,Y,S)); 

            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static long solve(int X,int Y, String S)
	{    	    // code here
	    if(X>=Y){
	        return help(S,X,Y,"pr");
	    }
	    else{
	        return help(S,Y,X,"rp");
	    }
	}
	static long help(String s, int first,int second,String rem){
	    char a=rem.charAt(0);
	    char b=rem.charAt(1);
	    long ans=0;

	    Stack<Character> st=new Stack<>();
	    for(int i=0;i<s.length();i++){
	        if (!st.isEmpty() && st.peek()==a && s.charAt(i)==b){
	            st.pop();
	            ans+=first;
	        }
	        else st.push(s.charAt(i));
	    }

	    Stack<Character> st2=new Stack<>();

	    while(!st.isEmpty()){
	        if(st.peek()==b && !st2.isEmpty() && st2.peek()==a){
	            st.pop();
	            st2.pop();
	            ans+=second;
	        }
	        else {
	            st2.push(st.pop());
	        }
	    }
	    return ans;
	}
} 