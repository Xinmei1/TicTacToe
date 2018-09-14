import java.util.Scanner;

public class MainMenu {

    public static String NewGame() {
        System.out.println("\nCommand Line Application Game\n" +
                "Tic-Tac-Toe\n" +
                "\nStart New Game?\n(Y)es /(N)o");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toUpperCase();
    }

    public static String RestartGame(){
        System.out.println("Restart Tic-Tac-Toe game? (Y)es /(N)o");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toUpperCase();
    }

    public static void helloScreen(){
        System.out.println("========================" +
                "\n" + "Welcome to Tic Tac Toe \nStarting New Game\n" +
                "========================\nPlease select");
    }
}