//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution 
{
public:
    vector<int> findMaxRow(vector<vector<int>> mat, int N) 
    {
        int mx=0;
        int r=0;
        int n=N;
        for(int i=0;i<n;i++)
        {
            int cnt=0;
            int ind=upper_bound(mat[i].begin(),mat[i].end(),0)-mat[i].begin();
            if(ind==n)
            {
                cnt=0;
            }
            else
            {
                cnt=n-ind;
            }
            if(cnt>mx)
            {
                mx=cnt;
                r=i;
            }
        }
        return {r,mx};
    }
};

//{ Driver Code Starts.

int main() {
	int t;
    cin>>t;
    while(t--) {
        int n;
        cin>>n;
        vector<vector<int>> arr(n, vector<int> (n));
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                cin >> arr[i][j];
        Solution obj;
        vector<int> ans = obj.findMaxRow(arr, n);
        for(int val : ans) {
            cout << val << " ";
        }
        cout << endl;
    }
}
// } Driver Code Ends