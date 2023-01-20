//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here

        Deque<Integer> q=new ArrayDeque<>();
        ArrayList<Integer> ans=new ArrayList<Integer>();
        int i=0,j=0;

        if(k==1){
            for(int z:arr){
                ans.add(z);
            }
            return ans;
        }

        q.offer(arr[i]);

        while(j<n-1){
            j++;
            if(j-i+1<k){
                if(q.size()!=0){
                    while(q.size()!=0 && arr[j]>q.peekLast()){
                        q.removeLast();
                    }
                    q.offer(arr[j]);
                }

                continue;
            }

            while(q.size()!=0 && arr[j]>q.peekLast()){
                q.removeLast();
            }
            if(q.size()!=0 && arr[j]<=q.peekLast()){
                q.offer(arr[j]);
            }
            if(q.size()==0){
                q.offer(arr[j]);
            }
            ans.add(q.peekFirst());

            if(arr[i]==q.peekFirst()){
                q.removeFirst();
            }
            i++;

        }
        return ans;
    }
}