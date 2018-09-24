import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        //Prompt for starting Tic-Tac-Toe game
        String startGame = MainMenu.newGame();
        String xOrO = "";
        int rows ;
        int columns ;
        boolean play;

        //Starting Tic-Tac-Toe game
        while (startGame.equals("Y")) {

            System.out.println("\nNew Tic-Tac-Toe Game Started");


            //System.out.println("Turn on symmetric grid creation? (Y/N)");

            Scanner scanner = new Scanner(System.in);

            //tracker to force row == column
            //String safeGrid = scanner.nextLine().toUpperCase();


            System.out.println("Setup: How many rows in this grid?");
            rows = scanner.nextInt();
            System.out.println("Setup: How many columns in this grid?");
            columns = scanner.nextInt();


            //Generates a new object from the MyGrid class, resets grid
            MyGrid PlayerGrid = new MyGrid();

            //checking if rows equals columns, because then the diagonal win condition checker doesn't know how many
            //consecutive it takes to win, the row, or the column?

            //if (safeGrid.equals("Y")) {
            //
            //    try {
            //PlayerGrid.setSafeGrid(rows, columns);
            //        play = true;
                    //load board state of the object PlayerGrid
            //        PlayerGrid.getGrid();
            //
            //    } catch (IllegalArgumentException ex) {
            //        System.out.println(ex.getMessage());
            //    }
            //
            //} else {
                PlayerGrid.setGrid(rows, columns);
                play = true;
                //load board state of the object PlayerGrid
                PlayerGrid.getGrid();
            //}

            //Loops unless Game Over, or User presses N or Q
            while (play) {

                //Generic Header with menu options

                MainMenu.helloScreen();

                Scanner scanner1 = new Scanner(System.in);

                System.out.println("X or O? or (N)/(Q)");
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

                try {
                    PlayerGrid.setUserInput(userColumn - 1, userRow - 1, xOrO);
                }
                //Won't let user enter a spot already filled, and won't let user place x or o outside of grid boundaries
                catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
                    System.out.println(ex.getMessage());
                }

                PlayerGrid.getGrid();

                PlayerGrid.returnsWin();

                //checks if object PlayerGrid's field variables have met it's winCondition method
                if (PlayerGrid.returnsWin()) {

                    //static game over message from MyGrid class, not an instantiated object
                    PlayerGrid.printWin();

                    play = false;
                    startGame = MainMenu.restartGame();
                }
            }

            //if User chose to Quit, then give them the choice to restart the game or end program
            if (xOrO.equals("Q")) {
                startGame = MainMenu.restartGame();
            }
        }
    }
}
