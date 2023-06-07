package TicTacToe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class WinLogicTest {
    @InjectMocks
    private WinLogic winLogic;
    @Spy
    private Board board;

    private final char cross = 'X';
    private final char circle = 'O';

    @BeforeEach
    public void setUp() {

        board = new Board();
        winLogic = new WinLogic(board);

    }

    @Test
    public void shouldReturnWinColumnOPlayer() {
        //given
        board.markPosition(0, 0, circle);
        board.markPosition(1, 0, circle);
        board.markPosition(2, 0, circle);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        Assertions.assertEquals(GameStatus.O_WON, status);
    }

    @Test
    public void shouldReturnWinColumnXPlayer() {
        //given
        board.markPosition(0, 0, cross);
        board.markPosition(1, 0, cross);
        board.markPosition(2, 0, cross);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        Assertions.assertEquals(GameStatus.X_WON, status);
    }

    @Test
    public void shouldReturnWinRowOPlayer() {
        //given
        board.markPosition(1, 0, circle);
        board.markPosition(1, 1, circle);
        board.markPosition(1, 2, circle);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        Assertions.assertEquals(GameStatus.O_WON, status);
    }

    @Test
    public void shouldReturnWinRowXPlayer() {
        //given
        board.markPosition(1, 0, cross);
        board.markPosition(1, 1, cross);
        board.markPosition(1, 2, cross);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        Assertions.assertEquals(GameStatus.X_WON, status);
    }

    @Test
    public void shouldReturnWinMainDiagonalOPlayer() {
        //given
        board.markPosition(0, 0, circle);
        board.markPosition(1, 1, circle);
        board.markPosition(2, 2, circle);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        Assertions.assertEquals(GameStatus.O_WON, status);
    }

    @Test
    public void shouldReturnWinMainDiagonalXPlayer() {
        //given
        board.markPosition(0, 0, cross);
        board.markPosition(1, 1, cross);
        board.markPosition(2, 2, cross);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        Assertions.assertEquals(GameStatus.X_WON, status);
    }

    @Test
    public void shouldReturnWinSecondaryDiagonalOPlayer() {
        //given
        board.markPosition(0, 2, circle);
        board.markPosition(1, 1, circle);
        board.markPosition(2, 0, circle);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        Assertions.assertEquals(GameStatus.O_WON, status);
    }

    @Test
    public void shouldReturnWinSecondaryDiagonalXPlayer() {
        //given
        board.markPosition(0, 2, cross);
        board.markPosition(1, 1, cross);
        board.markPosition(2, 0, cross);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        Assertions.assertEquals(GameStatus.X_WON, status);
    }

    @Test
    public void shouldReturnDraw() {
        //given
        board.markPosition(0, 0, circle);
        board.markPosition(1, 0, cross);
        board.markPosition(2, 0, circle);
        board.markPosition(0, 1, cross);
        board.markPosition(1, 2, circle);
        board.markPosition(1, 1, cross);
        board.markPosition(2, 1, circle);
        board.markPosition(2, 2, cross);
        board.markPosition(0, 2, circle);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        Assertions.assertEquals(GameStatus.DRAW, status);
    }

}
