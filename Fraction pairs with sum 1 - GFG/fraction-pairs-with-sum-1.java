//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countFractions(int n, int[] num, int[] deno) {
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < n; ++i){
            int gcd = GCD(num[i], deno[i]);
            num[i] /= gcd;
            deno[i] /= gcd;
            String key = String.valueOf(num[i]) + "|" + String.valueOf(deno[i]);
            String expectedKey = String.valueOf(deno[i] - num[i]) + "|" + String.valueOf(deno[i]);
            ans += map.getOrDefault(expectedKey, 0);
            map.merge(key, 1, Integer::sum);
        }
        return ans;
    }

    private static int GCD(int a, int b){
        return a % b == 0 ? b : GCD(b, a % b);
    }
}
