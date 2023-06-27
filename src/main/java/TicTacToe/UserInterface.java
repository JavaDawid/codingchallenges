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

    public static void computerMoveInformation(int a, int b) {
        System.out.println("Computer move:" + a + " " + b);
    }

}
