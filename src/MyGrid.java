import java.util.Arrays;
public class MyGrid {

    private int _columns;
    private int _rows;
    private String[][] ticTacToeGrid;

    public MyGrid() {

    }

    public MyGrid(int rows, int columns) {

        _rows = rows;
        _columns = columns;

        ticTacToeGrid = new String[_rows][_columns];

        //for (int c = 0; c < _columns; c++) {
        //    for (int r = 0; r < _rows; r++) {
        //        ticTacToeGrid[r][c] = "_";
        //    }
        //}

        for (String[] row: ticTacToeGrid){
            Arrays.fill(row, "_");
        }
    }

    public void setRows() {
        _rows = MainMenu.setRows();
    }

    public void setRows(int rows) {
        _rows = rows;
    }

    public void setColumns() {
        _columns = MainMenu.setColumns();
    }

    public void setColumns(int columns){
        _columns = columns;
    }

    public void setBlankGrid() {

        ticTacToeGrid = new String[_rows][_columns];

        //for (int c = 0; c < _columns; c++) {
        //    for (int r = 0; r < _rows; r++) {
        //        ticTacToeGrid[r][c] = "_";
        //    }
        //}

        for (String[] row: ticTacToeGrid){
            Arrays.fill(row, "_");
        }
    }

    public void setUserInput(int row, int column, String xOrO) {

        if (column >= _columns || row >= _rows) {
            throw new ArrayIndexOutOfBoundsException("Coordinates outside of grid created! Try again!");
        }
        if (!(xOrO.equals("X") || xOrO.equals("O"))) {
            throw new IllegalArgumentException("Please input only X and O");
        }
        if (ticTacToeGrid[row][column].equals("O") || ticTacToeGrid[row][column].equals("X")) {
            throw new IllegalArgumentException("That spot is already taken! Try again!");
        }
        ticTacToeGrid[row][column] = xOrO;
    }

    public boolean returnsWin() {

        //checks for consecutive in a column, loops across grid
        for (int j = 0; j <= ticTacToeGrid[0].length - 1; j++) {
            int inAColumnCounter = 0;

            //loops down grid
            for (int i = 0; i <= ticTacToeGrid.length - 2; i++) {

                //compares cell with cell below it and increment if string equals
                if (ticTacToeGrid[i][j].equals(ticTacToeGrid[i + 1][j]) && !ticTacToeGrid[i][j].equals("_")) {
                    inAColumnCounter++;

                    //returns true if consecutive increment conditions match, and outputs a win string
                    if (inAColumnCounter == ticTacToeGrid.length - 1) {
                        System.out.println("Game Over! " + ticTacToeGrid[i][j] + " Won by getting " +
                                ticTacToeGrid.length + " in a column!");
                        return true;
                    }
                }
            }
        }

        //checks for consecutive in a row, loops down grid
        for (int i = 0; i <= ticTacToeGrid.length - 1; i++) {
            int inARowCounter = 0;

            //loops across the grid
            for (int j = 0; j <= ticTacToeGrid[i].length - 2; j++) {

                //increments whenever the Strings match
                if (ticTacToeGrid[i][j].equals(ticTacToeGrid[i][j + 1]) && !ticTacToeGrid[i][j].equals("_")) {
                    inARowCounter++;

                    //if it matches as many times as it loops, that's "in a row"
                    if (inARowCounter == ticTacToeGrid[i].length - 1) {
                        System.out.println("Game Over! " + ticTacToeGrid[i][j] + " Won by getting " +
                                ticTacToeGrid[i].length + " in a row!");
                        return true;
                    }
                }
            }
        }

        for (int j = 0; j <1; j++) {
            int counter = 0;
            for (int i = 0; i <= ticTacToeGrid.length - 2; i++) {
                if (ticTacToeGrid[i][i].equals(ticTacToeGrid[i + 1][i + 1]) && !ticTacToeGrid[i][i].equals("_")) {
                    counter++;
                    if (counter == ticTacToeGrid.length - 1) {
                        System.out.println("Game Over! " + ticTacToeGrid[i][i] + " Won by getting " +
                                ticTacToeGrid.length + " in a backwards diagonal!");
                        return true;
                    }
                }
            }
        }

        for (int j = 0; j <1; j++) {
            int counter = 0;
            int row =2;
            for (int column = 0; column < 2; column++){
                if (ticTacToeGrid[row][column].equals(ticTacToeGrid[row-1][column+1]) && !ticTacToeGrid[row][column].equals("_")){
                    counter ++;
                    if (counter == ticTacToeGrid.length - 1) {
                        System.out.println("Game Over! " + ticTacToeGrid[row][column] + " Won by getting " +
                                ticTacToeGrid.length + " in a forwards diagonal!");
                        return true;
                    }
                    row--;
                }
            }


        }
        return false;
    }

    public void printGrid() {
        for (int r = 0; r < _rows; r++) {
            for (int c = 0; c < _columns; c++) {
                System.out.print("|" + ticTacToeGrid[r][c]);
            }
            System.out.print("|\n");
        }
    }

}