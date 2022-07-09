public class Product {
    private String _name;
    private Cell _destination;

    Product (String name, Integer[] destination) {
        _name = name;
        _destination = new Cell(destination);
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public Cell getDestination() {
        return _destination;
    }

    public void setDestination(Cell destination) {
        _destination = destination;
    }

    public String toString() {
        return _name + ": " + _destination.toString();
    }
}
