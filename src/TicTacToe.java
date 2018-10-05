public class TicTacToe {

    public static void main(String[] args) {

        String LoopGame = MainMenu.newGame();
        String xOrO="";
        boolean playing;

        while (LoopGame.equals("Y")) {

            MainMenu.hasStarted();
            int rows = MainMenu.setRows();
            int columns = MainMenu.setColumns();
            MyGrid PlayerGrid = new MyGrid(rows,columns);
            playing = true;
            PlayerGrid.printGrid();

            //Loops unless game ends, or User presses N or Q when prompted X or O
            while (playing) {

                MainMenu.screenHeader();

                xOrO = MainMenu.xOrO();

                if (xOrO.equals("Q")) {
                    break;
                }
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

                boolean didIWin = PlayerGrid.returnsWin();

                //checks if object PlayerGrid's field variables have met it's winCondition method
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
