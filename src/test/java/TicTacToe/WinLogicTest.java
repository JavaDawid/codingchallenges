package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinLogicTest {
    private WinLogic winLogic;

    @BeforeEach
    void setUp() {
        winLogic = new WinLogic();
    }

    @Test
    void testCheckWinNoWin() {
        Board board = new Board();
        board.fillBoardEmptyPlace();
        assertFalse(winLogic.checkWin());
    }

    @Test
    void testCheckWinRowWin() {
        Board board = new Board();
        board.fillBoardEmptyPlace();
        board.saveUserMoveOnBoard(new MovementLogic(0, 0));
        board.saveUserMoveOnBoard(new MovementLogic(0, 1));
        board.saveUserMoveOnBoard(new MovementLogic(0, 2));
        assertTrue(winLogic.checkWin());
    }

    @Test
    void testCheckWinColumnWin() {
        Board board = new Board();
        board.fillBoardEmptyPlace();
        board.saveUserMoveOnBoard(new MovementLogic(0, 0));
        board.saveUserMoveOnBoard(new MovementLogic(1, 0));
        board.saveUserMoveOnBoard(new MovementLogic(2, 0));
        assertTrue(winLogic.checkWin());
    }

    @Test
    void testCheckWinDiagonalWin() {
        Board board = new Board();
        board.fillBoardEmptyPlace();
        board.saveComputerMoveOnBoard(new MovementLogic(0, 0));
        board.saveComputerMoveOnBoard(new MovementLogic(1, 1));
        board.saveComputerMoveOnBoard(new MovementLogic(2, 2));
        assertTrue(winLogic.checkWin());
    }
}