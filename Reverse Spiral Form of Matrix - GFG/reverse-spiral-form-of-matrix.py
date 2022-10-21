#User function Template for python3
class Solution:
	def reverseSpiral(self, R, C, a):
		# code here
		ans = [0 for i in range(R*C)]
		i,j,k = 0,0,0
		z=0
		size = R*C

		while(j<R and k<C):
		    val = 0
		    for i in range(k,C):
		        val = a[j][i]
		        ans[z] = val
		        z += 1
		    j += 1
		    for i in range(j,R):
		        val = a[i][C-1]
		        ans[z] = val
		        z += 1
		    C -= 1
		    if (j < R):
                for i in range(C - 1, k - 1, -1):
                    val = a[R - 1][i]
                    ans[z] = val
                    z += 1

            R -= 1
            if (k < C):
                for i in range(R - 1, j - 1, -1):
                    val = a[i][k]
                    ans[z] = val
                    z += 1
                k += 1
        final=[]
        for i in range(size - 1, -1, -1):
            final.append(ans[i])
        return(final)


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t=int(input())
    for _ in range(t):
        R,C=[int(x) for x in input().split()]
        a=[[0]*C for c in range(R)]
        arr=input().split()
        for i in range(R*C):
            a[i//C][i%C]=int(arr[i])
            
        ob=Solution()
        ans=ob.reverseSpiral(R,C,a)
        for i in range(len(ans)):
            print(ans[i],end=" ")
            
        print()
# } Driver Code Ends