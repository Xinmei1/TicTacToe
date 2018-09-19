
public class MyGrid {

    private int _columns;
    private int _rows;
    private String[][] ticTacToeGrid;

    //_lastInput used to tell who won
    private String _lastInput;

    //MyGrid constructor
    public MyGrid() {

    }

    public void setSafeGrid(int columns, int rows) {

        if (!(columns == rows)) {
            throw new IllegalArgumentException("Rows must equal columns");
        }

        _columns = columns;
        _rows = rows;

        ticTacToeGrid = new String[_columns][_rows];

        for (int c = 0; c < _columns; c++) {
            for (int r = 0; r < _rows; r++) {
                ticTacToeGrid[c][r] = "_";
            }
        }
    }

    public void setGrid(int columns, int rows) {

        _columns = columns;
        _rows = rows;

        ticTacToeGrid = new String[_columns][_rows];

        for (int c = 0; c < _columns; c++) {
            for (int r = 0; r < _rows; r++) {
                ticTacToeGrid[c][r] = "_";
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
        ticTacToeGrid[column][row] = xOrO;
        _lastInput = xOrO;
    }

    public void getGrid() {
        for (int r = 0; r < _rows; r++) {
            for (int c = 0; c < _columns; c++) {
                System.out.print("|" + ticTacToeGrid[c][r]);
            }
            System.out.print("|\n");
        }
    }

    public boolean returnsWin() {


        for (int j = 0; j < ticTacToeGrid.length-1 ; j++) {

            //winCheckCounter to check "in a column"
            int inAColumnCounter = 0;

            for (int i = 0; i < ticTacToeGrid.length-1 ; i++) {

                if (!ticTacToeGrid[j][i].equals("_")) {

                    //keeps looping till the entire length of the Array
                    if (ticTacToeGrid[j][i].equals(ticTacToeGrid[j][i + 1])) {

                        //increments whenever the Strings match
                        inAColumnCounter++;

                        //if it matches as many times as it loops, that's "in a column"
                        if (inAColumnCounter == ticTacToeGrid[0].length - 1) {
                            return true;
                        }
                    }
                }
            }
        }

        for (int outer = 0; outer < ticTacToeGrid.length-1 ; outer++) {

            //winCheckCounter to check "in a row"
            int inARowCounter = 0;

            for (int inner = 0; inner < ticTacToeGrid.length-1 ; inner++) {

                if (!ticTacToeGrid[inner][outer].equals("_")) {

                    //keeps looping till the entire length of the Array
                    if (ticTacToeGrid[inner][outer].equals(ticTacToeGrid[inner + 1][outer])) {

                        //increments whenever the Strings match
                        inARowCounter++;

                        //if it matches as many times as it loops, that's "in a row"
                        if (inARowCounter == ticTacToeGrid.length - 1) {
                            return true;
                        }
                    }
                }
            }
        }

        /* if a grid is 3x4, you only need 3 in a consecutive diagonal to win, or 4x3, you only need 3 to win.
         takes the lesser to win
         */

        int lessToWin = ticTacToeGrid.length;
        if (ticTacToeGrid[0].length < ticTacToeGrid.length) {
            lessToWin = ticTacToeGrid[0].length;
        }

        int DiagonalInARowCounter_bk = 0;
        for (int diag = 0; diag < lessToWin - 1; diag++) {

            if (!ticTacToeGrid[diag][diag].equals("_")) {

                //checks diagonal
                //keeps looping till the entire length of the Array
                if (ticTacToeGrid[diag][diag].equals(ticTacToeGrid[diag + 1][diag + 1])) {

                    //increments whenever the Strings match
                    DiagonalInARowCounter_bk++;

                    //if it matches as many times as it loops, that's "diagonal"
                    if (DiagonalInARowCounter_bk == ticTacToeGrid.length - 1 || DiagonalInARowCounter_bk > ticTacToeGrid.length - 1) {
                        return true;
                    }
                }
            }
        }

        int DiagonalInARowCounter_fd = 0;
        int rowIncrement = 0;

         /* if a grid is 3x4, you only need 3 in a consecutive diagonal to win, or 4x3, you only need 3 to win.
         takes the lesser to win
         */
        lessToWin = ticTacToeGrid.length;
        if (ticTacToeGrid[0].length < ticTacToeGrid.length) {
            lessToWin = ticTacToeGrid[0].length;
        }

        for (int columnDecrement = lessToWin - 1; columnDecrement > 0; --columnDecrement) {

            if (!ticTacToeGrid[columnDecrement][rowIncrement].equals("_")) {

                //checks backwards diagonal, keeps looping backwards from entire length of the Array to 0

                if (ticTacToeGrid[columnDecrement][rowIncrement].equals(ticTacToeGrid[columnDecrement - 1][rowIncrement + 1])) {

                    //increments whenever the Strings match
                    DiagonalInARowCounter_fd++;

                    //if it matches as many times as it loops, that's "backwards diagonal"
                    if (DiagonalInARowCounter_fd == ticTacToeGrid[0].length - 1 || DiagonalInARowCounter_fd > ticTacToeGrid[0].length - 1) {
                        return true;
                    }
                }
                rowIncrement++;
            }
        }

        return false;
    }

    public void printWin() {

        System.out.println("GAME OVER, " + _lastInput + " WON!\n");

    }
}