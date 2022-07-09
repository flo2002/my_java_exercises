package simpleMUD;

public class Level {
    private String _levelName;
    private static Cell[][] _cells;

    Level (String name, Cell[][] cells) {
        _levelName = name;
        _cells = cells;
    }

    public String getName() {
        return _levelName;
    }

    public static Cell[][] getCells() {
        return _cells;
    }
}
