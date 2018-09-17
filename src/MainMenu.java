import java.util.Scanner;

public class MainMenu {

    //MainMenu is static and is always the same, to be as generic as possible

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

    public static void helloScreen() {
        System.out.println("====================" +
                "\n" + "Tic-Tac-Toe \n(N)ew game (Q)uit\n" +
                "====================");
    }
}