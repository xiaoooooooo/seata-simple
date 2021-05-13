package com.xiao;

import org.springframework.util.StringUtils;
import sun.jvm.hotspot.debugger.ThreadAccess;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @author xiaojw
 * @describe Bio
 * @date 2021/4/22 16:00
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(9000));

        while (true) {
            Socket socket = serverSocket.accept();
            Random random = new Random(10);
            String name = null;
            new Thread(null,() -> {

                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    out.println("Hello World");
                    out.flush();
                    InputStream inputStream = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    String s = "";
                    while (true) {
                        if (!((s = reader.readLine()) != null)) {
                            break;
                        }
                        System.out.println(name +"接收到数据：" + s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            },String.valueOf(random.nextInt())).start();

        }

    }
}
