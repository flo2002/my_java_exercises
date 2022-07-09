package simpleMUD;

public class Player {
    private static Integer _counter = 1;
    private String _username;
    public Integer _id;
    private Cell _position;
    private Integer _points;
    private Integer _maxPoints;
    private Boolean _hasKey;
    private static Integer _levelCounter = 0;

    public Player (String username) {
        _username = username;
        _id = _counter++;
        _position = new Cell(new Integer[] {0,0}, "none0");
        _points = 0;
        _maxPoints = 0;
        _hasKey = false;
        _levelCounter = 0;
    }

    public void move (Direction d, Game game, Player user) {
        Cell neighbor = _position.getNeighbor(d);

        if (_position.getID() != neighbor.getID()) {
            switch (neighbor.getCellStatus()) {
                case DEFAULT:
                    walk(neighbor);
                    break;
                case ITEM:
                    _points++;
                    walk(neighbor);
                    break;
                case KEY:
                    _hasKey = true;
                    walk(neighbor);
                    break;
                case DOOR:
                    if (_hasKey) {
                        _hasKey = false;
                        _levelCounter++;
                        game.nextLevel(user, user.getLevel());
                        this.spawn();
                    } else {
                        System.out.println("You don't have a key!");
                    }
                    break;
            }
        } else {
            System.out.println("unable to walk in this direction");
        }
    }

    private void walk(Cell neighbor) {
        _position.setCellStatus(CellStatus.DEFAULT);
        _position = neighbor;
        _position.setCellStatus(CellStatus.PLAYER);
    }

    public void spawn() {
        _position = Level.getCells()[0][0];
        Level.getCells()[0][0].setDescription("origin", "Where Player spawns.");
        Level.getCells()[0][0].setCellStatus(CellStatus.PLAYER);
    }

    public void leave() {
        _position.setCellStatus(CellStatus.DEFAULT);
        System.out.println("You won the game!");
        System.exit(0);
    }

    public Integer getLevel() {
        return _levelCounter;
    }

    public String getUsername() {
        return _username;
    }

    public Integer getPoints() {
        return _points;
    }

    public Integer getID() {
        return _id;
    }

    public Cell getPosition() {
        return _position;
    }

    public void setMaxPoints(Integer maxPoints) {
        _maxPoints = maxPoints;
    }

    public Integer getMaxPoints() {
        return _maxPoints;
    }
}
