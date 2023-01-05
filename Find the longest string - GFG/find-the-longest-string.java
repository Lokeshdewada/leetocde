//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
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
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    public static String longestString(int N, String[] H) {
        Set<String> set = new HashSet<String>();
        for (String s : H)
            set.add(s);
        String ans = "";
        for(String s : H) 
        {
            for (int i = 0; i < s.length(); i++)
            {
                if (!set.contains(s.substring(0, i + 1))) 
                break;
                if (i == s.length() - 1) 
                    ans = check(s, ans);
            }
        }
        return ans;
    }

    private static String check(String s1, String s2) {
        if (s1.length() > s2.length())  return s1;
        else if (s2.length() > s1.length()) return s2;
        if (s1.compareTo(s2) < 0)   return s1;
        else return s2;
    }
}        