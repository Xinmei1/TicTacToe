public class Main {

    public static void main(String[] args) {

        //Generates a new object from the MyGrid class

        MyGrid PlayerGrid = new MyGrid();
        UserInput PlayerOneInput = new UserInput();

        for (int i=0; i < 9; i++) {

            String inputXO = PlayerOneInput.inputGetter();

        /*Sets grid based on user input
        More like changes one square of the grid
        every time the user inputs another String
         */
            PlayerGrid.setGrid(inputXO);
            //print updated grid
            PlayerGrid.printGrid();
            //tests if there is 3 in a row or not


            if (PlayerGrid.returnsWin()){
                System.out.println("YOU WIN! GOOD JOB");
                i=9;
            }
        }


    }
}
