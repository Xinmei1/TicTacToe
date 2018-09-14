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

        System.out.println("\n" + _r1c1 + "|" + _r1c2 + "|" + _r1c3 + "\n" +
                _r2c1 + "|" + _r2c2 + "|" + _r2c3 + "\n" +
                _r3c1 + "|" + _r3c2 + "|" + _r3c3 + "\n");
    }

    public boolean returnsWin() {

        //checks the first square for win condition
        if (this._r1c1.equals(this._r1c2) && !this._r1c1.equals("_")) {
            return this._r1c1.equals(this._r1c3);
        }

        //checks backwards diagonal
        else if (this._r1c1.equals(this._r2c2)) {
            return this._r1c1.equals(this._r3c3);
        }

        //checks second column
        else if (this._r2c1.equals(this._r2c2) && !this._r2c2.equals("_") && !this._r2c2.equals("")) {
            return this._r2c1.equals(this._r2c3);

        }

        //checks third row
        else if (this._r3c1.equals(this._r3c2) && !this._r3c1.equals(" ")) {
            return this._r3c1.equals(this._r3c3);

        } else if (this._r1c1.equals(this._r2c1) && !this._r1c1.equals("_")) {
            return this._r1c1.equals(this._r3c1);

        } else if (this._r1c2.equals(this._r2c2) && !this._r1c2.equals("_")) {
            return this._r1c2.equals(this._r3c2);

        } else if (this._r1c3.equals(this._r2c3) && !this._r1c3.equals("_")) {
            return this._r1c3.equals(this._r3c3);

        } else
            return this._r3c1.equals(this._r2c2) && !this._r3c3.equals("_") && !this._r3c3.equals("") && this._r2c2.equals(this._r1c3);
    }
}
