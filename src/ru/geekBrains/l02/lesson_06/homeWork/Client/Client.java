package ru.geekBrains.l02.lesson_06.homeWork.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client(String host, int port) {
        try {
            Socket clientSocket = new Socket(host, port);
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            System.out.println("input Stream established - " + in.toString());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            System.out.println("output Stream established - " + out.toString());

//  Sending data from console -> transfer to Server side (in separate Thread)
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Enter any message:> ");

            new Thread(() -> {
                try {
                    while (true) {
                        out.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    System.out.printf("%nOutbound connection to %s was closed by server", host); // Graceful message
//                        e.printStackTrace();                                                   // should be saved to log
                }
            }).start();

//  Reading the Data from servers side and output to console
            while (true) {
                try {
                    System.out.printf(" :>>%s%n", in.readUTF());
                } catch (IOException e) {
                    System.out.printf("%nInbound connection to %s was closed by server ", host); // Graceful message
//                   e.printStackTrace();                                                        // should be saved to log
                    break;
                }
            }

        } catch (
                IOException e) {
            System.out.printf("%nServer %s port %d can nat be resolved, try again later.", host, port); // Graceful message
//            e.printStackTrace();                                                                      // should be saved to log
        }
    }
}
