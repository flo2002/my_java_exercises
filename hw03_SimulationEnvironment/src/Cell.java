//import java.util.ArrayList;
import java.util.Arrays;

public class Cell {
    private Integer[] _cell;

    Cell (Integer[] cell) {
        _cell = cell;
    }
    Cell (Cell cell) {
        _cell = cell.getCell();
    }

    public void moveCell(Integer[] pos) {
        Cell tmp = new Cell(pos);
        _cell = pos;
        DistributionCentre.replace(tmp, this);
    }

    public Integer[] getCell() {
        return _cell;
    }

    public Neighbor[] getNeighbors() {
        Neighbor[] neighbors = new Neighbor[4];
        int i = 0;

        System.out.println(DistributionCentre._distributionCentre.contains(new Cell(new Integer[] {_cell[0] - 1, _cell[1]})));
        if (DistributionCentre._distributionCentre.contains(new Cell(new Integer[] {_cell[0] - 1, _cell[1]}))) {
            neighbors[i] = Neighbor.TOP;
            i++;
        }
        if (DistributionCentre._distributionCentre.contains(new Cell(new Integer[] {_cell[0] + 1, _cell[1]}))) {
            neighbors[i] = Neighbor.BOTTOM;
            i++;
        }
        if (DistributionCentre._distributionCentre.contains(new Cell(new Integer[] {_cell[0], _cell[1] - 1}))) {
            neighbors[i] = Neighbor.LEFT;
            i++;
        }
        if (DistributionCentre._distributionCentre.contains(new Cell(new Integer[] {_cell[0], _cell[1] + 1}))) {
            neighbors[i] = Neighbor.RIGHT;
        }
 
        return neighbors;

        /*// create possible neighbor positions
        ArrayList<Integer[]> possibleNeighbors = new ArrayList<Integer[]>() {
            {
                add(new Integer[] {-1,0});
                add(new Integer[] {0,-1});
                add(new Integer[] {0,1});
                add(new Integer[] {1,0});
            }
        };

        // search if neighbors exist in the distribution centre
        possibleNeighbors.forEach( (n) -> {
            Cell tmp = new Cell(new Integer[] {_cell[0] + n[0], _cell[1] + n[1]});
            if (DistributionCentre._distributionCentre.contains(tmp)) {
                neighbors[i++] = ???;
            }
        });*/
    }

    public String toString() {
        String dest1 = Integer.toString(_cell[0]);
        String dest2 = Integer.toString(_cell[1]);
        return "(" + dest1 + ", " + dest2 + ")";
    }

    @Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;
        if (object != null && object instanceof Cell)
        {
            sameSame = Arrays.equals(this._cell, ((Cell) object)._cell);
        }
        return sameSame;
    }
}
