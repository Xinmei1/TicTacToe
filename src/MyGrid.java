
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

        return false;
    }

    //Prints a generic String from a static method
    public static void printWin() {

    }
}