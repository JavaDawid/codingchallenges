package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HumanPlayerTest {
    @Mock
    private Board board;
    @Mock
    private ScannerWrapper scannerWrapper;
    @Mock
    private Figure symbol;
    private HumanPlayer humanPlayer;

    @BeforeEach
    public void setUp() {
        humanPlayer = new HumanPlayer(board, symbol, scannerWrapper);
    }

    @Test
    void shouldMarkMoveWhenPositionIsCorrect() {
        //given
        Position position = new Position(0, 0);
        when(scannerWrapper.nextInt()).thenReturn(0).thenReturn(0);
        boolean freeAtPosition = board.isFreeAtPosition(position);
        when(freeAtPosition).thenReturn(true);

        //when
        humanPlayer.makeMove();

        //then
        assertFalse(freeAtPosition);
    }

    @Test
    void shouldReturnMessagePositionIsNotAvailable() {
        //given
        Position position = new Position(3, 0);
        when(scannerWrapper.nextInt()).thenReturn(3).thenReturn(0);
        when(board.isFreeAtPosition(position)).thenReturn(false);

        //when then
        assertThrows(RuntimeException.class, () -> humanPlayer.makeMove());

    }

    @Test
    void shouldReturnPositionIsIncorrectWithGameRulesAfterIncorrectUserInput() {
        //given
        Position position = new Position(0, 0);
        when(scannerWrapper.nextInt()).thenThrow(new InputMismatchException())
                .thenReturn(0).thenReturn(0);
        boolean freeAtPosition = board.isFreeAtPosition(position);
        when(freeAtPosition).thenReturn(true);

        //when
        humanPlayer.makeMove();

        //then
        assertFalse(freeAtPosition);
    }
}