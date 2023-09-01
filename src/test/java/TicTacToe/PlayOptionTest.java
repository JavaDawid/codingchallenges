package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayOptionTest {
    @Mock
    ScannerWrapper scannerWrapper;
    @Mock
    PlayLogic playLogic;
    PlayOption playOption;

    @BeforeEach
    public void setUp() {
        playOption = new PlayOption(scannerWrapper, playLogic);
    }

    @Test
    public void shouldReturnFirstGameWhenOptionIsOne() {
        //given
        when(scannerWrapper.input()).thenReturn(1);

        //when
        playOption.chooseGameType(playOption.playOption());

        //then
        verify(playLogic, times(1)).humanVsHuman();
    }

    @Test
    public void shouldReturnFirstGameWhenOptionIsTwo() {
        //given
        when(scannerWrapper.input()).thenReturn(2);

        //when
        playOption.chooseGameType(playOption.playOption());

        //then
        verify(playLogic, times(1)).humanVsComputer();
    }

    @Test
    public void shouldReturnFirstGameWhenOptionIsThree() {
        //given
        when(scannerWrapper.input()).thenReturn(3);

        //when
        playOption.chooseGameType(playOption.playOption());

        //then
        verify(playLogic, times(1)).computerVsComputer();
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenInvalidOptionProvided() {
        when(scannerWrapper.input()).thenReturn(4);

        assertThrows(IllegalArgumentException.class, () -> playOption.chooseGameType(playOption.playOption()));
    }

    @Test
    void shouldReturnInputMismatchException() {
        //given
        when(scannerWrapper.input())
                .thenThrow(InputMismatchException.class)
                .thenReturn(1);

        //when
        playOption.playOption();

        //then
        verify(scannerWrapper, times(2)).input();
    }
}