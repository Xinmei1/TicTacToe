
public class MyGrid {

    private int _columns;
    private int _rows;
    private String[][] ticTacToeGrid;

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

            //counter to check "in a row"
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

        return false;

    }

    //Prints a generic String from a static method
    public static void printWin() {
        System.out.println("GAME OVER, SOMEBODY WON!");

    }
}