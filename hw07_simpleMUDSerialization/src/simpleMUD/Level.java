package simpleMUD;

import java.io.Serializable;

public class Level implements Serializable {
    private String _levelName;
    private Cell[][] _cells;

    Level (String name, Cell[][] cells) {
        _levelName = name;
        _cells = cells;
    }

    public String getName() {
        return _levelName;
    }

    public Cell[][] getCells() {
        return _cells;
    }
}
