package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
        board.fillBoardEmptyPlace();
    }

    @Test
    public void testFillBoardEmptyPlace() {
        //given
        board.markPosition(0, 0, Figures.CROSS.getCharacter());
        board.markPosition(1, 1, Figures.CIRCLE.getCharacter());
        board.markPosition(2, 2, Figures.CROSS.getCharacter());

        //when
        board.fillBoardEmptyPlace();

        //then
        List<Position> freePositions = board.findFreePositions();
        int totalFields = board.getBoard().length * board.getBoard().length;
        assertEquals(totalFields, freePositions.size());
    }

    @Test
    public void shouldMarkPosition() {
        //given
        int row = 1;
        int column = 0;
        char[][] actualBoard = board.getBoard();
        //when
        board.markPosition(row, column, Figures.CIRCLE.getCharacter());

        //then
        assertEquals(Figures.CIRCLE.getCharacter(), actualBoard[row][column]);
    }


    @Test
    public void shouldVerifyMoveAndSaveOnBoard() {
        Board board = new Board();
        board.fillBoardEmptyPlace();
        int x = 1;
        int y = 1;
        char symbol = Figures.CROSS.getCharacter();

        // when
        board.verificationMoveAndSaveOnBoard(x, y, symbol);

        // then
        assertThrows(RuntimeException.class, () -> board.verificationMoveAndSaveOnBoard(x, y, symbol));

    }
}
