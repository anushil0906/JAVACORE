//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<Integer> st = new Stack<Integer>();
        int[] ans = new int[price.length];
        ans[0] = -1;
        st.push(0);
        
        for(int i=1;i<price.length;i++)
        {
            while(st.size() > 0 && price[i] >= price[st.peek()])
            {
                st.pop();
            }
            if(st.size() == 0)
            {
                ans[i] = -1;
            }
            else
            {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        
        for(int i=0;i<price.length;i++)
        {
            if(ans[i] == -1)
            {
                ans[i] = i+1;
            }
            else
            {
                ans[i] = i-ans[i];
            }
        }
        return ans;
    }
    
}
