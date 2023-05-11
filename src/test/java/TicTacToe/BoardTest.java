package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {
    MovementLogic userMove;
    MovementLogic computerMove;
    Board board;

    @BeforeEach
    void setUp() {
        userMove = new MovementLogic(1, 2);
        computerMove = new MovementLogic(2, 0);
        board = new Board();
    }

    @Test
    void testFillBoardEmptyPlace() {
        board.fillBoardEmptyPlace();
        char[][] boardTest = board.getBoard();
        for (int i = 0; i < boardTest.length; i++) {
            for (int j = 0; j < boardTest.length; j++) {
                assertEquals(' ', boardTest[i][j]);
            }
        }
    }

    @Test
    void testSaveUserMoveOnBoard() {
        board.saveUserMoveOnBoard(userMove);
        char[][] boardTest = board.getBoard();
        assertEquals(Board.CIRCLE, boardTest[userMove.getRowNumber()][userMove.getColumnNumber()]);
    }

    @Test
    void testSaveComputerMoveOnBoard() {
        board.saveComputerMoveOnBoard(computerMove);
        char[][] boardTest = board.getBoard();
        assertEquals(Board.CROSS, boardTest[computerMove.getRowNumber()][computerMove.getColumnNumber()]);
    }

    @Test
    void testCheckBoardAndFindFreePositionAndShouldReturnFreePosition() {
        board.fillBoardEmptyPlace();
        List<int[]> emptyPositions = board.checkBoardAndFindFreePosition();
        assertEquals(9, emptyPositions.size());

        board.saveUserMoveOnBoard(userMove);
        emptyPositions = board.checkBoardAndFindFreePosition();
        assertEquals(8, emptyPositions.size());
    }
}