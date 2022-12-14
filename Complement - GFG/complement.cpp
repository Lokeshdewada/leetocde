//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

// } Driver Code Ends

class Solution
{
public:
    vector<int> findRange(string str, int n) 
    {
        int ansl=-1;
        int ansr=-1;
        int left=0;int right=0;
        int zero=0;
        int one=0;
        int ans=0;
        for(int right=0;right<n;right++)
        {
            if(str[right]=='1')
            {
                one++;
                if(one>zero)
                {
                    one=0;
                    zero=0;
                    left=right+1;
                }
            }
            else
            {
                zero++;
                int curr=zero-one;
                if(curr>ans)
                {
                    ansl=left+1;
                    ansr=right+1;
                    ans=curr;
                }
            }
        }
        if(ansl==-1 && ansr==-1)
        {
            return {-1};
        }
        return {ansl,ansr};

    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        string s;
        cin >> s;
        Solution ob;
        auto ans = ob.findRange(s, n);

        if (ans.size() == 1) {
            cout << ans[0] << "\n";
        } else {
            cout << ans[0] << " " << ans[1] << "\n";
        }
    }
    return 0;
}
// } Driver Code Ends