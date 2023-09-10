package TicTacToe;

public class UserInterface {
    public static void startGame() {
        System.out.println("New Game started");
    }

    public static void printTemplate() {
        System.out.println("Ruch wykonujemy od 0 do 2 w formacie\n" +
                "(numer wiersza) ... (numer kolumny) ...");
        System.out.println("Zaczynajmy!");
    }

    public static void computerMoveInformation(int a, int b) {
        System.out.println("Computer move:" + a + " " + b);
    }

    public static void gameVersion() {
        System.out.println(1 + "-" + TicTacToe.Option.ONE.getDescription());
        System.out.println(2 + "-" + TicTacToe.Option.TWO.getDescription());
        System.out.println(3 + "-" + TicTacToe.Option.THREE.getDescription());
    }

    public static final String POSITION_IS_NOT_AVAILABLE = "Pozycja jest niepoprawna bądź zajęta, wykonaj ruch jeszcze raz";
    public static final String POSITION_IS_INCORRECT_WITH_GAME_RULES = "Wprowadzono nieprawidłową wartość. Gra obsługuje tylko cyfry z zakresu 0-2";

    public static void printer(String status) {
        System.out.println(status);
    }

}
