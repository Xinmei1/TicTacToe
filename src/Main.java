
public class Main {

    public static void main(String[] args) {

        //Prompt for starting Tic-Tac-Toe game
        String startgame = MainMenu.newGame();

        //Starting Tic-Tac-Toe game
        while (startgame.equals("Y")) {

            //Initializes quit game to be not quit
            String quitStatus = "NQ";

            //Generates a new object from the UserInput class, resets user input
            UserInput PlayerOneInput = new UserInput();

            //Generates a new object from the MyGrid class, resets grid
            MyGrid PlayerGrid = new MyGrid();

            //loop for playing TicTacToe
            int i = 0;

            //keeps going while you have not won, or NOT quit
            while (i < 999 && !((quitStatus.equals("Q")||(quitStatus.equals("N"))))) {

                //Generic Header with menu options
                MainMenu.helloScreen();

                //load board state of the object PlayerGrid
                PlayerGrid.printGrid();

                //sets input of the object PlayerOneInput
                PlayerOneInput.inputSetter();
                //change Object PlayerGrid's (board state)/(field variables) using user input
                PlayerGrid.setGrid(PlayerOneInput.inputGetter());
                //checks player has not quit, and updates loop conditions
                quitStatus = PlayerOneInput.inputGetter();

                //checks if object PlayerGrid's field variables have met it's wincondition method
                if (PlayerGrid.returnsWin()) {

                    //Generic Header with menu options
                    MainMenu.helloScreen();
                    //PlayerGrid object's print of it's current field variables, which is the game board
                    PlayerGrid.printGrid();

                    //static game over message from MyGrid class, not an instantiated object
                    MyGrid.printWin();

                    i = 999;
                }
                i++;
            }

            //starts the game if user wanted a new game, and not just quit
            if (quitStatus.equals("N")){
                startgame = "Y";
            }
            //Asks users to restart the game, if user quit, or game ended naturally in a win/loss
            else startgame = MainMenu.restartGame();
        }
    }
}
