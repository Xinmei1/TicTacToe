
public class MyGrid {

    private int _columns;
    private int _rows;
    private String[][] ticTacToeGrid;

    //_lastInput used to tell who won
    private String _lastInput;

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

    public void setGrid(int columns, int rows) {

        _columns = columns;
        _rows = rows;

        ticTacToeGrid = new String[_rows][_columns];

        for (int c = 0; c < _columns; c++) {
            for (int r = 0; r < _rows; r++) {
                ticTacToeGrid[r][c] = "_";
            }
        }
    }

    public void setUserInput(int column, int row, String xOrO) {
        if (column >= _columns || row >= _rows) {
            throw new ArrayIndexOutOfBoundsException("Coordinates outside of grid created! Try again!");
        }
        if (!(xOrO.equals("X") || xOrO.equals("O"))) {
            throw new IllegalArgumentException("Please input only X and O");
        }
        if (ticTacToeGrid[column][row].equals("O") || ticTacToeGrid[column][row].equals("X")) {
            throw new IllegalArgumentException("That spot is already taken! Try again!");
        }

        //this is how indexing works?
        ticTacToeGrid[row][column] = xOrO;
        _lastInput = xOrO;
    }

    public void getGrid() {
        for (int c = 0; c < _columns; c++) {
            for (int r = 0; r < _rows; r++) {
                System.out.print("|" + ticTacToeGrid[r][c]);
            }
            System.out.print("|\n");
        }
    }

    public boolean returnsWin() {

        //<editor-fold desc="consecutive in a column">
        //winCheckCounter to check "in a column"
        int inAColumnCounter = 0;

        //This loop will loop the row by row, Consecutive in a column
        for (int j = 0; j < ticTacToeGrid.length - 1; j++) {

            System.out.println("loop j");

            //this loop will loop through the columns
            for (int i = 0; i < ticTacToeGrid[0].length - 1; i++) {

                System.out.println("loop i");


                //keeps looping till the entire length of the Array
                if (ticTacToeGrid[i][j].equals(ticTacToeGrid[i][j + 1])) {

                    System.out.println("in a column match");

                    inAColumnCounter++;

                    System.out.println("I am counting N consecutive in a column");

                    //if it matches as many times as it loops, that's "in a column"
                    if (!ticTacToeGrid[i][j].equals("_")) {

                        if (inAColumnCounter == ticTacToeGrid[0].length - 1) {
                            System.out.println("Game Over! " + ticTacToeGrid[j][i] + " Won by getting " +
                                    ticTacToeGrid[0].length + " in a column!");
                            return true;
                        }
                    }
                }
            }
        }

        //</editor-fold>

        //<editor-fold desc="Consecutive in a row">
        for (int outer = 0; outer < ticTacToeGrid.length - 1; outer++) {

            //winCheckCounter to check "in a row"
            int inARowCounter = 0;

            for (int inner = 0; inner < ticTacToeGrid.length - 1; inner++) {


                //keeps looping till the entire length of the Array
                if (ticTacToeGrid[inner][outer].equals(ticTacToeGrid[inner + 1][outer])) {


                    if (!ticTacToeGrid[inner][outer].equals("_")) {


                        //increments whenever the Strings match
                        inARowCounter++;
                        System.out.println("I am counting rows");

                        //if it matches as many times as it loops, that's "in a row"
                        if (inARowCounter == ticTacToeGrid.length - 1) {
                            return true;
                        }
                    }
                }
            }
        }
        //</editor-fold>

        //<editor-fold desc="Backwards Diagonal">
        /* if a grid is 3x4, you only need 3 in a consecutive diagonal to win, or 4x3, you only need 3 to win.
         takes the lesser to win
         */

        int lessToWin = ticTacToeGrid.length;
        if (ticTacToeGrid[0].length < ticTacToeGrid.length) {
            lessToWin = ticTacToeGrid[0].length;
        }

        int DiagonalInARowCounter_bk = 0;
        for (
                int diag = 0;
                diag < lessToWin - 1; diag++) {

            if (!ticTacToeGrid[diag][diag].equals("_")) {

                //checks diagonal
                //keeps looping till the entire length of the Array
                if (ticTacToeGrid[diag][diag].equals(ticTacToeGrid[diag + 1][diag + 1])) {

                    //increments whenever the Strings match
                    DiagonalInARowCounter_bk++;
                    System.out.println("i am counting backwards diagonal");

                    //if it matches as many times as it loops, that's "diagonal"
                    if (DiagonalInARowCounter_bk == ticTacToeGrid.length - 1 || DiagonalInARowCounter_bk > ticTacToeGrid.length - 1) {
                        return true;
                    }
                }
            }
        }
        //</editor-fold>

        //region Forward Diagonal
        int DiagonalInARowCounter_fd = 0;
        int rowIncrement = 0;

         /* if a grid is 3x4, you only need 3 in a consecutive diagonal to win, or 4x3, you only need 3 to win.
         takes the lesser to win
         */
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
        //endregion

        return false;
    }

    public void printWin() {

        System.out.println("GAME OVER, " + _lastInput + " WON!\n");

    }
}