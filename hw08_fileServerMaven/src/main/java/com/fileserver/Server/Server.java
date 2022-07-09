package com.fileserver.Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.fileserver.Server.Config.Properties;

public class Server implements Runnable {
    private List<ClientHandler> _clients;
    private Properties _properties;
    private InputStream _inputStream;
    private Boolean _isAuthenticated;

    public Server(Properties properties) {
        _clients = new ArrayList<ClientHandler>();
        _properties = properties;
        _isAuthenticated = false;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(_properties.getPort())) {
            System.out.println("Server started");
            while (!serverSocket.isClosed()) {
                Socket clientSocket = serverSocket.accept();

                connectionSetupProcedure(clientSocket);         // Authenticate and set up the ClientHandler or close the connection
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void connectionSetupProcedure(Socket socket) {
        StringBuilder message = new StringBuilder();

        //try (InputStream in = socket.getInputStream()) {
        try {
            _inputStream = socket.getInputStream();
            int c = _inputStream.read();

            while (c != 10) {
                message.append((char) c);
                c = _inputStream.read();
            }
            //_inputStream.close();           // closes socket, why?

        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] strings = message.toString()
        .replace("\n", "")
        .split(" ");

        if (strings.length == 2) {
            String username = strings[0];
            String password = strings[1];

            handleAuthentication(username, password, socket);
        }
    }

    public void handleAuthentication(String username, String password, Socket socket) {
        if (_properties.checkAuthentication(username, password)) {
            ClientHandler clientHandler = new ClientHandler(socket, _inputStream, _properties);
            clientHandler.start();
            _clients.add(clientHandler);
            
            _isAuthenticated = true;
            clientHandler.setUsername(username);
            System.out.println("Authenticated: " + username);
        }


        if (!_isAuthenticated) {
            try {
                socket.close();
                _inputStream = null;
                System.out.println("Not Authenticated: " + username);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Properties getProperties() {
        return _properties;
    }
}
