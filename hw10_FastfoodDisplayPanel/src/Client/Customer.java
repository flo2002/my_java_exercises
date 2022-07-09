package Client;

import java.io.OutputStream;
import java.net.Socket;

public class Customer {
    
    public Customer() {
    }

    public void send(String msg) {
        try (Socket socket = new Socket("localhost", 8080)) {

            try (OutputStream out = socket.getOutputStream()) {
                out.write(msg.getBytes());
                System.out.print(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
