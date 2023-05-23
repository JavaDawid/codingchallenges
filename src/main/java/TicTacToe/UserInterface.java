package TicTacToe;

public class UserInterface {
    public void startGame() {
        System.out.println("New Game started");
    }

    public void printTemplate() {
        System.out.println("Ruch wykonujemy od 0 do 2 w formacie\n" +
                "(numer wiersza) ... (numer kolumny) ...");
        System.out.println("Zaczynajmy!");
    }

    public static void userIsAWinner() {
        System.out.println("Player won the game");
    }

    public static void computerMoveInformation(int a, int b) {
        System.out.println("Computer move:" + a + " " + b);
    }

    public static void computerIsAWinner() {
        System.out.println("Computer won the game");
    }

//    public static void movementOffTheBoard(MovementLogic movementLogic) {
//        System.err.println("Pozycja  " + movementLogic.getRowNumber() + " " + movementLogic.getColumnNumber() +
//                " mieści się poza planszą");
//        System.err.println("Wykonaj ponowny ruch");
//    }

    public static void mistakeFieldOccupied(Position move) {
        System.err.println("Pozycja " + move.getRowNumber() + " " + move.getColumnNumber() +
                " jest już zajęta!");
    }
}
