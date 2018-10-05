public class TicTacToe {

    public static void main(String[] args) {

        String LoopGame = MainMenu.newGame();
        String xOrO = "";
        boolean playing;

        while (LoopGame.equals("Y")) {

            MainMenu.hasStarted();
            MyGrid PlayerGrid = new MyGrid();
            PlayerGrid.setRows();
            PlayerGrid.setColumns();
            PlayerGrid.setBlankGrid();
            PlayerGrid.printGrid();
            playing = true;

            while (playing) {

                MainMenu.screenHeader();

                xOrO = MainMenu.xOrO();

                //quits
                if (xOrO.equals("Q")) {
                    break;
                }
                //new game
                if (xOrO.equals("N")) {
                    break;
                }

                int userRow = MainMenu.whichRow();
                int userColumn = MainMenu.whichColumn();

                try {
                    PlayerGrid.setUserInput(userRow - 1, userColumn - 1, xOrO);
                }

                //Won't let user enter a spot already filled, and won't let user place x or o outside of grid boundaries
                catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
                    System.out.println(ex.getMessage());
                }

                PlayerGrid.printGrid();

                //if someone wins, ask to restart game
                boolean didIWin = PlayerGrid.returnsWin();
                if (didIWin) {
                    playing = false;
                    LoopGame = MainMenu.restartGame();
                }
            }

            //if User chose to Quit, then give them the choice to restart the game or end program
            if (xOrO.equals("Q")) {
                LoopGame = MainMenu.restartGame();
            }
        }
    }
}
