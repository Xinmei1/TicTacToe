import java.util.Scanner;

public class MainMenu {

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

    public static void hasStarted(){
        System.out.println("\nNew Tic-Tac-Toe Game Started");
    }
}