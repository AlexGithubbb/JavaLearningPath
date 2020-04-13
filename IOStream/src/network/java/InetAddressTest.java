package network.java;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        // get instance
        InetAddress ina = InetAddress.getByName("www.google.com");
//        System.out.println(ina);

        InetAddress localhost = InetAddress.getLocalHost();
//        System.out.println(localhost);

        /* two main methods:
         getHostName()
         getHostAddress()
         */
        System.out.println(localhost.getHostName());
        System.out.println(localhost.getHostAddress());
    }
}
