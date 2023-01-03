//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            out.println(ob.removeStudents(H,N));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int removeStudents(int[] H, int n) {
        // code here
        ArrayList<Integer> dp=new ArrayList<>();
        for(int i=0;i<n;i++){
            int idx=binarySearch(H[i],dp);
            if(idx==dp.size()){
                dp.add(H[i]);
            }else{
                dp.set(idx,H[i]);
            }
        }
        return n-dp.size();
    }
    int binarySearch(int ele,ArrayList<Integer> arr){
        int l=0;
        int h=arr.size()-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(arr.get(mid)>=ele){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
};