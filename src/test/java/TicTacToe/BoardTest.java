package TicTacToe;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    public void shouldFindFreePositions() {
        //given
        Board board = new Board();
        List<Position> filledPositions = fillBoard(board);

        //when
        List<Position> freePositions = board.findFreePositions();

        //then
        for (Position position : filledPositions) {
            assertFalse(freePositions.contains(position));
        }
    }

    @Test
    public void shouldMarkMove() {
        //given
        Board board = new Board();
        Position move = new Position(0, 0);

        //when
        board.markMove(move, Figures.CIRCLE.getCharacter());

        //then
        assertFalse(board.checkMoveWithFreePositionOnBoard(move));
    }

    @Test
    public void shouldReturnOriginalBoard() {
        //given
        Board board = new Board();
        Position move = new Position(0, 0);

        //when
        board.markMove(move, Figures.CIRCLE.getCharacter());

        //then
        char[][] original = board.getBoard();
        char[][] boardCopy = board.getBoardCopy();

        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original.length; j++) {
                assertEquals(original[i][j], boardCopy[i][j]);
            }
        }
    }

    private static List<Position> fillBoard(Board board) {
        List<Position> filledPosition = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                board.markMove(new Position(i, j), Figures.CIRCLE.getCharacter());
                filledPosition.add(new Position(i, j));
            }
        }
        return filledPosition;
    }
}
