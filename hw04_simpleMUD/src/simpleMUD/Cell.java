package simpleMUD;

import java.util.ArrayList;

public class Cell {
    private static Integer _counter = 0;
    private Integer _id;
    private String _shortDescription;
    private String _fullDescription;
    private Integer[] _location;
    private ArrayList<Cell> _neighbors = new ArrayList<Cell>();
    private CellStatus _status;

    Cell(Integer[] location, String shortDescription, String fullDescription) {
        this(location, shortDescription);
        _fullDescription = fullDescription;
    }

    Cell(Integer[] location, String shortDescription) {
        _id = _counter++;
        _status = CellStatus.DEFAULT;
        _location = location;
        _shortDescription = shortDescription;
        _fullDescription = "no detailed description";
    }

    public Cell getNeighbor(Direction d) {
        Integer[] neighbor = new Integer[] {_location[0] + d.getIntegerValues()[0],
                                            _location[1] + d.getIntegerValues()[1]};

        Cell[][] cells = Level.getCells();
        for (int i=0; i<cells.length; i++) {
            for (int j = 0; j<cells[0].length; j++) {
                Cell cell = cells[i][j];
                if (cell.getLocation()[0] == neighbor[0] && cell.getLocation()[1] == neighbor[1]) {
                    return cell;
                }
            }
        }

        return this;
    }

    public void updateNeighbors() {
        for (Direction d : Direction.values()) {
            _neighbors.add(getNeighbor(d));
        }
    }

    public Integer getID() {
        return _id;
    }

    public String getShortDescription() {
        return _shortDescription;
    }

    public String getFullDescription() {
        return _fullDescription;
    }

    public void setDescription(String shortDescription, String fullDescription) {
        _shortDescription = shortDescription;
        _fullDescription = fullDescription;
    }

    public static Integer getCellCount() {
        return _counter;
    }

    public Integer[] getLocation() {
        return _location;
    }

    public CellStatus getCellStatus() {
        return _status;
    }

    public void setCellStatus(CellStatus status) {
        _status = status;
    }
}
