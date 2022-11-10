//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumOfTwo(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {

    static String isSumOfTwo(int N){
        boolean [] isprime = new boolean[N+1];
        Arrays.fill(isprime, true);
        isprime[0] = false;
        isprime[1] = false;
        for(int i =2 ;i*i<=N;i++){
             for(int j = i*2 ; j<=N ; j+=i){
                 isprime[j] = false;
             }
        }
        // for(int i =0 ;i<N+1;i++){
        //     // System.out.println(isprime[i]);
        // }
        for(int i = 0;i<N+1;i++){
            if(isprime[i] == true){
                int idx = N - i;

                if(isprime[idx] == true){
                    // System.out.println(idx);
                    return "Yes";
                }
            }
        }
        return "No";
    }
}