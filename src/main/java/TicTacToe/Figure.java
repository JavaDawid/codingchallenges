package TicTacToe;

public enum Figure {
    CROSS('X'),
    CIRCLE('O'),
    EMPTY(' ');
    private final char character;

    Figure(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
