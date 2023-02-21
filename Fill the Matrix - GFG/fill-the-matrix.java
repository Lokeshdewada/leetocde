//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	 static  class Pair{
        int x;
        int y;
        int t;
        Pair(int x,int y,int t){
            this.x=x;
            this.y=y;
            this.t=t;
        }
    }
	public static int minIteration(int N, int M, int x, int y){


		int [][] arr=new int[N][M];
		arr[x-1][y-1]=1;
		Queue<Pair> q=new LinkedList<>();
		q.offer(new Pair(x-1,y-1,0));

		int k=0,max=0;
		while(!q.isEmpty()){
		    Pair p=q.poll();
		    int u=p.x;
		    int v=p.y;
		    int t=p.t;
		    if(t>max){
		        max=t;
		    }
		    for(int i=-1;i<2;i++){
		        for(int j=-1;j<2;j++){
		            if(u+i>=0 && u+i<arr.length && (i+j)!=0 && (i-j)!=0 && v+j>=0 && (v+j)<arr[0].length && arr[u+i][v+j]==0  ){
		                arr[u+i][v+j]=1;

		                q.offer(new Pair(u+i,v+j,p.t+1));

		            }
		        }
		    }

		}
		return max;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends