package ru.geekBrains.l02.lesson_06.homeWork.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public boolean connectionIsOK = true;

    public Server(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started.");
            System.out.println("Waiting for connection...");
            Socket socket = serverSocket.accept();
            System.out.println("> Connection succeeded successfully via " + socket.toString());

            DataInputStream inServer = new DataInputStream(socket.getInputStream());
            System.out.println(">> Input stream assigned " + inServer.toString());

            DataOutputStream outServer = new DataOutputStream(socket.getOutputStream());
            System.out.println(">> Output stream assigned " + outServer.toString());

            new Thread(() -> {
                while (true) {
                    try {
                        //  ---- Receiving the messages
                        String inMessage = inServer.readUTF();
                        if (inMessage.equals("--bye")) {
                            System.out.printf("%nDisconnection command received from %s", socket.toString());
                            outServer.writeUTF("Good bye, connection closed ");
                            socket.close();
                            break;
                        }
                        System.out.printf("%nReceived from %s: '%s'%n", socket.toString(), inMessage);
//  ---- Sending back echo Message
//                        outServer.writeUTF("Server echo >>> " + inMessage);

                    } catch (Exception e) {
                        System.out.printf("%nConnection to socket %s was closed by client.", socket.toString());   // Graceful message
//                       e.printStackTrace();                                                                      // should be saved to log
                        connectionIsOK = false;
                        break;
                    }
                }
            }).start();

//  ---- Sending the messages
            while (connectionIsOK) {
                Scanner scannerServer = new Scanner(System.in);
                try {
                    outServer.writeUTF(scannerServer.nextLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

