import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        //Prompt for starting Tic-Tac-Toe game
        String startGame = MainMenu.newGame();
        String xOrO = "";

        //Starting Tic-Tac-Toe game
        while (startGame.equals("Y")) {

            System.out.println("\nNew Tic-Tac-Toe Game Started");

            System.out.println("Setup: How many rows in this grid?");
            Scanner scanner = new Scanner(System.in);
            int rows = scanner.nextInt();
            System.out.println("Setup: How many columns in this grid?");
            int columns = scanner.nextInt();

            //Generates a new object from the MyGrid class, resets grid
            MyGrid PlayerGrid = new MyGrid(columns, rows);
            //initializes the Array's elements with spaces
            PlayerGrid.setGrid();
            //load board state of the object PlayerGrid
            PlayerGrid.getGrid();

            //loop for playing TicTacToe
            int i = 0;

            //keeps going while you have not won, or NOT quit
            while (i < 999) {

                //Generic Header with menu options

                MainMenu.helloScreen();

                Scanner scanner1 = new Scanner(System.in);

                System.out.println("X or O?");
                xOrO = scanner1.nextLine().toUpperCase();

                if (xOrO.equals("Q")) {
                    break;
                }
                if (xOrO.equals("N")) {
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

            //if User chose to Quit, then give them the choice to restart the game or end program
            if (xOrO.equals("Q")) {
                startGame = MainMenu.restartGame();

            }
        }
    }
}
