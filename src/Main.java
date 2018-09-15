
public class Main {

    public static void main(String[] args) {

        //Prompt for starting Tic-Tac-Toe game
        String startgame = MainMenu.newGame();

        //Starting Tic-Tac-Toe game
        while (startgame.equals("Y")) {

            //Initializes quitgame to be not quit
            String quitStatus = "NQ";

            //Generates a new object from the UserInput class, resets user input
            UserInput PlayerOneInput = new UserInput();

            //Generates a new object from the MyGrid class, resets grid
            MyGrid PlayerGrid = new MyGrid();

            //loop for playing TicTacToe
            int i = 0;

            //keeps going while you have not won, or NOT quit
            while (i < 999 && !(quitStatus.equals("Q"))) {

                //Header with menu options
                MainMenu.helloScreen();

                //load board state
                PlayerGrid.printGrid();

                //sets input
                PlayerOneInput.inputSetter();
                //change board state using user input
                PlayerGrid.setGrid(PlayerOneInput.inputGetter());
                //checks player has not quit
                quitStatus = PlayerOneInput.inputGetter();

                //checks game over
                if (PlayerGrid.returnsWin()) {

                    //Header with menu options
                    MainMenu.helloScreen();
                    //load board state
                    PlayerGrid.printGrid();

                    //game over message
                    MyGrid.printWin();

                    i = 999;
                }
                i++;
            }
            startgame = MainMenu.restartGame();
        }
    }
}
