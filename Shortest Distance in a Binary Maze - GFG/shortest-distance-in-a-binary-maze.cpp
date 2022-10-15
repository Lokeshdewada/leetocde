//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int shortestPath(vector<vector<int>> &grid, pair<int, int> source,
                     pair<int, int> destination) {
        // code here
        int n=grid.size();
        int m=grid[0].size();
        int srcRow=source.first;
        int srcCol=source.second;
        int destRow=destination.first;
        int destCol=destination.second;
        vector<vector<int>>dist(n,vector<int>(m,1e9));
        dist[srcRow][srcCol]=0;
        queue<pair<int,pair<int,int>>>q;
        q.push({0,{srcRow,srcCol}});
        int dRow[]={-1,0,1,0};
        int dCol[]={0,1,0,-1};
        while(!q.empty()){
            int dis=q.front().first;
            int row=q.front().second.first;
            int col=q.front().second.second;
            q.pop();
            for(int i=0;i<4;i++){
                int row2=row+dRow[i];
                int col2=col+dCol[i];
                if(row2>=0 && row2<n && col2>=0 && col2<m && grid[row2][col2]==1){
                    if(dis+1<dist[row2][col2]){
                        dist[row2][col2]=dis+1;
                        q.push({dist[row2][col2],{row2,col2}});
                    }
                }
            }
        }
        if(dist[destRow][destCol]==1e9){
            return -1;
        }
        return dist[destRow][destCol];
    }
};

//{ Driver Code Starts.
int main() {

    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> grid(n, vector<int>(m));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> grid[i][j];
            }
        }

        pair<int, int> source, destination;
        cin >> source.first >> source.second;
        cin >> destination.first >> destination.second;
        Solution obj;
        cout << obj.shortestPath(grid, source, destination) << endl;
    }
}

// } Driver Code Ends