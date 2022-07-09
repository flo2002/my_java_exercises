package Client;
public class App {
    public static void main(String[] args) throws Exception {
        Customer customer = new Customer();
        customer.send("Hello World1\n");
        customer.send("Hello World2\n");

    }
}
