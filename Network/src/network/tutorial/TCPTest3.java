package network.tutorial;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest3 {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            InetAddress inetAddress =  InetAddress.getByName("localhost");
            // create socket
            socket = new Socket(inetAddress, 8090);

            fis = new FileInputStream("nature.jpg");

            os = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int len;
            while( (len = fis.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }

            // shutdown the output stream when it's done
            socket.shutdownOutput();

            //feedback from server

             is = socket.getInputStream();
             baos = new ByteArrayOutputStream();

            byte[] buffer1 = new byte[200];
            int len1;
            while( (len1 = is.read(buffer1)) != -1){
                baos.write(buffer1, 0, len1);
            }

            System.out.println("message from server: " +baos.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(is!= null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(baos!= null)
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        OutputStream os = null;
        try {
            // create serverSocket， referring the  port
            serverSocket = new ServerSocket(8090);

            // serverSocket.accept(), receive the socket from client
            socket = serverSocket.accept();


            fos = new FileOutputStream(new File("nature3.jpg"));

            // read the data from inputStream and write it into the buffer, store in local
            is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            while( (len = is.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }

            System.out.println("picture got downloaded!");

            os = socket.getOutputStream();
            os.write("got the 图片, thank you!".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            // 关闭资源
            try {
                if(os != null)
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
