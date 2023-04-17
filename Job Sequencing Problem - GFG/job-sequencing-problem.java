//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{private class pair implements Comparable<pair>
{
    int p,d;
    pair(int pp,int dd)
    {
        p=pp;d=dd;
    }
    public int compareTo(pair o)
    {
        return o.p-this.p;
    }
}
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        pair a[]=new pair[n];int t=0;int time=0;
        for(Job i:arr)
        {
            a[t++]=new pair(i.profit,i.deadline);
            time=Math.max(time,i.deadline);
        }Arrays.sort(a);int slot[]=new int[time+1];int pro=0,cnt=0;
        for(pair i:a)
        {
            if(slot[i.d]==0&& i.d!=0)
            {
                slot[i.d]=1;pro+=i.p;cnt+=1;

            }else{
                int temp=i.d;
                while(temp>0)
                {
                    if(slot[temp]==0)
                    {pro+=i.p;cnt+=1;
                        slot[temp]=1;break;
                    }temp--;
                }

            }
        }
        return new int[]{cnt,pro};



    }
}
