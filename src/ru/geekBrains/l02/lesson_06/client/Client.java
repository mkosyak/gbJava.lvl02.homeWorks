package ru.geekBrains.l02.lesson_06.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() {
        try {
            Socket socketClient = new Socket("127.0.0.1", 8181);    //127.0.0.1
            System.out.println(socketClient.getRemoteSocketAddress().toString());
            DataInputStream in = new DataInputStream(socketClient.getInputStream());
            DataOutputStream out = new DataOutputStream(socketClient.getOutputStream());

            Scanner scanner = new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
