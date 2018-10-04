
public class MyGrid {

    private int _columns;
    private int _rows;
    private String[][] ticTacToeGrid;

    //MyGrid constructor
    public MyGrid() {

    }

//   public void setSafeGrid(int columns, int rows) {

//       if (!(columns == rows)) {
//           throw new IllegalArgumentException("Rows must equal columns");
//       }

//       _columns = columns;
//       _rows = rows;

//       ticTacToeGrid = new String[_columns][_rows];

//       for (int c = 0; c < _columns; c++) {
//           for (int r = 0; r < _rows; r++) {
//               ticTacToeGrid[c][r] = "_";
//           }
//       }
//   }

    public void setGrid(int rows, int columns) {

        _rows = rows;
        _columns = columns;

        ticTacToeGrid = new String[_rows][_columns];

        for (int c = 0; c < _columns; c++) {
            for (int r = 0; r < _rows; r++) {
                ticTacToeGrid[r][c] = "_";
            }
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

    public void getGrid() {
        for (int r = 0; r < _rows; r++) {
            for (int c = 0; c < _columns; c++) {
                System.out.print("|" + ticTacToeGrid[r][c]);
            }
            System.out.print("|\n");
        }
    }

    public boolean returnsWin() {

        //checks for consecutive in a column
        //loops across grid
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

        //checks for consecutive in a row
        //loops down grid
        for (int i = 0; i <= ticTacToeGrid.length - 1; i++) {
            int inARowCounter = 0;

            //loops across the grid
            for (int j = 0; j <= ticTacToeGrid[0].length - 2; j++) {

                //increments whenever the Strings match
                if (ticTacToeGrid[i][j].equals(ticTacToeGrid[i][j + 1]) && !ticTacToeGrid[i][j].equals("_")) {
                    inARowCounter++;

                    //if it matches as many times as it loops, that's "in a row"
                    if (inARowCounter == ticTacToeGrid[0].length - 1) {
                        System.out.println("Game Over! " + ticTacToeGrid[i][j] + " Won by getting " +
                                ticTacToeGrid[0].length + " in a row!");
                        return true;
                    }
                }

            }
        }

        //Makes sure you can win, by making a backwards diagonal, even with an uneven grid (or even grid)
        //where the number of columns, is greater than the number of rows
        //if this is the case, you always will need a cell from the first row

        if (ticTacToeGrid.length >= ticTacToeGrid[0].length) {

            //do not loop further, or index out of bounds
            for (int i = 0; i <= (ticTacToeGrid[0].length - ticTacToeGrid.length); i++) {

                int bkDiagonalCounter = 0;

                for (int j = 0; j <= ticTacToeGrid[0].length; j++)
                    if (ticTacToeGrid[i][i].equals(ticTacToeGrid[i + 1][i + 1]) && !ticTacToeGrid[i][i].equals("_")) {
                        bkDiagonalCounter++;
                        System.out.println(bkDiagonalCounter);
                    }
            }

        }

        //Makes sure you can win, by making a backwards diagonal, even with an uneven grid
        //where the number of rows, is greater than the number of columns
        //if this is the case, you will always need a cell from the first column
        if (ticTacToeGrid[0].length > ticTacToeGrid.length) {

        }



        /*
        int DiagonalInARowCounter_fd = 0;
        int rowIncrement = 0;

         // if a grid is 3x4, you only need 3 in a consecutive diagonal to win, or 4x3, you only need 3 to win.
         takes the lesser to win

        lessToWin = ticTacToeGrid.length;
        if (ticTacToeGrid[0].length < ticTacToeGrid.length) {
            lessToWin = ticTacToeGrid[0].length;
        }

        for (
                int columnDecrement = lessToWin - 1;
                columnDecrement > 0; --columnDecrement) {

            if (!ticTacToeGrid[columnDecrement][rowIncrement].equals("_")) {

                //checks backwards diagonal, keeps looping backwards from entire length of the Array to 0

                if (ticTacToeGrid[columnDecrement][rowIncrement].equals(ticTacToeGrid[columnDecrement - 1][rowIncrement + 1])) {

                    //increments whenever the Strings match
                    DiagonalInARowCounter_fd++;
                    System.out.println("I am counting forward diagonal");

                    //if it matches as many times as it loops, that's "backwards diagonal"
                    if (DiagonalInARowCounter_fd == ticTacToeGrid[0].length - 1 || DiagonalInARowCounter_fd > ticTacToeGrid[0].length - 1) {
                        return true;
                    }
                }
                rowIncrement++;
            }
        }
*/
        return false;
    }

}