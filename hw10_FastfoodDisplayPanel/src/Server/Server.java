package Server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {
    private int _port;
    private ArrayList<Integer> _ids;
    private int _counter;
    private ArrayList<String> _menues;
    private Display _display;
    
    public Server(int port) {
        _port = port;
        _ids = new ArrayList<Integer>();
        _menues = new ArrayList<String>();
        _display = new Display(this);
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(_port)) {
            while (true) {
                Socket socket = serverSocket.accept();

                try (InputStream in = socket.getInputStream()) {
                    int c = in.read();
                    StringBuilder order = new StringBuilder();

                    while (c != -1) {
                        order.append((char) c);
                        System.out.print((char) c);

                        c = in.read();

                        if (c == '\n') {
                            _counter++;
                            _ids.add(_counter);
                            _menues.add(order.toString());
                            _display.revalidate();
                            _display.repaint();
                            order = new StringBuilder();
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getIds() {
        return _ids;
    }

    public ArrayList<String> getMenues() {
        return _menues;
    }
}
