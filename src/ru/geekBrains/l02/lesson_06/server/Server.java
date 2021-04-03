package ru.geekBrains.l02.lesson_06.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server(){
        try {
            ServerSocket serverSocket = new ServerSocket( 8181);
            System.out.println("Server starting...");
            System.out.println("Waiting for client connection on port..." + serverSocket.getLocalPort());
            Socket acceptSocket = serverSocket.accept();
            System.out.printf("Socket assigned to client: %s", acceptSocket.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
