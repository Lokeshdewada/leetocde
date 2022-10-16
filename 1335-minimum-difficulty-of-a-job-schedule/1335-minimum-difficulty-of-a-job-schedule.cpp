class Solution {
public:
    int minDifficulty(vector<int>& jobDifficulty, int d) {
        if(d > jobDifficulty.size()) return -1;
        vector<vector<int>>dp(d+1, vector<int>(jobDifficulty.size(), -1));
        return solve(jobDifficulty, dp, d, 0);
    }
    int solve(vector<int>& jobDifficulty, vector<vector<int>> &dp, int d, int ind){
        if(d == 1){
            int mx = 0;
            while(ind < jobDifficulty.size()){
                mx = max(mx, jobDifficulty[ind++]);
            }
            return mx;
        }
        if(dp[d][ind] != -1) return dp[d][ind];
        int ans = INT_MAX, mx = 0;
        for(int i=ind; i<jobDifficulty.size()-d+1; i++){
            mx = max(mx, jobDifficulty[i]);
            ans = min(ans, mx+solve(jobDifficulty, dp, d-1, i+1));
        }
        return dp[d][ind] = ans;
    }
};