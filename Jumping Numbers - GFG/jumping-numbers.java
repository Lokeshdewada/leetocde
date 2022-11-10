//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.jumpingNums(X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
     static long jumpingNums(long x) {
        Queue<Long> queue = new LinkedList<>();
        for(long i = 1; i<=9; i++) {
            queue.add(i);
        }
        long res = 0;
        while(!queue.isEmpty()) {
            long num = queue.remove();
            if(num > x) {
                continue;
            }
            res = Math.max(res, num);
            long lastDigit = num % 10;
            if(lastDigit != 0) {
                long f = num * 10 + (lastDigit-1);
                queue.add(f);
            }
            if(lastDigit != 9) {
                long s = num * 10 + (lastDigit+1);
                queue.add(s);
            }
        }
        return res;
    }
};
