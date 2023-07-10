package com.gbnetwork.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 55555;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            String idClient = (args.length > 0) ? args[0] : "default num %";
            // Send a message to the server
            writer.println("Hello, server! It`s " + idClient);

            // Receive and print the server's response
            String serverResponse = reader.readLine();
            System.out.println("Server response: " + serverResponse);

            // Close resources
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getClientId(){
        return this.hashCode();
    }
}
