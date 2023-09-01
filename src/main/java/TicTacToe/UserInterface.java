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

    public static void COMPUTER_MOVE_INFORMATION(int a, int b) {
        System.out.println("Computer move:" + a + " " + b);
    }

    public static void GAME_VERSION() {
        System.out.println(1 + "-" + PlayOption.Option.ONE.getDescription());
        System.out.println(2 + "-" + PlayOption.Option.TWO.getDescription());
        System.out.println(3 + "-" + PlayOption.Option.THREE.getDescription());
    }

    public static void POSITION_IS_NOT_AVAILABLE() {
        System.err.println("Pozycja jest zajęta bądź niepoprawna, wykonaj ruch jeszcze raz");
    }

    public static String POSITION_IS_INCORRECT_WITH_GAME_RULES() {
        return "Wprowadzono nieprawidłową wartość. Gra obsługuje tylko cyfry z zakresu 0-2";
    }

}
