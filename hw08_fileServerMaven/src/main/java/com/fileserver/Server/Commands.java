package com.fileserver.Server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Commands {
    public void check(String msg, ClientHandler clientHandler) {
        if (msg.startsWith("/changeUsername ")) {
            String[] parts = msg.split(" ");
            if (parts.length > 1) {
                clientHandler.setUsername(parts[1]);
            }
        }

        if (msg.startsWith("/getUsername")) {
            clientHandler.send(clientHandler.getUsername() + "\n");
        }

        if (msg.startsWith("/put ")) {
            String[] parts = msg.split(" ");
            String filename = parts[1].replace("\n", "");
            String filepath = clientHandler.getProperties().getRoot() + "/" + filename;

            try {
                InputStream in = clientHandler.getSocket().getInputStream();

                try (OutputStream out = new FileOutputStream(filepath)) {
                    int count = in.read();
                    while (count != 255) {
                        //System.out.println(count);
                        out.write(count);
                        count = in.read();
                    }
                    //System.out.println(count);
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (msg.startsWith("/get ")) {
            String[] parts = msg.split(" ");
            String filename = parts[1].replace("\n", "");
            String filepath = clientHandler.getProperties().getRoot() + "/" + filename;
            File file = new File(filepath);
            System.out.println(file.getAbsolutePath());

            try (InputStream in = new FileInputStream(file)) {
                try {
                    OutputStream out = clientHandler.getSocket().getOutputStream();
                    int count = in.read();
                    while (count > 0) {
                        System.out.println(count);
                        out.write(count);
                        count = in.read();
                    }
                    System.out.println(count);
                    out.write(-1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (msg.startsWith("/dir")) {
            String[] files = new java.io.File(clientHandler.getProperties().getRoot()).list();

            for (String filename : files) {
                clientHandler.send(filename);
            }
        }
    }
}
