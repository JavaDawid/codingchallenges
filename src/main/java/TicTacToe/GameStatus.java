package TicTacToe;

public enum GameStatus {
    ONGOING("Dalsza rozgrywka trwa"),
    DRAW("Remis"),
    X_WON("Gracz X wygrywa"),
    O_WON("Gracz O wygrywa");
    private final String description;

    GameStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
