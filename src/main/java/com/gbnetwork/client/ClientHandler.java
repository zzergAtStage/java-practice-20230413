package com.gbnetwork.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Perform MVP pattern logic here
            // You can define your Model, View, and Presenter classes and interact with them

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                // Process client message
                String response = "Server received: " + clientMessage;
                writer.println(response);
            }

            // Close resources
            reader.close();
            writer.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
