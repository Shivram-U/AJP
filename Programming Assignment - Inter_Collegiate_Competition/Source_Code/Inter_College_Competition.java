import java.util.*;
import java.io.*;

public class Inter_College_Competition 
{
    String[] coms={"Register","Lookup","Info","Dates"};
    String[] Attributes={"Organisation","Name","Age","Qualification","Email","Phone","Address","Contests"};
    String[] Contests = {"Coding Contest","Paper Presentation","Technical Quiz","Data Analytics Workshop","Cultural Events(All)"};
    String[] Contests_Timing = {"05-08-2023 9.00 A.M","05-08-2023 12.00 A.M","05-08-2023 3.00 P.M","06-08-2023 9.00 A.M","06-08-2023 12.00 A.M"};
    Scanner sc = new Scanner(System.in);
    HashMap<String,HashMap<String,ArrayList<String>>> Registration_Records;
    HashMap<String,ArrayList<String>> thmp;
    boolean ch1=true;
    String ts;
    public Inter_College_Competition()
    {
        System.out.println("\n"+"-".repeat(57)+"/".repeat(7)+"\\".repeat(7)+"-".repeat(57));
        System.out.println(" ".repeat(50)+"Welcome to Amazon Hackathon"+" ".repeat(50));
        System.out.println("_".repeat(50)+"\\".repeat(14)+"/".repeat(14)+"_".repeat(50));
        this.Info();
        System.out.println("\n"+"_".repeat(30)+"Hackathon Registration Interface:"+"_".repeat(30)+"\n");
        // Values Initialisation:
        this.Registration_Records = new HashMap<String,HashMap<String,ArrayList<String>>>();
        System.out.println("\nCommands:");
        for(int i=0;i<coms.length;i++)
        {
            System.out.println("\t=> "+coms[i]);
        }
        this.Command();
    }    
    public void Command()
    {
        String com="";
        while(true)
        {
            System.out.print("\nRegistration_Interface >  ");
            try
            {
                com = sc.nextLine();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            //System.out.println(com);
            if(com.toLowerCase().equals("register"))
            {
                if(this.Register())
                {
                    System.out.println("_".repeat(70)+"\n");
                    System.out.println("\t\t"+"Registration Successfull");
                    System.out.println("_".repeat(70));
                }
                else
                {
                    System.out.println("Sorry, the Registration failed, please check your Credentials or use `Lookup` Command to see Registration Status and try again.");
                }
            }
            else if(com.toLowerCase().equals("lookup"))
            {
                this.Lookup();
            }
            else if(com.toLowerCase().equals("info"))
            {
                this.Info();
            }
            else if(com.toLowerCase().equals("dates"))
            {
                this.Dates();
            }
            else if(com.toLowerCase().equals("exit"))
            {
                System.out.println("\n"+"_".repeat(25)+"Thank you"+"_".repeat(25));
                System.exit(0);
            }
        }
    }
    public void Info()
    {
        try
        {
            FileReader fr = new FileReader("Amazon_Hackathon_Info.txt");
            BufferedReader bsr = new BufferedReader(fr);
            while((ts = bsr.readLine() )!=null)
            {
                ts = ts.replace("\\n","\n").replace("\\t","\t");
                System.out.println(ts);
            }
            System.out.println("\nContests:");
            for(int i=0;i<Contests.length;i++)
            {
                System.out.println((i+1)+"."+Contests[i]);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("");
    }
    public void Dates()
    {
        System.out.println("\nContests and Timing:\n");
        System.out.println("\t     Contests "+" ".repeat(22)+" Timing\n");
        for(int i=0;i<Contests.length;i++)
        {
            System.out.println("\t "+(i+1)+"."+Contests[i]+" ".repeat(30-Contests[i].length())+Contests_Timing[i]);
        }
    }
    public void Lookup()
    {
        String nm,em;
        System.out.print("Enter Name: ");
        nm = sc.nextLine();
        System.out.print("Enter Email: ");
        em = sc.nextLine();
        //System.out.println(nm);
        //System.out.println(em);
        ch1=true;
        for( String s : this.Registration_Records.keySet())
        {
            //System.out.println(this.Registration_Records.get(s).get(Attributes[1]));
            if(this.Registration_Records.get(s).get(Attributes[1]).contains(nm))
            {
                //System.out.println(this.Registration_Records.get(s).get(Attributes[4]));
                if(this.Registration_Records.get(s).get(Attributes[4]).contains(em))
                {
                    System.out.println("Name and Email provided are already registered");
                    System.out.print("Do you want to see the Registration Data[Y/N]:  ");
                    ts = sc.nextLine();
                    if(ts.equals("Y"))
                    {
                        thmp = this.Registration_Records.get(s);
                        System.out.println("\nRegistration Data:\n");
                        int ind = thmp.get(Attributes[4]).indexOf(em);
                        for(int i=1;i<Attributes.length-1;i++)
                        {
                            System.out.println("\t"+Attributes[i]+" ".repeat(25-this.Attributes[i].length())+":  "+thmp.get(Attributes[i]).get(ind));
                        }
                        System.out.println("\n\tContests Registered:");
                        ts = thmp.get(Attributes[Attributes.length-1]).get(ind);
                        for(int i=0;i<ts.length();i++)
                        {
                            System.out.println("\t\t"+(i+1)+"."+this.Contests[ts.charAt(i)-49]);
                        }
                        System.out.print("\n");
                    }
                    ch1=false;
                }
            }
        }
        if(ch1)
        {
            System.out.println("No Records of Registration are found");
            System.out.print("Do you want to register[Y/N]:  ");
            ts = sc.nextLine();
            if(ts.equals("Y"))
                this.Register();
        }
    }
    public boolean Register()
    {
        String t="",t1;
        System.out.println("_".repeat(30)+"Registration Form:"+"_".repeat(30)+"\n");
        System.out.print("Enter "+Attributes[0]+"\t:  ");
        t1=sc.nextLine();
        if(!this.Registration_Records.keySet().contains(t1))
        {
            HashMap<String,ArrayList<String>> temp = new HashMap<String,ArrayList<String>>();
            for(int i=1;i<Attributes.length;i++)
            {
                temp.put(this.Attributes[i],new ArrayList<String>());
            }
            this.Registration_Records.put(t1,temp);
        }
        //System.out.println(this.Registration_Records);
        String[] ar = new String[this.Attributes.length];
        for(int i=1;i<this.Attributes.length-1;i++)
        {
            System.out.print("Enter "+this.Attributes[i]+" ".repeat(25-this.Attributes[i].length())+":  ");
            ar[i-1] = sc.nextLine();
        }
        System.out.println("Choose Contests :");
        this.Dates();
        for(int o=0;o<3;o++)
        {
            System.out.print("\nSelect Contests in Number Pattern:");
            t = sc.nextLine();
            ch1=false;
            for(int i=0;i<t.length();i++)
            {
                if(!(t.charAt(i)>=49 && t.charAt(i)<=53))
                {
                    System.out.println("Invalid Number Pattern, please choose again");
                    ch1=true;
                    break;
                }
            }
            if(ch1)
            {
                continue;
            }
            break;
        }
        if(ch1)
        {
            return false;
        }
        ar[this.Attributes.length-2] = t;
        HashMap<String,ArrayList<String>> st = Registration_Records.get(t); 
        for( String s : this.Registration_Records.keySet())
        {
            // System.out.println(s);
            if(this.Registration_Records.get(s).get(Attributes[4]).contains(ar[3]))
            {
                System.out.println("Name and Email provided are already registered");
                return false;
            }
            else if(this.Registration_Records.get(s).get(Attributes[5]).contains(ar[4]))
            {
                System.out.println("Name and phone number provided are already registered");
                return false;
            }
        }
        System.out.println("\nRegistration accepted");
        for(int i=1;i<Attributes.length;i++)
        {
            //System.out.println(ar[i-1]);
            this.Registration_Records.get(t1).get(this.Attributes[i]).add(ar[i-1]);
            //System.out.println(this.Registration_Records.get(t1).get(this.Attributes[i]));
        }
        //System.out.println(Registration_Records);
        return true;
    }
    public static void main(String[] args)
    {
        // Check if the program has access to a console
        if (System.console() == null) {
            // No console available, so we create a new console to display the output
            try {
                ProcessBuilder builder;
                if (System.getProperty("os.name").toLowerCase().contains("win")) {
                    // For Windows systems
                    builder = new ProcessBuilder("cmd", "/c", "java", "-jar", "YourProgram.jar");
                } else {
                    // For non-Windows systems
                    builder = new ProcessBuilder("java", "-jar", "YourProgram.jar");
                }
                builder.redirectErrorStream(true);
                Process process = builder.start();
                InputStream inputStream = process.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
                process.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Console is available, so print output directly to it
            Inter_College_Competition icc = new Inter_College_Competition();
            // Rest of your program logic
        }
    }
}
