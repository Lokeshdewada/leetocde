//{ Driver Code Starts
//Initial Template for Java

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
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here

        String x = "";
		x += S.charAt(0);
		int l = 0;
		int n = S.length();

	    for(int i=0;i<S.length();i++) {
			int i1 = i;
			int i2 = i+1;
			while(i1>=0 && i2<n) {
				if(S.charAt(i1) == (S.charAt(i2))) {
					int length = i2-i1+1;
					if(length>l) {
						l = length;
						x = S.substring(i1,i1+length);
					}

				}else{
				    break;
				}
				i1--;
				i2++;
			}
		}

	    for(int i=0;i<S.length();i++) {
			int i1 = i-1;
			int i2 = i+1;
			while(i1>=0 && i2<n) {
				if(S.charAt(i1) == (S.charAt(i2))) {
					int length = i2-i1+1;
					if(length>l) {
						l = length;
						x = S.substring(i1,i1+length);
					}

				}else{
				    break;
				}
				i1--;
				i2++;
			}
		}
		return x;

    }
}