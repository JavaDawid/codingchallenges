package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testFillBoardEmptyPlace() {
        //given
        board.getBoard()[0][0] = Board.CROSS;
        board.getBoard()[1][1] = Board.CIRCLE;
        board.getBoard()[2][2] = Board.CROSS;

        //when
        board.fillBoardEmptyPlace();

        //then
        for (int i = 0; i < Board.board.length; i++) {
            for (int j = 0; j < Board.board.length; j++) {
                assertEquals(Board.EMPTY, board.getBoard()[i][j], "Board should be empty after calling fillBoardEmptyPlace()");
            }
        }
    }
}
