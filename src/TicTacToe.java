public class TicTacToe {

    public static void main(String[] args) {

        String LoopGame = MainMenu.newGame();
        String xOrO = "";
        boolean playing;

        while (LoopGame.equals("Y")) {

            MainMenu.hasStarted();
            MyGrid PlayerGrid = new MyGrid();
            PlayerGrid.setRows(3);
            PlayerGrid.setColumns(3);
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

                //Won't let user enter a spot already filled or outside of grid boundaries
                try {
                    PlayerGrid.setUserInput(userRow - 1, userColumn - 1, xOrO);

                    if (xOrO.equals("O")){ PlayerGrid.computerMoveX();}
                    if (xOrO.equals("X")){PlayerGrid.computerMoveO();}
                }
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

            //if user quits, give the choice to restart or end program
            if (xOrO.equals("Q")) {
                LoopGame = MainMenu.restartGame();
            }
        }

    }
}
