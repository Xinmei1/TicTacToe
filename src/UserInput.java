import java.util.Scanner;

public class UserInput {

    private String _firstInput;
    private String _secondInput;
    private String _thirdInput;

    public UserInput() {
        _firstInput = "";
        _secondInput = "";
        _thirdInput = "";

    }

    public String inputGetter() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("X or O?");
        _firstInput = scanner.nextLine().toUpperCase();
        System.out.println("Row 1 2 or 3?");
        _secondInput = scanner.nextLine();
        System.out.println("column 1 2 or 3?");
        _thirdInput = scanner.nextLine();

        return _firstInput + _secondInput + _thirdInput;
    }

}
