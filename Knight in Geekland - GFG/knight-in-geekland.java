//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            s = br.readLine().trim().split(" ");

            int start_x = Integer.parseInt(s[0]);
            int start_y = Integer.parseInt(s[1]);
            int arr[][] = new int[n][m];
            for(int i = 0; i < n; i++){
                s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    arr[i][j] = Integer.parseInt(s[j]);
            }

            Solution soln = new Solution();
            ot.println(soln.knightInGeekland(arr, start_x, start_y));
            
        }

        ot.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int knightInGeekland(int arr[][], int start_x, int start_y){
        int n = arr.length;
        int m = arr[0].length;
        boolean visited[][] = new boolean[n][m];
        visited[start_x][start_y] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start_x, start_y});
        List<Integer> list = new ArrayList<>();
        int points = 0;
        while(!q.isEmpty()){
            int size = q.size();
            points = 0;

            for(int i = 0; i < size; i++){
                int temp[] = q.poll();
                int x = temp[0], y = temp[1];
                points += arr[x][y];
                for(int k = 0; k < 8; k++){
                    int xi = x + dx[k];
                    int xj = y + dy[k];
                    if(isSafe(xi, xj, n, m) && !visited[xi][xj]){
                        visited[xi][xj] = true;
                        q.add(new int[]{xi, xj});
                    }
                }
            }
            list.add(points);
        }
        int max = -1, ans = -1;

        for(int i = list.size() - 1; i > -1; i--){
            if(list.get(i) + i < list.size())
                list.set(i, list.get(i) + list.get(i + list.get(i)));
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) > max){
                max = list.get(i);
                ans = i;
            }
        }
        return ans;
    }
    static boolean isSafe(int i, int j, int n, int m){
        return i > -1 && i < n && j > -1 && j < m;
    }
    static int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
}