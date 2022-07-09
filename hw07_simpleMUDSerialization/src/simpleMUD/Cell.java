package simpleMUD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cell implements Serializable {
    private static int _counter = 0;
    private int _id;
    private String _shortDescription;
    private String _fullDescription;
    private int[] _location;
    private ArrayList<Cell> _neighbors = new ArrayList<Cell>();
    private CellStatus _status;

    Cell(int[] location, String shortDescription, String fullDescription) {
        this(location, shortDescription);
        _fullDescription = fullDescription;
    }

    Cell(int[] location, String shortDescription) {
        _id = _counter++;
        _status = CellStatus.DEFAULT;
        _location = location;
        _shortDescription = shortDescription;
        _fullDescription = "no detailed description";
    }

    public Cell getNeighbor(Direction d, Game game, Player p) {
        int[] neighbor = new int[] {_location[0] + d.getIntegerValues()[0],
                                            _location[1] + d.getIntegerValues()[1]};

        Cell[][] cells = game.getLevel(p).getCells();
        //System.out.println(neighbor[0] + " " + neighbor[1]);
        for (int i=0; i<cells.length; i++) {
            for (int j = 0; j<cells[0].length; j++) {
                Cell cell = cells[i][j];
                System.out.println(cell.getLocation()[0] + "=" + neighbor[0] + " && " + cell.getLocation()[1] + "=" + neighbor[1]);
                if (cell.getLocation()[0] == neighbor[0] && cell.getLocation()[1] == neighbor[1]) {
                    return cell;
                }
            }
        }

        return this;
    }

    public void updateNeighbors(Game game, Player p) {
        for (Direction d : Direction.values()) {
            _neighbors.add(getNeighbor(d, game, p));
        }
    }

    public void setIndex() {
        _id = _counter++;
    }

    public int getID() {
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

    public static int getCellCount() {
        return _counter;
    }

    public int[] getLocation() {
        return _location;
    }

    public CellStatus getCellStatus() {
        return _status;
    }

    public void setCellStatus(CellStatus status) {
        _status = status;
    }

    @Override
    public String toString() {
        return Arrays.toString(_location);
    }
}
