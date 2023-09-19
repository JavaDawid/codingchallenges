package TicTacToe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TicTacToeTest {

    @Mock
    private Board board;
    @Mock
    private HumanPlayerFactory humanPlayerFactory;
    @Mock
    private ComputerPlayerFactory computerPlayerFactory;
    @Mock
    private ScannerWrapper scannerWrapper;
    @Mock
    private HumanPlayer humanPlayer;
    @Mock
    private ComputerPlayer computerPlayer;
    @InjectMocks
    private TicTacToe ticTacToe;

    @Test
    public void shouldThrowInputMismatchExceptionWhenInvalidOptionProvided() {
        //given
        when(scannerWrapper.nextInt()).thenThrow(InputMismatchException.class);

        //when

        //then
        assertThrows(InputMismatchException.class, () -> ticTacToe.getGameTypFromUser());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenInvalidDigitProvided() {
        //given
        when(scannerWrapper.nextInt()).thenReturn(4);

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> ticTacToe.chooseGameType());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void shouldSetCorrectPlayerTypesBasedOnUserInput(int value) {
        //given
        when(scannerWrapper.nextInt()).thenReturn(value);
        switch (value) {
            case 1:
                when(humanPlayerFactory.createPlayer(board, Figure.CIRCLE)).thenReturn(humanPlayer);
                when(humanPlayerFactory.createPlayer(board, Figure.CROSS)).thenReturn(humanPlayer);
                break;
            case 2:
                when(humanPlayerFactory.createPlayer(board, Figure.CIRCLE)).thenReturn(humanPlayer);
                when(computerPlayerFactory.createPlayer(board, Figure.CROSS)).thenReturn(computerPlayer);
                break;
            case 3:
                when(computerPlayerFactory.createPlayer(board, Figure.CIRCLE)).thenReturn(computerPlayer);
                when(computerPlayerFactory.createPlayer(board, Figure.CROSS)).thenReturn(computerPlayer);
                break;
        }

        //when
        ticTacToe.chooseGameType();

        //then
        switch (value) {
            case 1:
                assertTrue(ticTacToe.getPlayerCircle() instanceof HumanPlayer);
                assertTrue(ticTacToe.getPlayerCross() instanceof HumanPlayer);
                break;
            case 2:
                assertTrue(ticTacToe.getPlayerCircle() instanceof HumanPlayer);
                assertTrue(ticTacToe.getPlayerCross() instanceof ComputerPlayer);
                break;
            case 3:
                assertTrue(ticTacToe.getPlayerCircle() instanceof ComputerPlayer);
                assertTrue(ticTacToe.getPlayerCross() instanceof ComputerPlayer);
                break;
        }
    }
}