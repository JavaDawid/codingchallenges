package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.InputMismatchException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HumanPlayerTest {
    @Mock
    ScannerWrapper scannerWrapper;
    @Mock
    Board board;
    HumanPlayer humanPlayer;

    private static final char CIRCLE = Figures.CIRCLE.getCharacter();
    private static final char CROSS = Figures.CROSS.getCharacter();

    @BeforeEach
    public void setUp() {
        humanPlayer = new HumanPlayer(scannerWrapper, board);
    }

    @Test
    void shouldMarkMoveWhenPositionIsCorrect() {
        //given
        Position position = new Position(0, 0);

        //when
        when(scannerWrapper.input()).thenReturn(0).thenReturn(0);
        when(board.checkMoveWithFreePositionOnBoard(position)).thenReturn(true);
        humanPlayer.markMove(CIRCLE);
        //then
        verify(board).markMove(position, CIRCLE);
    }

    @Test
    void shouldReturnMessagePositionIsNotAvailable() {
        //given
        Position position = new Position(3, 0);

        //when
        when(scannerWrapper.input()).thenReturn(3).thenReturn(0);
        humanPlayer.markMove(CROSS);

        //then
        verify(board, times(0)).markMove(position, CROSS);

    }

    @Test
    void shouldReturnPositionIsIncorrectWithGameRulesAfterIncorrectUserInput() {
        //given
        Position position = new Position(0, 0);

        //when
        when(scannerWrapper.input()).thenThrow(new InputMismatchException())
                .thenReturn(0).thenReturn(0);
        when(board.checkMoveWithFreePositionOnBoard(position)).thenReturn(true);
        humanPlayer.markMove(CIRCLE);

        //then
        verify(board).markMove(position, CIRCLE);
    }
}