package network.tutorial;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/examples/hello.txt?uername=Tom");

        // get protocol
        System.out.println(url.getProtocol());
        // get host
        System.out.println(url.getHost());
        // get port
        System.out.println(url.getPort());
        // get file path
        System.out.println(url.getPath());
        // get file name
        System.out.println(url.getFile());
        // get query
        System.out.println(url.getQuery());
    }

    @Test
    public void OpenConnectionTest() throws IOException {
        HttpURLConnection connection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://localhost:8080/examples/hello.txt");

            connection = (HttpURLConnection)url.openConnection();

            // connect
            connection.connect();

             is = connection.getInputStream();
             fos = new FileOutputStream(new File("download.txt"));
            byte[] data = new byte[20];
            int len;
            while((len = is.read(data))!= -1){
                fos.write(data, 0, len);
            }

            System.out.println("file got downloaded!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if( connection != null){
                connection.disconnect();
            }
            try {
                if(is!=null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos!= null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

}
