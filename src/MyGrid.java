public class MyGrid {

    //<editor-fold desc="Field Variable Declarations">
    private String _userInput;
    private String _r1c1;
    private String _r1c2;
    private String _r1c3;
    private String _r2c1;
    private String _r2c2;
    private String _r2c3;
    private String _r3c1;
    private String _r3c2;
    private String _r3c3;
    private String _finalGrid;
    //</editor-fold>

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

    public void setGrid(String playerinput) {

        //commented this to test out
        // multiple branching. master should not have this,
        // betterwinlogic branch should not have this

        if (playerinput.equals("X11")) {
            this._r1c1 = "X";
        } else if (playerinput.equals("X12")) {
            this._r1c2 = "X";
        } else if (playerinput.equals("X13")) {
            this._r1c3 = "X";
        } else if (playerinput.equals("X21")) {
            this._r2c1 = "X";
        } else if (playerinput.equals("X22")) {
            this._r2c2 = "X";
        } else if (playerinput.equals("X23")) {
            this._r2c3 = "X";
        } else if (playerinput.equals("X31")) {
            this._r3c1 = "X";
        } else if (playerinput.equals("X32")) {
            this._r3c2 = "X";
        } else if (playerinput.equals("X33")) {
            this._r3c3 = "X";
        } else if (playerinput.equals("O11")) {
            this._r1c1 = "O";
        } else if (playerinput.equals("O12")) {
            this._r1c2 = "O";
        } else if (playerinput.equals("O13")) {
            this._r1c3 = "O";
        } else if (playerinput.equals("O21")) {
            this._r2c1 = "O";
        } else if (playerinput.equals("O22")) {
            this._r2c2 = "O";
        } else if (playerinput.equals("O23")) {
            this._r2c3 = "O";
        } else if (playerinput.equals("O31")) {
            this._r3c1 = "O";
        } else if (playerinput.equals("O32")) {
            this._r3c2 = "O";
        } else if (playerinput.equals("O33")) {
            this._r3c3 = "O";
        }

    }

    public void printGrid() {
        _finalGrid = _r1c1 + "|" + _r1c2 + "|" + _r1c3 + "\n" +
                _r2c1 + "|" + _r2c2 + "|" + _r2c3 + "\n" +
                _r3c1 + "|" + _r3c2 + "|" + _r3c3;

        System.out.println(_finalGrid);
    }

    // method for checking if the game is over or not
    public boolean returnsWin() {

        //checks the first row
        if (this._r1c1.equals(this._r1c2) && !this._r1c1.equals("_")) {
            return this._r1c1.equals(this._r1c3);

            //checks backwards diagonal
        }

        if (this._r1c1.equals(this._r2c2)) {
            return this._r1c1.equals(this._r3c3);


        } else if (this._r2c1.equals(this._r2c2) && !this._r2c2.equals("_") && !this._r2c2.equals("")) {
            if (this._r2c1.equals(this._r2c3)) {
                return true;
            }

        } else if (this._r3c1.equals(this._r3c2) && !this._r3c1.equals(" ")) {
            if (this._r3c1.equals(this._r3c3)) {
                return true;
            }

        } else if (this._r1c1.equals(this._r2c1) && !this._r1c1.equals("_")) {
            if (this._r1c1.equals(this._r3c1)) {
                return true;
            }

        } else if (this._r1c2.equals(this._r2c2) && !this._r1c2.equals("_")) {
            if (this._r1c2.equals(this._r3c2)) {
                return true;
            }

        } else if (this._r1c3.equals(this._r2c3) && !this._r1c3.equals("_")) {
            if (this._r1c3.equals(this._r3c3)) {
                return true;
            }

        } else if (this._r3c1.equals(this._r2c2) && !this._r3c3.equals("_") && !this._r3c3.equals("") && this._r2c2.equals(this._r1c3)) {
            return true;
        }

        return false;
    }


}
