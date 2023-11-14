//Complete this code or write your own from scratch
import java.util.*;

class Solution{
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        Map peoMap = new HashMap<>();
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            in.nextLine();
            peoMap.put(name, phone);
        }
        List <String> S = new ArrayList<>();
        while(in.hasNext())
        {
            String s=in.nextLine();
            if (peoMap.containsKey(s)) S.add(s+"=" + peoMap.get(s));
            else S.add("Not found");

        }
        for (String x : S) {
            System.out.println(x);
        }
    }
}



