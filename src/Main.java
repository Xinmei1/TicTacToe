public class Main {

    public static void main(String[] args) {

        //Generates a new object from the MyGrid class
        MyGrid PlayerGrid = new MyGrid();

        //Generates a new object from the UserInput class
        UserInput PlayerOneInput = new UserInput();

        //loop for playing TicTacToe
        int i = 0;

        while (i < 9) {

            //invoke input getter from the input class, returns a string
            String inputXO = PlayerOneInput.inputGetter();
            //changes one field variable of MyGrid every time the user inputs another String
            PlayerGrid.setGrid(inputXO);

            //print updated grid
            PlayerGrid.printGrid();
<<<<<<< HEAD

            //checks if the grid's win condition is fulfilled
=======
            //tests if there is 3 in a row or not

>>>>>>> f6b38618bced946dd41956540c1bef1c1588f97c
            if (PlayerGrid.returnsWin()) {
                System.out.println("YOU WIN! GOOD JOB");
                i = 9;
            }

            i++;
        }

    }

}
