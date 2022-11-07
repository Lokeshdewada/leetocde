//{ Driver Code Starts
//Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++
using namespace std;
int main()
 {
	//code
	int T;
	cin>>T;
	while(T--)
	{
	    int n;
    	cin>>n;
    	int a[n];

    	int XOR;
    	for(int i=0;i<n;i++)
            cin>>a[i];   

        XOR=a[0];

        for(int i=1;i<n;i++)   
    	    XOR=XOR^a[i];


    	int set_bit;
    	set_bit = XOR & ~(XOR-1);  
    	int x=0 , y=0;

    	for(int i=0 ;i<n;i++)
    	{
    	    if(a[i] & set_bit )
    	     x = x^a[i];

	        else
    	     y = y^a[i];
    	}
        if(x>y)
    	cout<<x<<" "<<y<<endl;
	    else
	    cout<<y<<" "<<x<<endl;
	}
	return 0;
}