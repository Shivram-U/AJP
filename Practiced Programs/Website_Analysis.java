import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class Website_Analysis 
{
    public static void Print_Web_Content(URL url1) throws IOException,UnknownHostException
    {
        System.out.println("\nWebsite Content:");
        InputStream in = url1.openStream();     // Input stream is created to receive the data from the Internet;
        in = new BufferedInputStream(in);       // Since the Inputstream reads data byte by byte, hence it will be slow, but if it is bufferred, then the data will be stored in buffer, in bulk when accessed from internet
        Reader r = new InputStreamReader(in);
        int n;
        while((n = r.read()) != -1)             // Reading the Characters of the Website Code file character by character.
        {
            System.out.print((char)n);
        }
        System.out.println("\nWebsite Content:");
        in = url1.openStream();
        InputStreamReader inr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(inr);        // Since the Inputstream reads data byte by byte, hence it will be slow, but if it is bufferred, then the data will be stored in buffer, in bulk when accessed from internet
        String line;
        while((line = br.readLine()) !=null)                // Reading the Characters of the Website Code file character by character.
        {
            System.out.print(line);
        }
    }
    public static void main(String[] args)
    {
        try
        {
            URL url1 = new URL("https://alumni.nec.edu.in/page/Vision-Mission.dz");
            URL url2 = new URL("http://info.cern.ch/");
            // URL url1 = new URL(args[0]);
            System.out.println("Host: "+url1.getHost());
            System.out.println("Authority: "+url1.getAuthority());
            System.out.println("Protocol: "+url1.getProtocol());
            System.out.println("Relative path: "+url1.getPath());
            System.out.println("Query: "+url1.getQuery());
            System.out.println("Default Port: "+url1.getDefaultPort());
            System.out.println("Website File: "+url1.getFile());
            Print_Web_Content(url1);
            System.out.println("\nWebsite Connection and Communication:");
                URLConnection urlcon = url1.openConnection();
                System.out.println("URL Connection: "+urlcon);
                System.out.println("URL Connection Timeout: "+urlcon.getConnectTimeout());
                System.out.println("URL Connection Content Encoding: "+urlcon.getContentEncoding());
                System.out.println("URL Connection Date: "+urlcon.getDate());

            // URL encoding:
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }    
}
