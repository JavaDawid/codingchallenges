package TicTacToe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
public class BoardTest {
    @InjectMocks
    Board board;
    private static final char CIRCLE = Figure.CIRCLE.getCharacter();

    @Test
    public void shouldFindFreePositions() {
        //given
        List<Position> filledPositions = fillFirstColumnOfBoard(board);
        int totalPositions = 9;

        //when
        List<Position> freePositions = board.findFreePositions();

        //then
        assertFalse(freePositions.isEmpty());
        assertEquals(totalPositions - filledPositions.size(), freePositions.size());

        for (Position position : filledPositions) {
            assertFalse(freePositions.contains(position));
        }
    }

    @Test
    public void shouldMarkMove() {
        //given
        Position move = new Position(0, 0);

        //when
        board.markMove(move, Figure.CROSS.getCharacter());

        //then
        assertFalse(board.isFreeAtPosition(move));
    }

    @Test
    public void shouldReturnOriginalBoard() {
        //given
        Position move = new Position(0, 0);

        //when
        board.markMove(move, CIRCLE);

        //then
        char[][] original = board.getBoard();
        char[][] boardCopy = board.getBoardCopy();

        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original.length; j++) {
                assertEquals(original[i][j], boardCopy[i][j]);
            }
        }
    }

    private static List<Position> fillFirstColumnOfBoard(Board board) {
        List<Position> filledPosition = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                board.markMove(new Position(i, j), Figure.CIRCLE.getCharacter());
                filledPosition.add(new Position(i, j));
            }
        }
        return filledPosition;
    }
}
