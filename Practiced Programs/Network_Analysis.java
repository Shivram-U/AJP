import java.net.InetAddress;
import java.net.URL;
import java.io.IOException;
import java.net.UnknownHostException;

public class Network_Analysis 
{
    public static void main(String[] ar)  throws UnknownHostException,IOException
    {
        // Local host System Analysis, as a part of the Network, the system is currently connected.
        System.out.println("Local System Network Info:");
        InetAddress local = InetAddress.getLocalHost();
        System.out.println("Local IP:"+InetAddress.getByName("localhost"));
        System.out.println("Local Host Object: "+local);
        System.out.println("Local Host Name: "+local.getHostName());
        System.out.println("Local Host IP Address : "+local.getLocalHost());
        System.out.println("Local Host IP Address : "+InetAddress.getLocalHost());
        System.out.println("Local Host Loop back IP Address : "+InetAddress.getLoopbackAddress());
        System.out.println("\nNetwork/Internet Servers Info Analysis:");
        // Inet Object creation, with a Domain Name as Argument, and access the IP address related to a Domain Name of a Server, accessed from the Internet Network.
        InetAddress Server_inf = InetAddress.getByName("www.google.com");         
        // The java.net.InetAddress class does not have a public Constructor, hence cannot be instantiated, from User Side.
        System.out.println(Server_inf);
        System.out.println("Web Server Reachability(100 ms) : "+Server_inf.isReachable(100));
        System.out.println("Web Server Reachability(250 ms) : "+Server_inf.isReachable(250));
        System.out.println("Web Server Reachability(500 ms) : "+Server_inf.isReachable(500));
        System.out.println("Web Server Reachability(1000 ms) : "+Server_inf.isReachable(1000));
        System.out.println("Web Server System Name: "+Server_inf.getHostName());
        System.out.println("Web Server System Address(String): "+Server_inf.getHostAddress());
        System.out.println("Web Server System Address(Raw Address in Byte Format): "+Server_inf.getAddress());
        byte[] Address_Byte_Format = Server_inf.getAddress();
        System.out.println("Byte Address Length:"+Address_Byte_Format.length);      
        System.out.println("`Server_inf` Address IP Version: "+"IPV"+((Address_Byte_Format.length == 4)?"4":"6"));      
        // The Above method returns the length of the IP Address, which when is a IPV4 address is 32 Bit long, will occupy 4 Bytes in the Array, otherwise if its a IPV6 Address, occupy 16 Bytes(128 bit) in the Array.    
        // To get the a all the IP address related to a Domain Name of a Server.
        InetAddress[] Server_ips = InetAddress.getAllByName("www.google.com");         
        System.out.println(Server_ips);
        for(int i=0;i<Server_ips.length;i++)
        {
            System.out.println("INET OBJECT: "+Server_ips[i]+"\tHOST NAME: "+Server_ips[i].getHostName()+"\tHOST IP ADDRESS: "+Server_ips[i].getHostAddress());
        }
        // Classes Addressing of the IPV4 Address.

        // 
    }    
}
