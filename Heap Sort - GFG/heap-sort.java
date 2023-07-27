//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}



// } Driver Code Ends


class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        // Your code here
        for (int i=(n-1)/2;i>=0;i--) heapify(arr,n,i);
    }

    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        // Your code here
        int left=(2*i+1);
        int right=(2*i+2);
        int max=i;

        if(left<n && arr[left]>arr[max])max=left;
        if(right<n && arr[right]>arr[max])max=right;
        if(max!=i){
            swap(arr, max,i);
            heapify(arr,n,max);
        }
    }

    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
        buildHeap(arr,n);
        for(int i=n-1;i>=0;i--)
        {
            swap(arr,0,i);
            heapify(arr,i,0);
        }

    }

    void swap(int A[],int i, int j)
    {
        int x=A[i];
        A[i]=A[j];
        A[j]=x;
    }
 }
