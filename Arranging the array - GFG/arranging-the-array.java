//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.Rearrange(a, n);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
                output.append(a[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {


    static void merging(int arr[],int start,int mid,int end){
            int i=start;
            while(i<=mid && arr[i]<0)i++;
            int j = mid+1;
            while(j<=end && arr[j]<0)j++;
            int k=i,l=j-1;
            int temp = mid;
            while(i<temp){
                int t = arr[i];
                arr[i]=arr[temp];
                arr[temp]=t;
                i++;
                temp--;
            }
            temp=mid+1;
            j--;
            while(temp<j){
                int t = arr[temp];
                arr[temp]=arr[j];
                arr[j]=t;
                temp++;
                j--;
            }
            while(k<l){
                int t= arr[k];
                arr[k]=arr[l];
                arr[l]=t;
                k++;
                l--;
            }
    }
    static void mergesort(int arr[],int start,int end){
            if(start<end){
                int mid = (start+end)/2;
                mergesort(arr,start,mid);
                mergesort(arr,mid+1,end);
                merging(arr,start,mid,end);
            }
    }


    public void Rearrange(int a[], int n)
    {
                mergesort(a,0,n-1);
// Your code goes here
    }
}