import java.util.*;
public class keys {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s;
        List<String> l=new ArrayList<String>();
        while(true)
        {
            s=sc.next();
            if(s.equals("q")||s.equals("Q"))
            {
                break;
            }
            else
            {
                l.add(s);
            }
        }
            int bc=0;
            for(int i=0;i<l.size();i++)
            {
                if(l.get(i).equals("-"))
                {
                    bc++;
                }
            }
            Set<String> se=new HashSet<String>(l);
            List<String>nl=new ArrayList<String>(se);
            Collections.sort(nl);
            nl.remove(0);
            System.out.println("Blank keys: "+(bc));
            System.out.println("Total Keys: "+(l.size()));
            System.out.println("Number Of Rooms: "+(nl.size()));  
        }
}