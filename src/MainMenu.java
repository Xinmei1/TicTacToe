import java.util.Scanner;

public class MainMenu {

    public static String returnNewGame() {

        System.out.println("New Game (Tic-Tac-Toe)? (Y)es /(N)o");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toUpperCase();

    }

    public static String returnRestartGame(){
        System.out.println("Restart Tic-Tac-Toe game? (Y)es /(N)o");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toUpperCase();
    }
}