package com.fileserver.Server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.fileserver.Server.Config.Properties;

public class ClientHandler extends Thread {
    private Socket _socket;
    private InputStream _inputStream;
    private String _username;
    private Properties _properties;

    public ClientHandler(Socket clientSocket, InputStream inputStream, Properties properties) {
        _socket = clientSocket;
        _properties = properties;
        _inputStream = inputStream;
    }

    public void send(String msg) {
        try {
            OutputStream outputStream = _socket.getOutputStream();
            outputStream.write(msg.getBytes());
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        StringBuilder message = new StringBuilder();
        Commands commands = new Commands();

        //try (InputStream in = _inputStream) {
        try {
            int c = _inputStream.read();

            while (c != -1) {
                message.append((char) c);
                if (c == 10) {
                    commands.check(message.toString(), this);

                    System.out.print(message.toString());
                    message = new StringBuilder();
                }
                c = _inputStream.read();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Socket getSocket() {
        return _socket;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        _username = username;
    }

    public Properties getProperties() {
        return _properties;
    }
}
