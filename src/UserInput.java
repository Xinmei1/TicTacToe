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

        //breaks out of loop if user types in Q, which is the status for quit playing
        if (_firstInput.equals("Q")){
            System.out.println("You just quit the game");
            //clears secondinut and thirdinput so the getter returns only "Q"
            _secondInput="";
            _thirdInput="";
            return;
        }
        System.out.println("Row 1 2 or 3?");
        _secondInput = scanner.nextLine();
        System.out.println("column 1 2 or 3?");
        _thirdInput = scanner.nextLine();
    }

    public String inputGetter() {
        return _firstInput + _secondInput + _thirdInput;
    }
}
