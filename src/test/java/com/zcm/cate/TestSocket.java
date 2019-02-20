package com.zcm.cate;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhangpeijie on 2018/11/15.
 */
public class TestSocket {


    public static void main(String[] args) {


        try {
            ServerSocket serverSocket = new ServerSocket();

            serverSocket.bind( new InetSocketAddress("127.0.0.1",8080));

            Socket socket = serverSocket.accept();

            // readFromSocket

            socket.getInputStream().read();


            socket.getOutputStream().write(1);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
