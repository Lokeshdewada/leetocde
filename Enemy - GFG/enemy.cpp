//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution
{
    public:
        int largestArea(int n,int m,int k,vector<vector<int>> &enemy)
        {
            if(k==0) return n*m;
            vector<bool> r(n+1,false), c(m+1, false);


            for(int i=0;i<enemy.size();i++){
                int dr = enemy[i][0], dc = enemy[i][1];
                r[dr] = true, c[dc] = true;
            }
            int ans = 0, tmp = 0, dx = 0, dy = 0, mx = 0, my = 0;

            for(int i=1;i<=n;i++){
                if(r[i]==false) dx++;
                else dx = 0;
                mx = max(mx, dx);
            }

            for(int i=1;i<=m;i++){
                if(c[i]==false) dy++;
                else dy = 0;
                my = max(my, dy);
            }

            return mx*my;
        }
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n,m;
        cin>>n>>m;
        int k;
        cin>>k;
        vector<vector<int>> e(k,vector<int>(2));
        for(int i=0;i<k;i++)
            cin>>e[i][0]>>e[i][1];
        Solution a;
        cout<<a.largestArea(n,m,k,e)<<endl;
    }
    return 0;
}
// } Driver Code Ends