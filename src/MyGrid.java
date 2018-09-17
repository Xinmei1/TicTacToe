import java.util.Arrays;

public class MyGrid {

    private int _columns;
    private int _rows ;
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
                ticTacToeGrid[c][r] = " ";
            }
        }
    }

    public void setUserInput(int column, int row, String xOrO){
        ticTacToeGrid[column][row] = xOrO;
    }

    public void getGrid() {
        for (int i = 0; i < _rows; i++) {
            System.out.println(Arrays.toString(ticTacToeGrid[i]));
        }
    }

    public boolean returnsWin() {
        return true;
    }

    //Prints a generic String from a static method
    public static void printWin() {

    }
}