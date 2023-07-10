package com.gbnetwork.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Core {
    private static final int PORT = 55555;
    private static final int MAX_THREADS = 10;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        int currentConnections = 0;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                if (currentConnections > 10) {
                    System.out.printf("Reached maximal server capacity(%d)! \n",currentConnections);
                    continue;
                }
                Socket clientSocket = serverSocket.accept();
                //TODO: Add secure checks for every new connection.
                currentConnections++;
                System.out.println("New client connected: " + clientSocket);

                // Create a new thread to handle the client connection
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}