public class MyGrid {

    //<editor-fold desc="Field Variable Declarations">
    private String _r1c1;
    private String _r1c2;
    private String _r1c3;
    private String _r2c1;
    private String _r2c2;
    private String _r2c3;
    private String _r3c1;
    private String _r3c2;
    private String _r3c3;
    //</editor-fold>

    //MyGrid constructor
    public MyGrid() {

        _r1c1 = "_";
        _r1c2 = "_";
        _r1c3 = "_";
        _r2c1 = "_";
        _r2c2 = "_";
        _r2c3 = "_";
        _r3c1 = " ";
        _r3c2 = " ";
        _r3c3 = " ";

    }

    //Changes field values of grid based on player's input
    public void setGrid(String playerInput) {

        if (playerInput.equals("X11")) {
            this._r1c1 = "X";
        } else if (playerInput.equals("X12")) {
            this._r1c2 = "X";
        } else if (playerInput.equals("X13")) {
            this._r1c3 = "X";
        } else if (playerInput.equals("X21")) {
            this._r2c1 = "X";
        } else if (playerInput.equals("X22")) {
            this._r2c2 = "X";
        } else if (playerInput.equals("X23")) {
            this._r2c3 = "X";
        } else if (playerInput.equals("X31")) {
            this._r3c1 = "X";
        } else if (playerInput.equals("X32")) {
            this._r3c2 = "X";
        } else if (playerInput.equals("X33")) {
            this._r3c3 = "X";
        } else if (playerInput.equals("O11")) {
            this._r1c1 = "O";
        } else if (playerInput.equals("O12")) {
            this._r1c2 = "O";
        } else if (playerInput.equals("O13")) {
            this._r1c3 = "O";
        } else if (playerInput.equals("O21")) {
            this._r2c1 = "O";
        } else if (playerInput.equals("O22")) {
            this._r2c2 = "O";
        } else if (playerInput.equals("O23")) {
            this._r2c3 = "O";
        } else if (playerInput.equals("O31")) {
            this._r3c1 = "O";
        } else if (playerInput.equals("O32")) {
            this._r3c2 = "O";
        } else if (playerInput.equals("O33")) {
            this._r3c3 = "O";
        }
    }

    //print the current state of the grid
    public void printGrid() {

        System.out.println("\n" + _r1c1 + "|" + _r1c2 + "|" + _r1c3 + "\n" +
                _r2c1 + "|" + _r2c2 + "|" + _r2c3 + "\n" +
                _r3c1 + "|" + _r3c2 + "|" + _r3c3 + "\n");
    }

    //checks if the win conditions are met, 3 in a row, 3 in a column, 3 in a diagonal, forward and back
    public boolean returnsWin() {

        // First Row, but exclude underscore
        if (_r1c1.equals(_r1c2) && (_r1c1.equals(_r1c3) && !(_r1c1.equals("_"))))
            return true;
        else { // Second Row, but exclude underscore
            if (_r2c1.equals(_r2c2) && _r2c1.equals(_r2c3) && !(_r2c1.equals("_")))
                return true;
            else { // Third Row, but exclude empty
                if (_r3c1.equals(_r3c2) && _r3c1.equals(_r3c3) && !(_r3c1.equals(" ")))
                    return true;
                else { // First Column
                    if (_r1c1.equals(_r2c1) && _r1c1.equals(_r3c1))
                        return true;
                    else { // Second Column
                        if (_r1c2.equals(_r2c2) && _r2c2.equals(_r3c2))
                            return true;
                        else { // Third Column
                            if (_r1c3.equals(_r2c3) && _r1c3.equals(_r3c3))
                                return true;
                            else { //test diagonal 1, backslash
                                if (_r1c1.equals(_r2c2) && _r1c1.equals(_r3c3))
                                    return true;
                                else { // tests diagonal 2, forward slash
                                    if (_r1c3.equals(_r2c2) && _r1c3.equals(_r3c1))
                                        return true;
                                    else return false;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //Print a generic string from a static method
    public static void printWin() {
        System.out.println("YOU WIN!" +
                "\n\n-----GAME OVER-----\n");
    }
}