//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    int carpetBox(int A, int B, int C, int D) { 
        //code here
        return Math.min(findcount(A,B,C,D),findcount(A,B,D,C));

    }

    public int findcount(int A,int B,int C,int D){
        int count = 0;
        while(A>C){
            A /= 2;
            count++;
        }
        while(B>D){
            B /= 2;
            count++;
        }

        return count;
    }

}