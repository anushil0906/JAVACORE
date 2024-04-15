class Solution {
    public int calculate(String str) {
         str = str.replaceAll("\\s","");

         //System.out.println(str);
         ArrayList<String> al = new ArrayList<String>();

         String out ="";

         for(int i=0;i<str.length();i++)
         {
            if(str.charAt(i) != '+' && str.charAt(i) != '-' && str.charAt(i) != '*' && str.charAt(i) != '/')
            {
                out+=str.charAt(i);
            }
            else
            {
                al.add(out);
                out ="";
                al.add(""+str.charAt(i));
            }
          //  System.out.println(i);
         }
         al.add(out);
         

         Stack<String> ord = new Stack<String>();
         Stack<String> opr = new Stack<String>();

         //System.out.println(al);

         for(int i=0;i<al.size();i++)
         {
            if(!al.get(i).equals("+") && !al.get(i).equals("-") && !al.get(i).equals("*") && !al.get(i).equals("/"))
            {
                ord.push(al.get(i));
            }
            else
            {
                while(opr.size() > 0 && precedence(al.get(i)) <= precedence(opr.peek()))
                {
                    String a = ord.pop();
                    String b = ord.pop();
                    int x = operation(b,a,opr.pop());
                    ord.push(""+x);
                }
                opr.push(al.get(i));
            }

            
//System.out.println(ord);
//System.out.println(opr);

         }

          while(opr.size() > 0 )
                {
                    String a = ord.pop();
                    String b = ord.pop();
                    int x = operation(b,a,opr.pop());
                    ord.push(""+x);
                }
                //opr.push(al.get(i));
  //              System.out.println(ord);
//System.out.println(opr);


              
         return Integer.parseInt(ord.peek());
        
    }

    public static int precedence(String a)
    {
        if(a.equals("+") || a.equals("-"))
        {
            return 1;
        }
        else if(a.equals("*") || a.equals("/"))
        {
            return 2;
        }
        return 0;
    }

    public static int operation(String a,String b,String c)
    {
        if(c.equals("+"))
        {
            int z = Integer.parseInt(a)+Integer.parseInt(b);
            return z;
        }
         else if(c.equals("-"))
        {
            return Integer.parseInt(a)-Integer.parseInt(b);
        }
         else if(c.equals("/"))
        {
            return Integer.parseInt(a)/Integer.parseInt(b);
        }
         else if(c.equals("*"))
        {
            return Integer.parseInt(a)*Integer.parseInt(b);
        }
        return 0;
    }
}
