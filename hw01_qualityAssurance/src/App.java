public class App {
    public static void main(String[] args) throws Exception {
        int em[][] = {
            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,1,0,0,0,0, 0,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,1,0,0,0, 0,0,0,0,0,1,0,0,0},
            {0,0,0,1,1,1,0,0,0,1, 1,0,0,0,1,0,1,0,0},
            {0,0,0,0,0,0,0,0,0,1, 1,0,0,0,0,1,0,0,0},
            {0,1,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0}
        };
        Cheese emmentaler = new Cheese(em);
        
        System.out.println(emmentaler);
        System.out.println(emmentaler.countHoles());
        System.out.println(emmentaler.biggestScope());
    }
}
