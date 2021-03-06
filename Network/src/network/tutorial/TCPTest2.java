package network.tutorial;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest2 {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            InetAddress inetAddress =  InetAddress.getByName("localhost");
            // 创建 socket 对象
            socket = new Socket(inetAddress, 8090);

            // 获取一个输出流， 用于输出数据
            fis = new FileInputStream("nature.jpg");

            os = socket.getOutputStream();

            // 输出流写出数据
            byte[] buffer = new byte[1024];
            int len;
            while( (len = fis.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(os != null){
                try {
                    os.close();
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
    public void server() {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            // create serverSocket， referring the  port
            serverSocket = new ServerSocket(8090);

            // serverSocket.accept(), receive the socket from client
            socket = serverSocket.accept();


            fos = new FileOutputStream(new File("nature2.jpg"));

            // read the data from inputStream and write it into the buffer, store in local
            is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            while( (len = is.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
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
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
