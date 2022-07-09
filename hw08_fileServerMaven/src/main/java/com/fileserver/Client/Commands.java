package com.fileserver.Client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Commands {
    public void check(String msg, Client client) {
        if (msg.startsWith("/put ")) {
            String[] parts = msg.split(" ");
            String filename = parts[1].replace("\n", "");

            client.send(msg);

            try (InputStream in = new FileInputStream(filename)) {
                try {
                    OutputStream out = client.getSocket().getOutputStream();
                    int count = in.read();
                    while (count > 0) {
                        //System.out.println(count);
                        out.write(count);
                        count = in.read();
                    }
                    //System.out.println(count);
                    out.write(-1);
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

            try {
                InputStream in = client.getSocket().getInputStream();

                try (OutputStream out = new FileOutputStream(filename)) {
                    client.send(msg);
                    int count = in.read();
                    while (count != 255) {
                        System.out.println(count);
                        out.write(count);
                        count = in.read();
                    }
                    System.out.println(count);
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (msg.startsWith("/getUsername")) {
            client.send(msg);
        }

        if (msg.startsWith("/changeUsername")) {
            client.send(msg);
        }

        if (!msg.startsWith("/")) {
            client.send(msg);
        }
    }
}
