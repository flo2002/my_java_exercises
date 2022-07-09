package simpleMUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private static List<Player> _players = new ArrayList<Player>();
    private static List<Level> _levels = new ArrayList<Level>();
    private Integer _level;

    public Game (Player p) {
        _level = 0;
        addPlayer(p);
        createTutorialLevel();
    }

    public void addPlayer(Player p) {
        _players.add(p);
    }

    public Player[] getPlayers() {
        Player[] players = new Player[_players.size()];
        int i = 0;
        for (Player p : _players) {
            players[i++] = p;
        }
        return  players;
    }

    public void createTutorialLevel() {
        Integer matrix_size = 5;
        Cell[][] cells = new Cell[matrix_size][matrix_size];

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                Integer[] location = new Integer[] {i, j};
                cells[i][j] = new Cell(location, "default", "empty");
            }
        }
        Level tutorialLevel = new Level("Tutorial Level", cells);
        _levels.add(tutorialLevel);

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                cells[i][j].updateNeighbors();
            }
        }

        generateItem(matrix_size, CellStatus.DOOR);
        generateItem(matrix_size, CellStatus.KEY);
        for (int i=0; i<matrix_size; i++) {
            generateItem(matrix_size, CellStatus.ITEM);
        }
        for (Player p : _players) {
            p.setMaxPoints(p.getMaxPoints() + matrix_size);
        }
    }

    private void createLevel1() {
        Integer matrix_size = 7;
        Cell[][] cells = new Cell[matrix_size][matrix_size];

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                Integer[] location = new Integer[] {i, j};
                cells[i][j] = new Cell(location, "default", "empty");
            }
        }
        Level level1 = new Level("Level1", cells);
        _levels.add(level1);

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                cells[i][j].updateNeighbors();
            }
        }

        generateItem(matrix_size, CellStatus.DOOR);
        generateItem(matrix_size, CellStatus.KEY);
        for (int i=0; i<matrix_size; i++) {
            generateItem(matrix_size, CellStatus.ITEM);
        }
        for (Player p : _players) {
            p.setMaxPoints(p.getMaxPoints() + matrix_size);
        }
    }

    private void createLevel2() {
        Integer matrix_size = 5;
        Cell[][] cells = new Cell[matrix_size][matrix_size];

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                Integer[] location = new Integer[] {i, j};
                cells[i][j] = new Cell(location, "default", "empty");
            }
        }

        cells[0][4].setCellStatus(CellStatus.EMPTY);
        cells[4][0].setCellStatus(CellStatus.EMPTY);
        cells[0][3].setCellStatus(CellStatus.EMPTY);
        cells[3][0].setCellStatus(CellStatus.EMPTY);
        //cells[1][3].setCellStatus(CellStatus.EMPTY);
        cells[3][1].setCellStatus(CellStatus.EMPTY);
        cells[3][2].setCellStatus(CellStatus.EMPTY);

        Level level1 = new Level("Level1", cells);
        _levels.add(level1);

        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                cells[i][j].updateNeighbors();
            }
        }

        generateItem(matrix_size, CellStatus.DOOR);
        generateItem(matrix_size, CellStatus.KEY);
        for (int i=0; i<matrix_size; i++) {
            generateItem(matrix_size, CellStatus.ITEM);
        }
        for (Player p : _players) {
            p.setMaxPoints(p.getMaxPoints() + matrix_size);
        }
    }

    public void generateItem(Integer matrix_size, CellStatus status) {
        Cell[][] cells = Level.getCells();
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

    public void nextLevel(Player p, Integer levelCounter) {
        switch (levelCounter) {
            case 1:
                createLevel1();
                break;
            case 2:
                createLevel2();
                break;
            case 3:
                p.leave();
        }
        _level++;
    }
}
