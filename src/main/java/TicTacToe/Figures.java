package TicTacToe;

public enum Figures {
    CROSS('X'),
    CIRCLE('O'),
    EMPTY(' ');
    private final char character;

    Figures(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
