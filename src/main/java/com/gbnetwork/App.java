package com.gbnetwork;

import com.gbnetwork.client.Client;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        ArrayList<Client> clients = new ArrayList<>();
        while (true) {
            clients.add(new Client());
            if (clients.size() > 12) break;
        }
        System.out.println("Application starts...");
        for (Client client: clients
             ) {
            String[] par = {Integer.toString(client.getClientId())};
            Client.main(par);
        }

    }
}
