//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings

    public static String caseSort(String str)
    {
        // Your code here

        char[] tempString = str.toCharArray();

        int lowerCount = 0;
        int upperCount = 0;

        //counting number of lowercase and uppercase characters
        for (char ch: tempString) 
        {
            if (Character.isUpperCase(ch))
                upperCount++;
            else
                lowerCount++;
        }

        //create two arrays to storing character differently- lowerCase, upperCase

        char[] lowerChArr = new char[lowerCount];
        char[] upperChArr = new char[upperCount];

        lowerCount = 0;
        upperCount = 0;

        //storing uppercase and lowercase characters in two separate arrays 
        for (char ch: tempString) 
        {
            if (Character.isUpperCase(ch))
                upperChArr[upperCount++] = ch;
            else
                lowerChArr[lowerCount++] = ch;
        };

        //sorting both the arrays

        Arrays.sort(upperChArr);
        Arrays.sort(lowerChArr);

        lowerCount = 0;
        upperCount = 0;

        //iterating over the given string

        for (int i = 0; i < tempString.length; i++){

            //if current character is in uppercase then we pick character from the list containing uppercase characters and add it to result

            if (Character.isUpperCase(tempString[i])){

                tempString[i] = upperChArr[upperCount++];
            }

            //else we pick the character from the sorted list containing lowercase characters and add it to result

            else{

                tempString[i] = lowerChArr[lowerCount++];
            }
        }

        String ansString = new String(tempString);

        return ansString;

    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends