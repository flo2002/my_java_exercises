public class App {
    public static void main(String[] args) throws Exception {
        Office office = new Office();
        office.start();

        Visitor v1 = new Visitor(office, "v1", "sleeping");
        Visitor v2 = new Visitor(office, "v2", "phoning");
        Visitor v3 = new Visitor(office, "v3", "eating");
        v1.start();
        v2.start();
        v3.start();
        v1.join();
        v2.join();
        v3.join();

        office.join();
    }
}
