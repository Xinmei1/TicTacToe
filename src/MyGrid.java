
public class MyGrid {

    private int _columns;
    private int _rows;
    private String[][] ticTacToeGrid;
    private String _lastInput;

    //MyGrid constructor
    public MyGrid(int columns, int rows) {
        _columns = columns;
        _rows = rows;
        ticTacToeGrid = new String[_columns][_rows];
    }

    public void setGrid() {
        for (int c = 0; c < _columns; c++) {
            for (int r = 0; r < _rows; r++) {
                ticTacToeGrid[c][r] = "_";
            }
        }
    }

    public void setUserInput(int column, int row, String xOrO) {
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


        for (int j = 0; j < ticTacToeGrid.length - 1; j++) {

            //winCheckCounter to check "in a column"
            int counter = 0;

            for (int i = 0; i < ticTacToeGrid.length - 1; i++) {

                if (!ticTacToeGrid[j][i].equals("_")) {

                    //keeps looping till the entire length of the Array
                    if (ticTacToeGrid[j][i].equals(ticTacToeGrid[j][i + 1])) {

                        //increments whenever the Strings match
                        counter++;

                        //if it matches as many times as it loops, that's "in a column"
                        if (counter == ticTacToeGrid.length - 1) {
                            return true;
                        }
                    }
                }
            }
        }

        for (int outer = 0; outer < ticTacToeGrid.length - 1; outer++) {

            //winCheckCounter to check "in a row"
            int counter = 0;

            for (int inner = 0; inner < ticTacToeGrid.length - 1; inner++) {

                if (!ticTacToeGrid[inner][outer].equals("_")) {

                    //keeps looping till the entire length of the Array
                    if (ticTacToeGrid[inner][outer].equals(ticTacToeGrid[inner + 1][outer])) {

                        //increments whenever the Strings match
                        counter++;

                        //if it matches as many times as it loops, that's "in a row"
                        if (counter == ticTacToeGrid.length - 1) {
                            return true;
                        }
                    }
                }
            }
        }

        int winCheckCounter = 0;
        for (int diag = 0; diag < ticTacToeGrid.length - 1; diag++) {

            if (!ticTacToeGrid[diag][diag].equals("_")) {

                //checks diagonal
                //keeps looping till the entire length of the Array
                if (ticTacToeGrid[diag][diag].equals(ticTacToeGrid[diag + 1][diag + 1])) {

                    //increments whenever the Strings match
                    winCheckCounter++;

                    //if it matches as many times as it loops, that's "diagonal"
                    if (winCheckCounter == ticTacToeGrid.length - 1 || winCheckCounter > ticTacToeGrid.length - 1) {
                        return true;
                    }
                }
            }
        }

        winCheckCounter = 0;
        int rowIncrement = 0;

        for (int columnDecrement = ticTacToeGrid.length - 1; columnDecrement > 0; --columnDecrement) {


            if (!ticTacToeGrid[columnDecrement][rowIncrement].equals("_")) {

                //checks backwards diagonal, keeps looping backwards from entire length of the Array to 0

                if (ticTacToeGrid[columnDecrement][rowIncrement].equals(ticTacToeGrid[columnDecrement - 1][rowIncrement + 1])) {

                    //increments whenever the Strings match
                    winCheckCounter++;

                    //if it matches as many times as it loops, that's "backwards diagonal"
                    if (winCheckCounter == ticTacToeGrid.length - 1 || winCheckCounter > ticTacToeGrid.length - 1) {
                        return true;
                    }
                }
                rowIncrement++;
            }
        }

        return false;
    }

    public void printWin() {

        System.out.println("GAME OVER, "+ _lastInput +" WON!\n");

    }
}