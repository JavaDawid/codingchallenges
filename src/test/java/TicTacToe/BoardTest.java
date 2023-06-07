package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    private final char cross = 'X';
    private final char circle = 'O';

    @BeforeEach
    public void setUp() {
        board = new Board();
        board.fillBoardEmptyPlace();
    }

    @Test
    public void testFillBoardEmptyPlace() {
        //given
        board.getBoard()[0][0] = board.CROSS;
        board.getBoard()[1][1] = board.CIRCLE;
        board.getBoard()[2][2] = board.CROSS;

        //when
        board.fillBoardEmptyPlace();

        //then
        for (int i = 0; i < board.board.length; i++) {
            for (int j = 0; j < board.board.length; j++) {
                assertEquals(board.EMPTY, board.getBoard()[i][j]);
            }
        }
    }

    @Test
    public void shouldFindFreePosition() {
        //given
        board.getBoard()[0][0] = circle;
        board.getBoard()[0][1] = cross;
        board.getBoard()[0][2] = circle;
        board.getBoard()[1][0] = cross;
        board.getBoard()[1][1] = circle;
        board.getBoard()[1][2] = cross;

        List<Position> expectedPositions = Arrays.asList(new Position(2, 0),
                new Position(2, 1), new Position(2, 2));

        //when
        List<Position> freePositions = board.findFreePositions();

        //then
        assertEquals(expectedPositions, freePositions);
    }

    @Test
    public void shouldMarkPosition() {
        //given
        int row = 1;
        int column = 0;
        char[][] actualBoard = board.getBoard();
        //when
        board.markPosition(row, column, circle);

        //then
        assertEquals(circle, actualBoard[row][column]);
    }

    @Test
    public void shouldVerifyMoveAndSaveOnBoard() {
        //given
        Position move = new Position(1, 0);
        board.markPosition(move.getRowNumber(), move.getColumnNumber(), circle);

        //then
        assertThrows(RuntimeException.class, () ->
                board.verificationMoveAndSaveOnBoard(move.getRowNumber(), move.getColumnNumber(), circle));
    }
}
