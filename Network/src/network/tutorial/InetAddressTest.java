package network.tutorial;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
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
    public void client() throws IOException {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            InetAddress inetAddress =  InetAddress.getByName("localhost");
            // 创建 socket 对象
            socket = new Socket(inetAddress, 8090);

            // 获取一个输出流， 用于输出数据
            outputStream = socket.getOutputStream();

            // 输出流写出数据
            outputStream.write("你好， 我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void server() throws IOException {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            // 创建一个 serverSocket， 指明 port
            serverSocket = new ServerSocket(8090);

            // 调用 accept(), 接收来自 client 的 socket
             socket = serverSocket.accept();

            // 读取输入流中的数据
            baos = new ByteArrayOutputStream();
            is = socket.getInputStream();
            byte[] buffer = new byte[5];
            int len;
            while( (len = is.read(buffer)) != -1){
                baos.write(buffer, 0, len);
            }

            System.out.println(baos.toString());

            System.out.println("get socket from :" + socket.getInetAddress().getHostAddress() + " " + socket.getInetAddress().getHostName());

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            // 关闭资源
            try {
                if(serverSocket != null)
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(socket != null)
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is!=null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(baos != null)
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test() throws UnknownHostException {
        InetAddress inet1 = InetAddress.getByName("www.google.com");
        System.out.println(inet1);

        InetAddress inet2 = InetAddress.getLocalHost();
        System.out.println(inet2);

        InetAddress inet3 = InetAddress.getByName("localhost");
        System.out.println(inet3);


//        String hostName = inet3.getHostName();
//        String hostAddress = inet3.getHostAddress();
//
//        System.out.println(hostName);
//        System.out.println(hostAddress);


    }


}
