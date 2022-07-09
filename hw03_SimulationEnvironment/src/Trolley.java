import java.util.ArrayList;

public class Trolley {
    private ArrayList<Product> _products;
    private Cell _currentPos;

    Trolley (Integer[] currentPos) throws Exception {
        _products = new ArrayList<Product>();
        if (currentPos == null) {
            Integer[] defaultPos = {0,0};
            _currentPos = new Cell(defaultPos);
        } else {
            _currentPos = new Cell(currentPos);
        }
        DistributionCentre.add(_currentPos);
    }

    Trolley (ArrayList<Product> products, Integer[] currentPos) throws Exception {
        this(currentPos);
    
        for (Product product : products) {
            if (!product.getDestination().getCell().equals(products.get(0).getDestination().getCell()) ) {
                throw new Exception("Destination mismatch in the ArrayList of products");
            }
        }
        
        _products = products;
    }

    Trolley (ArrayList<Product> products) throws Exception {
        this(products, null);
    }

    Trolley (Product product, Integer[] currentPos) throws Exception {
        this(currentPos);
        _products.add(product);
    }

    Trolley (Product product) throws Exception {
        this(product, null);
    }

    public void setCurrentPosition(Integer[] currentPos) {
        _currentPos.moveCell(currentPos);
    }

    public void addProduct(Product product) throws Exception {
        if (_products.get(0).getDestination().equals(product.getDestination())) {
            _products.add(product);
        } else {
            throw new Exception("Destination mismatch for adding a product");
        }
    }

    public void moveToDestination() throws Exception {
        if (_products.size() == 0) {
            throw new Exception("No products with a destination");
        }
        
        DistributionCentre._distributionCentre.remove(_currentPos);
        _currentPos = new Cell(_products.get(0).getDestination());
        for (Product product : _products) {
            _currentPos.moveCell(product.getDestination().getCell());
        }
    }

    public void moveToPosition(Integer[] pos) {        
        _currentPos = new Cell(pos);
    }

    public String unload() throws Exception {
        if (_products.size() == 0) {
            throw new Exception("No products available for unloading");
        }
        
        // try/finally eigentlich nur verwendet, um etwas nach return auszuführen
        try {
            return this.toString();
        }
        finally {
            _products = null;
            _currentPos = null;
        }
    }

    public Product getProduct(int index) throws Exception {
        if (_products.size() == 0) {
            throw new Exception("No products available to return");
        }
        
        Product product = _products.get(index);
        return product;
    }

    public String toString() {
        return "Trolley: (" + _currentPos.getCell()[0] + ", " + _currentPos.getCell()[1] + ")\n" 
            + _products.toString().replace("), ", ")\n\t").replace("[", "\t").replace("]", "");
    }
}
