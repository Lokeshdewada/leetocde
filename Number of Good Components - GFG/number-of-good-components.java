//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int v_count;
    int e_count;
    boolean vis[];
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        vis = new boolean[V+1];
        int count=0;
        for(int i=1;i<V+1;i++){
            if(!vis[i]){
                v_count=e_count=0;
                dfs(i,adj);
                if(e_count==(v_count*(v_count-1))) count++;
            }
        }
        return count;
    }

    void dfs(int v,ArrayList<ArrayList<Integer>> adj){

        vis[v]=true;

        v_count++;
        e_count+=adj.get(v).size();

        for(int neighbour: adj.get(v) ){
            if(!vis[neighbour]){
                dfs(neighbour,adj);
            }
        }  
    }
}