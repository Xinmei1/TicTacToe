import java.util.Scanner;

public class MainMenu {

//All functions that return stuff

    public static String newGame() {
        System.out.println("\nCommand Line Application\n" +
                "Tic-Tac-Toe\n" +
                "\nStart New Game?" +
                "\n(Y)es / (N)o");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toUpperCase();
    }

    public static String restartGame() {
        System.out.println("Restart Tic-Tac-Toe game? (Y)es /(N)o");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toUpperCase();
    }

    public static int setRows() {
        System.out.println("Setup: How many rows in this grid?");
        int choice = 0;
        String input;

        Scanner scanner = new Scanner(System.in);

        boolean notAnInteger = true;
        while (notAnInteger) {

            input = scanner.next();

            try {
                choice = Integer.parseInt(input);
                notAnInteger = false;

            } catch (Exception e) {
                System.out.println("Not an integer");
            }
        }

        return choice;
    }

    public static int setColumns() {
        System.out.println("Setup: How many columns in this grid?");

        int choice = 0;
        String input;

        Scanner scanner = new Scanner(System.in);

        boolean notAnInteger = true;
        while (notAnInteger) {

            input = scanner.next();

            try {
                choice = Integer.parseInt(input);
                notAnInteger = false;

            } catch (Exception e) {
                System.out.println("Not an integer");
            }
        }

        return choice;
    }

    public static String xOrO() {
        System.out.println("X or O? or (N)/(Q)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toUpperCase();
    }

    public static int whichRow() {
        System.out.println("Which row?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int whichColumn() {
        System.out.println("Which column?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

//All functions that do nothing but prints a String

    public static void hasStarted() {
        System.out.println("\nNew Tic-Tac-Toe Game has Started");
    }

    public static void screenHeader() {
        System.out.println("====================" +
                "\n" + "Tic-Tac-Toe \n(N)ew game (Q)uit\n" +
                "====================");
    }

}