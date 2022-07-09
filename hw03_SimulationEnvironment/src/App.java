import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Integer[] dest1 = {4,5};
        Integer[] dest2 = {2,2};
        Product product1 = new Product("Cheese", dest1);
        Product product2 = new Product("Milk", dest1);

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        Trolley trolley1 = new Trolley(products, dest2);
        //System.out.println(DistributionCentre.print());
        //trolley1.setCurrentPosition(dest2);
        System.out.println(DistributionCentre.print());
        trolley1.moveToDestination();
        System.out.println(DistributionCentre.print());
        System.out.println(trolley1.unload());
        System.out.println(DistributionCentre.print());

        dest2 = new Integer[] {3,5}; //UP
        dest2 = new Integer[] {4,4}; //LEFT
        dest2 = new Integer[] {4,6}; //RIGHT
        dest2 = new Integer[] {5,5}; //BOTTOM
        Trolley trolley2 = new Trolley(product1);
        trolley2.setCurrentPosition(dest2);
        trolley2.addProduct(product2);
        System.out.println(DistributionCentre.print());
        Neighbor[] neighbors = trolley2.getProduct(0).getDestination().getNeighbors();
        System.out.println(Arrays.toString(neighbors));
        System.out.println(trolley2.unload());
        System.out.println(DistributionCentre.print());

        DistributionCentre.clean();
        System.out.println(DistributionCentre.print());


        /*
        // Probleme mit .equals() von "benutzerdefinierten" Objekten
                // oh oh Why??? (set _distributionCentre public first)
        Cell c1 = new Cell(new Integer[] {0,0});
        Cell c2 = new Cell(new Integer[] {0,1});
        DistributionCentre.add(c1);
        System.out.println(c1.equals(c2));
        System.out.println(DistributionCentre._distributionCentre.contains(c1));
        System.out.println(DistributionCentre._distributionCentre.contains(c2));
        // Answer: 
        // Source: https://stackoverflow.com/questions/2642589/how-does-a-arraylists-contains-method-evaluate-objects
        ArrayList<String> strs = new ArrayList<String>();
        strs.add("a");
        strs.add("b");
        System.out.println(strs.contains("a"));
        System.out.println(strs.contains("c"));     //???
        */
    }
}
