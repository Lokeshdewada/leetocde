//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public void swap(char arr[],int i,int j)
    {
        char ch=arr[i];
        arr[i]=arr[j];
        arr[j]=ch;
    }
    public void solve(int ind,char[] arr,HashSet<String>st)
    {
        if(ind>=arr.length)
        {
            String s=String.valueOf(arr);
            st.add(s);
            return;
        }
        for(int i=ind;i<arr.length;i++)
        {
        swap(arr,i,ind);
            solve(ind+1,arr,st);
            swap(arr,i,ind);
        }
    }
    public List<String> find_permutation(String S) {
        // Code here
        int n=S.length();

       HashSet<String>st=new HashSet<>();
        List<String> l=new ArrayList<>();

         char[]arr=S.toCharArray();
        solve(0,arr,st);
        for(String s:st)
        l.add(s);

      Collections.sort(l);
        return l;
    }
}