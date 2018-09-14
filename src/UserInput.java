import java.util.Scanner;

public class UserInput {

    //declaration of field variables, for the Tic-Tac-Toe game
    private String _firstInput;
    private String _secondInput;
    private String _thirdInput;

    //initializing field variables values inside constructor
    public UserInput() {
        _firstInput = "";
        _secondInput = "";
        _thirdInput = "";
    }

    public void inputSetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select\nX or O?");
        _firstInput = scanner.nextLine().toUpperCase();
        System.out.println("Row 1 2 or 3?");
        _secondInput = scanner.nextLine();
        System.out.println("column 1 2 or 3?");
        _thirdInput = scanner.nextLine();
    }

    public String inputGetter() {
        return _firstInput + _secondInput + _thirdInput;
    }

}
