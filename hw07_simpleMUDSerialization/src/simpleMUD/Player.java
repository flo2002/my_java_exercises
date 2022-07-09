package simpleMUD;

import java.io.Serializable;

public class Player implements Serializable {
    private static Integer _counter = 1;
    private String _username;
    public Integer _id;
    private Cell _position;
    private Integer _points;
    private Integer _maxPoints;
    private Boolean _hasKey;
    private Integer _levelCounter;

    public Player (String username) {
        _username = username;
        _id = _counter++;
        _position = new Cell(new int[] {0,0}, "none0");
        _points = 0;
        _maxPoints = 0;
        _hasKey = false;
        _levelCounter = 0;
    }

    public void move (Direction d, Game game, Player p) {
        Cell neighbor = _position.getNeighbor(d, game, p);

        if (!(_position.getID() == neighbor.getID())) {
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
                        game.nextLevel(game, this, getLevel());
                        this.spawn(game);
                    } else {
                        System.out.println("You don't have a key!");
                    }
                    break;
            }
        } else {
            System.out.println("unable to walk in this direction: " + d +
                    " position: " + _position +
                    " neighbor: " + neighbor);
        }
    }

    private void walk(Cell neighbor) {
        _position.setCellStatus(CellStatus.DEFAULT);
        _position = neighbor;
        _position.setCellStatus(CellStatus.PLAYER);
    }

    public void spawn(Game game) {
        _position = game.getLevel(this).getCells()[0][0];
        game.getLevel(this).getCells()[0][0].setDescription("origin", "Where Player spawns.");
        game.getLevel(this).getCells()[0][0].setCellStatus(CellStatus.PLAYER);
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
