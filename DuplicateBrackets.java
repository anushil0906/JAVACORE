//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.checkRedundancy(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int checkRedundancy(String s) {
        
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/')
            {
                st.push(s.charAt(i));
                
            }
            else if(s.charAt(i) == ')')
            {
                if(st.peek() == '(')
                {
                    return 1;
                }
                
                while(st.size()>0 && st.peek() != '(')
                {
                    st.pop();
                }
                st.pop();
            }
        }
        
        return 0;// code here
    }
}
        
