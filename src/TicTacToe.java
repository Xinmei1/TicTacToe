import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        //Prompt for starting Tic-Tac-Toe game
        String startGame = MainMenu.newGame();

        //Starting Tic-Tac-Toe game
        while (startGame.equals("Y")) {

            System.out.println("How many rows?");
            Scanner scanner = new Scanner(System.in);
            int rows = scanner.nextInt();
            System.out.println("How many columns?");
            int columns = scanner.nextInt();

            //Generates a new object from the MyGrid class, resets grid
            MyGrid PlayerGrid = new MyGrid(columns, rows);
            //initializes the Array's elements with spaces
            PlayerGrid.setGrid();
            //load board state of the object PlayerGrid
            PlayerGrid.getGrid();

            //loop for playing TicTacToe
            int i = 0;
            //Initializes quit game to be not quit
            String quitStatus = "NQ";

            //keeps going while you have not won, or NOT quit
            while (i < 999 && !((quitStatus.equals("Q") || (quitStatus.equals("N"))))) {

                //Generic Header with menu options

                MainMenu.helloScreen();

                Scanner scanner1 = new Scanner(System.in);

                System.out.println("X or O?");
                String xOrO = scanner1.nextLine().toUpperCase();

                if (xOrO.equals("Q")) {
                    break;
                }

                System.out.println("Which row?");
                int userRow = scanner1.nextInt();

                System.out.println("Which column?");
                int userColumn = scanner1.nextInt();


                PlayerGrid.setUserInput(userColumn - 1, userRow - 1, xOrO);

                PlayerGrid.getGrid();

                //checks if object PlayerGrid's field variables have met it's winCondition method
                if (PlayerGrid.returnsWin()) {

                    //Generic Header with menu options
                    MainMenu.helloScreen();
                    //PlayerGrid object's print of it's current field variables, which is the game board
                    PlayerGrid.getGrid();

                    //static game over message from MyGrid class, not an instantiated object
                    MyGrid.printWin();

                    i = 999;
                }

            }

            //starts the game if user wanted a new game, and not just quit
            if (quitStatus.equals("N")) {
                startGame = "Y";
            }

            //Asks users to restart the game, if user quit, or game ended naturally in a win/loss
            else startGame = MainMenu.restartGame();
        }
    }
}
