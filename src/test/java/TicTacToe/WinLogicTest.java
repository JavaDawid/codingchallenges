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
    private final int size = 3;

    @BeforeEach
    public void setUp() {
        board = new Board();
        winLogic = new WinLogic(board);
    }

    @Test
    public void shouldReturnWinColumnOPlayer() {
        //given
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 1; j++) {
                board.markPosition(new Position(i, j), CIRCLE);
            }
        }

        //when
        GameStatus status = winLogic.checkWin();

        //then
        assertEquals(GameStatus.O_WON, status);
    }

    @Test
    public void shouldReturnWinRowOPlayer() {
        //given
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < size; j++) {
                board.markPosition(new Position(i, j), CIRCLE);
            }
        }

        //when
        GameStatus status = winLogic.checkWin();

        //then
        assertEquals(GameStatus.O_WON, status);
    }

    @Test
    public void shouldReturnWinDiagonalOPlayer() {
        //given
        board.markPosition(new Position(0, 0), CIRCLE);
        board.markPosition(new Position(1, 1), CIRCLE);
        board.markPosition(new Position(2, 2), CIRCLE);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        assertEquals(GameStatus.O_WON, status);
    }

    @Test
    public void shouldReturnWinSecondaryDiagonalOPlayer() {
        //given
        board.markPosition(new Position(0, 2), CIRCLE);
        board.markPosition(new Position(1, 1), CIRCLE);
        board.markPosition(new Position(2, 0), CIRCLE);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        assertEquals(GameStatus.O_WON, status);
    }

    @Test
    public void shouldReturnDraw() {
        //given
        board.markPosition(new Position(0, 0), CIRCLE);
        board.markPosition(new Position(1, 0), CROSS);
        board.markPosition(new Position(2, 0), CIRCLE);
        board.markPosition(new Position(0, 1), CROSS);
        board.markPosition(new Position(1, 2), CIRCLE);
        board.markPosition(new Position(1, 1), CROSS);
        board.markPosition(new Position(2, 1), CIRCLE);
        board.markPosition(new Position(2, 2), CROSS);
        board.markPosition(new Position(0, 2), CIRCLE);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        assertEquals(GameStatus.DRAW, status);
    }

    @Test
    public void shouldReturnOngoing() {
        //given
        board.markPosition(new Position(0, 0), CIRCLE);
        board.markPosition(new Position(1, 0), CROSS);
        board.markPosition(new Position(2, 0), CIRCLE);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        assertEquals(GameStatus.ONGOING, status);
    }
}
