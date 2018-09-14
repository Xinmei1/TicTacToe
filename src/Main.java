
public class Main {

    public static void main(String[] args) {

        String startgame = MainMenu.newGame();

        //Menu for restarting TicTacToe
        while (startgame.equals("Y")) {

            //Generates a new object from the UserInput class
            UserInput PlayerOneInput = new UserInput();

            //Generates a new object from the MyGrid class, the Game State should be reset at every new game
            MyGrid PlayerGrid = new MyGrid();

            //loop for playing TicTacToe
            int i = 0;

            while (i < 9) {

                //Header with menu options
                MainMenu.helloScreen();

                //load board state
                PlayerGrid.printGrid();

                //sets input
                PlayerOneInput.inputSetter();
                //change board state using user input
                PlayerGrid.setGrid(PlayerOneInput.inputGetter());

                //checks game over
                if (PlayerGrid.returnsWin()) {

                    //Header with menu options
                    MainMenu.helloScreen();

                    //load board state
                    PlayerGrid.printGrid();

                    //game over message
                    System.out.println("YOU WIN!" +
                            "\n\n-----GAME OVER-----\n");
                    i = 9;
                }
                i++;
            }
            startgame = MainMenu.restartGame();
        }
    }
}
