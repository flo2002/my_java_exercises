import java.util.Arrays;

public class Cheese {
    private int _cheese[][];
    private int _history[][] = new int[1][2];
    private int _historySize = 0;
    private int _maxScope = 0;

    Cheese(int a[][]) {
        _cheese = a;
    }

    private Boolean isInHoleList(int row, int col) {
        for (int i=0; i<_historySize; i++) {
            if (_history[i][0] == row && _history[i][1] == col) {
                return true;
            }
        }
        return false;
    }

    private int[] nextNeighbor(int row, int col) {
        int tmp_hs = _historySize;
        row--;
        col--;
        
        for (int i=0; i<3; i++) {
            for (int e=0; e<3; e++) {
                if (_cheese[row+i][col+e] == 1) { 
                    if (!isInHoleList(row+i, col+e)) {
                        _history = addNewRow2d(_history);

                        row = row + i;
                        col = col + e;

                        _history[_historySize-1][0] = row;
                        _history[_historySize-1][1] = col;

                        i = 4;
                        e = 4;
                    }
                }
            }
        }

        if (tmp_hs == _historySize) {
            return null;
        }

        int result[] = {row, col};
        return result;
    }

    private void noteHole(int row, int col) {
        int[] neighbor = nextNeighbor(row, col);
        int max = 0;

        while (neighbor != null) {
            neighbor = nextNeighbor(neighbor[0], neighbor[1]);
            max++;
        }

        if (max > _maxScope) {
            _maxScope = max;
        }
    }

    public String countHoles() {
        int count = 0;

        for (int row=1; row<_cheese.length; row++) {
            for (int col=1; col<_cheese[0].length; col++) {
                if (_cheese[row][col] == 1) {
                    if (!isInHoleList(row, col)) {
                        noteHole(row, col);
                        count++;
                        col++;
                    }
                }
            }
        }

        return "Anzahl der Löcher: " + count;
    }
    
    private int[][] addNewRow2d(int[][] arr) {
        int[][] new_arr = new int[_historySize+1][2];

        for (int i=0; i<_historySize; i++) {
            for (int e=0; e<2; e++) {
                new_arr[i][e] = arr[i][e];
            }
        }

        _historySize++;
        
        return new_arr;
    }

    public String biggestScope() {
        if (_maxScope == 0) {
            countHoles();
        }
        return "Umfang des größten Lochs: " + _maxScope;
    }

    public String toString() {
        return Arrays.deepToString(_cheese).replace("], ", "], \n");
    }
}
