
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

                //Prints out a new screen for TicTacToe game
                MainMenu.helloScreen();
                PlayerGrid.printGrid();

                PlayerOneInput.inputSetter();
                String inputXO = PlayerOneInput.inputGetter();

                //changes one field variable of MyGrid every time the user inputs another String
                PlayerGrid.setGrid(inputXO);

                //checks if the grid's win condition is fulfilled
                //tests if there is 3 in a row or not
                if (PlayerGrid.returnsWin()) {

                    MainMenu.helloScreen();
                    PlayerGrid.printGrid();

                    System.out.println("\nYOU WIN! GOOD JOB!"+
                            "\n-------GAME OVER-------");
                    i = 9;
                }


                i++;
            }

            startgame = MainMenu.restartGame();

        }

    }

}
