package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class WinLogicTest {
    @InjectMocks
    private WinLogic winLogic;
    @Mock
    private Board board;

    private static final char CROSS = 'X';
    private static final char CIRCLE = 'O';
    private static final int SIZE = 3;

    @BeforeEach
    public void setUp() {
        board = new Board();
        winLogic = new WinLogic(board);
    }

    @Test
    public void shouldReturnWinColumnOPlayer() {
        //given
        setColumnsToCircle(SIZE, 1);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        assertEquals(GameStatus.O_WON, status);
    }

    @Test
    public void shouldReturnWinRowOPlayer() {
        //given
        setColumnsToCircle(1, SIZE);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        assertEquals(GameStatus.O_WON, status);
    }

    @Test
    public void shouldReturnWinDiagonalOPlayer() {
        //given
        board.markMove(new Position(0, 0), CIRCLE);
        board.markMove(new Position(1, 1), CIRCLE);
        board.markMove(new Position(2, 2), CIRCLE);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        assertEquals(GameStatus.O_WON, status);
    }

    @Test
    public void shouldReturnWinSecondaryDiagonalOPlayer() {
        //given
        board.markMove(new Position(0, 2), CIRCLE);
        board.markMove(new Position(1, 1), CIRCLE);
        board.markMove(new Position(2, 0), CIRCLE);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        assertEquals(GameStatus.O_WON, status);
    }

    @Test
    public void shouldReturnDraw() {
        //given
        board.markMove(new Position(0, 0), CIRCLE);
        board.markMove(new Position(1, 0), CROSS);
        board.markMove(new Position(2, 0), CIRCLE);
        board.markMove(new Position(0, 1), CROSS);
        board.markMove(new Position(1, 2), CIRCLE);
        board.markMove(new Position(1, 1), CROSS);
        board.markMove(new Position(2, 1), CIRCLE);
        board.markMove(new Position(2, 2), CROSS);
        board.markMove(new Position(0, 2), CIRCLE);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        assertEquals(GameStatus.DRAW, status);
    }

    @Test
    public void shouldReturnOngoing() {
        //given
        board.markMove(new Position(0, 0), CIRCLE);
        board.markMove(new Position(1, 0), CROSS);
        board.markMove(new Position(2, 0), CIRCLE);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        assertEquals(GameStatus.ONGOING, status);
    }

    private void setColumnsToCircle(int size, int x) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < x; j++) {
                board.markMove(new Position(i, j), CIRCLE);
            }
        }
    }
}
