//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
        int sum = 0;
        for(int i = 0; i < N; i++)
        {
            sum += arr[i];
        }
        int start = 0, end = sum;
        int res = 0;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(helper(arr, N, K, mid))
            {
                res = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return res;
    }

    static boolean helper(int[] arr, int n, int k, int mid)
    {
        int count = 1;
        int temp = 0;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] + temp <= mid)
                temp += arr[i];
            else
            {
                count++;
                if(count > k || arr[i] > mid)
                    return false;
                temp = arr[i];
            }
        }
        return true;
    }
}