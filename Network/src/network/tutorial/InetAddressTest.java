package network.tutorial;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
1. IP address （对应一台主机/服务器）
2. 端口： port （一台主机上的单个软件/进程）
3. 域名： domain name
4. 本机：localhost
*
* */

public class InetAddressTest {

    @Test
    public void test() throws UnknownHostException {
        InetAddress inet1 = InetAddress.getByName("www.google.com");
//        System.out.println(inet1);

        InetAddress inet2 = InetAddress.getLocalHost();
//        System.out.println(inet2);

        InetAddress inet3 = InetAddress.getByName("localhost");
//        System.out.println(inet3);


//        String hostName = inet3.getHostName();
//        String hostAddress = inet3.getHostAddress();
//
//        System.out.println(hostName);
//        System.out.println(hostAddress);

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        System.out.println(localHost.getHostAddress()); // 192.168.0.171


        InetAddress ip = InetAddress.getByName("google.com");
        System.out.println(ip.getHostName() + "| " + ip.getHostAddress());  //google.com| 172.217.1.14


    }


}
