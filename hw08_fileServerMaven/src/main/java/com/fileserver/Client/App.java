package com.fileserver.Client;

public class App 
{
    public static void main(String[] args) throws Exception {

        if (args.length == 2) {
            String host = args[0];
            int port = Integer.parseInt(args[1]);

            Client client = new Client(host, port);
            client.run();
            
        } else {
            System.out.println("Usage: java Client.App <host> <port>");
            System.exit(0);
        }
    }
}
