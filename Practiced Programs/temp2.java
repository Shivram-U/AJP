import java.io.FileWriter;
import java.util.Scanner;

public class temp2
{
    public static void main(String[] args)
    {
        try
        {
            String fn = "A.txt";
            FileWriter fw = new FileWriter(fn);
            Scanner sc = new Scanner(System.in);
            String t="";
            while(!t.equals("QUIT"))
            {   
                t = sc.next();
                // System.out.println(t);
                if(!t.equals("QUIT"))
                {
                    fw.write(t);
                    fw.flush();
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}