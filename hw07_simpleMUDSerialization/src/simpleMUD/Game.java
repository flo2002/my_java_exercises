package simpleMUD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game implements Serializable {
    private List<Player> _players = new ArrayList<Player>();
    private List<Level> _levels = new ArrayList<Level>();

    public Game (Player p) {
        addPlayer(p);
        createTutorialLevel(this, p);
    }

    public void addPlayer(Player p) {
        _players.add(p);
    }

    public Level getLevel(Player p) {
        return _levels.get(p.getLevel());
    }

    public void setLevel(Level lvl, Player p) {
        _levels.set(p.getLevel(), lvl);
    }

    public Player[] getPlayers() {
        Player[] players = new Player[_players.size()];
        int i = 0;
        for (Player p : _players) {
            players[i++] = p;
        }
        return  players;
    }

    public void createTutorialLevel(Game game, Player p) {
        Integer matrix_size = 5;
        Cell[][] cells = new Cell[matrix_size][matrix_size];

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                int[] location = new int[] {i, j};
                cells[i][j] = new Cell(location, "default", "empty");
            }
        }
        Level tutorialLevel = new Level("Tutorial Level", cells);
        _levels.add(tutorialLevel);

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                cells[i][j].updateNeighbors(game, p);
            }
        }

        generateItem(matrix_size, CellStatus.DOOR, getLevel(p));
        generateItem(matrix_size, CellStatus.KEY, getLevel(p));
        for (int i=0; i<matrix_size; i++) {
            generateItem(matrix_size, CellStatus.ITEM, getLevel(p));
        }
        for (Player ps : _players) {
            ps.setMaxPoints(ps.getMaxPoints() + matrix_size);
        }
    }

    private void createLevel1(Game game, Player p) {
        Integer matrix_size = 7;
        Cell[][] cells = new Cell[matrix_size][matrix_size];

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                int[] location = new int[] {i, j};
                cells[i][j] = new Cell(location, "default", "empty");
            }
        }
        Level level1 = new Level("Level1", cells);
        _levels.add(level1);

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                cells[i][j].updateNeighbors(game, p);
            }
        }

        generateItem(matrix_size, CellStatus.DOOR, getLevel(p));
        generateItem(matrix_size, CellStatus.KEY, getLevel(p));
        for (int i=0; i<matrix_size; i++) {
            generateItem(matrix_size, CellStatus.ITEM, getLevel(p));
        }
        for (Player ps : _players) {
            ps.setMaxPoints(ps.getMaxPoints() + matrix_size);
        }
    }

    private void createLevel2(Game game, Player p) {
        Integer matrix_size = 5;
        Cell[][] cells = new Cell[matrix_size][matrix_size];

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                int[] location = new int[] {i, j};
                cells[i][j] = new Cell(location, "default", "empty");
            }
        }

        cells[0][4].setCellStatus(CellStatus.EMPTY);
        cells[4][0].setCellStatus(CellStatus.EMPTY);
        cells[0][3].setCellStatus(CellStatus.EMPTY);
        cells[3][0].setCellStatus(CellStatus.EMPTY);
        cells[3][1].setCellStatus(CellStatus.EMPTY);
        cells[3][2].setCellStatus(CellStatus.EMPTY);

        Level level1 = new Level("Level1", cells);
        _levels.add(level1);

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                cells[i][j].updateNeighbors(game, p);
            }
        }

        generateItem(matrix_size, CellStatus.DOOR, getLevel(p));
        generateItem(matrix_size, CellStatus.KEY, getLevel(p));
        for (int i=0; i<matrix_size; i++) {
            generateItem(matrix_size, CellStatus.ITEM, getLevel(p));
        }
        for (Player ps : _players) {
            ps.setMaxPoints(ps.getMaxPoints() + matrix_size);
        }
    }

    public void generateItem(Integer matrix_size, CellStatus status, Level lvl) {
        Cell[][] cells = lvl.getCells();
        Random rand = new Random();
        int a;
        int b;

        do {
            a = rand.nextInt(matrix_size);
            b = rand.nextInt(matrix_size);
        } while (cells[a][b].getCellStatus() != CellStatus.DEFAULT || a+b == 0);

        if (cells[a][b].getCellStatus() != CellStatus.DEFAULT) {
            System.out.println(cells[a][b].getCellStatus() != CellStatus.DEFAULT);
        }

        cells[a][b].setCellStatus(status);
    }

    public void nextLevel(Game game, Player p, Integer levelCounter) {
        switch (levelCounter) {
            case 1:
                createLevel1(game, p);
                break;
            case 2:
                createLevel2(game, p);
                break;
            case 3:
                p.leave();
        }
    }
}
