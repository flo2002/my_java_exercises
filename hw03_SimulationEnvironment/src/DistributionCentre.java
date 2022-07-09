import java.util.ArrayList;
public class DistributionCentre {
    public static ArrayList<Cell> _distributionCentre = new ArrayList<Cell>();

    public static void add(Cell cell) throws Exception {
        if (!_distributionCentre.contains(cell)) {
            _distributionCentre.add(cell);
        } else {
            throw new Exception("Cell already exists in the distribution centre");
        }
    }

    public static void replace(Cell oldCell, Cell newCell) {
        _distributionCentre.remove(oldCell);
        _distributionCentre.add(newCell);
    }

    public static Boolean isEmpty() {
        return _distributionCentre.size() == 0;
    }

    public static Boolean isEmpty(Cell cell) {
        if (_distributionCentre.contains(cell)) {
            return false;
        } else {
            return true;
        }
    }

    public static void clean() {
        _distributionCentre.clear();
    }

    public static String print() {
        String result = "Current Distribution Centre: \n";
        for (Cell cell : _distributionCentre) {
            result += "\t" + cell.toString() + "\n";
        }
        return result;
    }
}
