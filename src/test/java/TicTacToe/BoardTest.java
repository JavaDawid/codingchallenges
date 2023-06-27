package TicTacToe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {
    @Test
    public void shouldMarkPosition() {
        //given
        Board board = new Board();
        Position position = new Position(1, 1);
        char symbol = Figures.CROSS.getCharacter();

        // when
        board.markPosition(position, symbol);

        // then
        char[][] boardCopy = board.getBoardCopy();
        assertEquals(symbol, boardCopy[position.getRowNumber()][position.getColumnNumber()]);
    }

    @Test
    public void shouldThrowException() {
        //given
        Board board = new Board();
        Position position = new Position(1, 1);
        char symbol = Figures.CROSS.getCharacter();

        // when
        board.markPosition(position, symbol);

        //then
        assertThrows(RuntimeException.class, () -> board.markPosition(position, symbol));
    }
}
