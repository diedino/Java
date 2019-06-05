package com.krasnov.withSlave;
/*
 *  К сожалению, 3 пункт задания выполнен не был
 * */
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    Socket s;
    int[] arr;
    int n;
    public static void main(String args[]) {
        try
        {
            ServerSocket server = new ServerSocket(3128, 0,
                    InetAddress.getByName("localhost"));

            System.out.println("server is started");

            // слушаем порт
            while(true)
            {

            }
        }
        catch(Exception e)
        {System.out.println("init error: "+e);}
    }
    public Server(int[] arr, int n, Socket s) {
        this.arr = arr;
        this.n = n;
        this.s = s;

        setDaemon(true);
        setPriority(NORM_PRIORITY);
        start();
    }

    public void run() {
        try {
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            byte buf[] = new byte[64*1024];
            int r = is.read(buf);

            String data = new String(buf, 0, r);

            data = ""+": "+"\n"+data;

            os.write(data.getBytes());

            s.close();
        }
        catch(Exception e) {System.out.println("init error: "+e);}
    }
}
