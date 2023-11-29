import java.util.*;
public class AJPPRS{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String with double Quotes  ");
        String ip= sc.next();
        sc.close();
        if(ip.charAt(0)=='"')
            ip=ip.substring(1);
        if(ip.charAt(ip.length()-1)=='"')
            ip=ip.substring(0,ip.length()-1);
        List<String> lst = new ArrayList<>(Arrays.asList(ip.split(",")));
        List<Long> numbers= new ArrayList<>();
        for(String s: lst)
        {
            try{
               long v= Long.parseLong(s);
               numbers.add(v);
            }
            catch(Exception e){}
        }
        Collections.sort(numbers);
        try{
        System.out.println("largert number is "+numbers.get(numbers.size()-1));
        }catch(Exception e){
            System.out.println("There is no integer");
            return;
        }
        String longst="";
        int l=0;
        for(String i: lst)
        {
            boolean flag = true;
            for(int j=0;j<i.length();j++)
            {
                char ch = i.charAt(j);
                if(ch>='0' && ch<='9'){}
                else{
                    flag=false;
                    break;
                }
            }
            if(flag)
            {
                if(l<i.length())
                {
                    l=i.length();
                    longst=i;
                }
            }
        }
        System.out.println("longest number is "+longst);
    }
}