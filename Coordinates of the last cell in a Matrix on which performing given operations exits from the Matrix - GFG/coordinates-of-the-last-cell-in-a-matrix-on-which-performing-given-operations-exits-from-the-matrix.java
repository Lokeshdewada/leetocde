//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
        out.close();
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution{
    static int [] endPoints(int [][]arr, int m, int n){
        //code here
        int i=0;int j=0; int curr_dir=1;int curr_i=0;int curr_j=0;

        int dx[]={-1,0,1,0};

        int dy[]={0,1,0,-1};

        while(i>=0 && j>=0 && i<m && j<n){

          curr_i=i;

          curr_j=j;

          if(arr[i][j]==0){

             i+=dx[curr_dir];

             j+=dy[curr_dir];

          }else{

               curr_dir=( curr_dir+1)%4;

               arr[i][j]=0;

                 i+=dx[curr_dir];

                 j+=dy[curr_dir];



          }

        }

        return new int[] {curr_i,curr_j} ;
    }
}