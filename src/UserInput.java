import java.util.Scanner;

public class UserInput {

    //region Region folding to hide field variables
    //declaration of field variables, for the Tic-Tac-Toe game
    private String _firstInput;
    private String _secondInput;
    private String _thirdInput;
    //endregion

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
        if (_firstInput.equals("Q")||_firstInput.equals("N")){

            if (_firstInput.equals("Q")) {
                System.out.println("You just quit the game");
            }
            else if (_firstInput.equals("N")){
                System.out.println("You just started a new game");
            }
            //clears second input and third input so the getter returns only "Q"
            _secondInput="";
            _thirdInput="";

            //returns out of the method. do not use break, that only breaks out of the loop
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
