package Server;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.run();
    }
}
