//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        int left [] = new int[hist.length];
        int right[] = new int[hist.length];
        Stack<Integer> st = new Stack<Integer>();
        left[0] = -1;
        right[hist.length-1] = hist.length;
        st.push(hist.length-1);
        for(int i=hist.length-2;i>=0;i--)
        {
            while(st.size() > 0 && hist[i] <= hist[st.peek()])
            {
                st.pop();
            }
            if(st.size() == 0)
            {
                right[i] = hist.length;
            }
            else
            {
                right[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        st.push(0);
        for(int i=1;i<hist.length;i++)
        {
            while(st.size() > 0 && hist[i] <= hist[st.peek()])
            {
                st.pop();
            }
            if(st.size() == 0)
            {
                left[i] = -1;
            }
            else
            {
                left[i] = st.peek();
            }
            st.push(i);
        }
       // System.out.println(Arrays.toString(left));
        //System.out.println(Arrays.toString(right));
        long max = Long.MIN_VALUE;
        for(int i=0;i<hist.length;i++)
        {
            int r = right[i]-1;
            int l = left[i]+1;
            int x = r-l+1;
           // System.out.println(width);
           max = Math.max(max,hist[i]*x);
           // System.out.println(max);
        }
        
        return max;
    }
        
}



