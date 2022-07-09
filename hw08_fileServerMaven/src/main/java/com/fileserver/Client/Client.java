package com.fileserver.Client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client implements Runnable {
    private String _host;
    private int _port;
    private Socket _socket;

    public Client(String host, int port) {
        _host = host;
        _port = port;
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

    @Override
    public void run() {
        try (Socket socket = new Socket(_host, _port)) {
            System.out.println("Connected to server");
            _socket = socket;

            Commands commands = new Commands();
            BufferedReader consoleReader = new BufferedReader(
                                new InputStreamReader(System.in));
            String consoleInput;

            try {
                responsePrinter();
                while (true) {
                    try {
                        consoleInput = consoleReader.readLine();

                        if (consoleInput != null) {
                            consoleInput = consoleInput + "\n";

                            commands.check(consoleInput, this);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void responsePrinter() {
        new Thread() {
            StringBuilder message = new StringBuilder();

            public void run() {
                try (InputStream in = _socket.getInputStream()) {
                    int c = in.read();
                    while (c != -1) {
                        message.append((char) c);
                        if (c == 10) {
                            System.out.print(message.toString());
                            message = new StringBuilder();
                        }
                        c = in.read();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public Socket getSocket() {
        return _socket;
    }
}
