package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TicTacToeTest {

    @Mock
    private Board board;
    @Mock
    private UserInterface userInterface;
    @Mock
    private PlayOption playOption;
    @Mock
    private WinLogic winLogic;
    @Mock
    private HumanPlayerFactory humanPlayerFactory;
    @Mock
    private ComputerPlayerFactory computerPlayerFactory;
    @Mock
    private PlayLogic playLogic;
    @Mock
    private ScannerWrapper scannerWrapper;
    @InjectMocks
    private TicTacToe ticTacToe;

    @BeforeEach
    public void setup() {
        ticTacToe = new TicTacToe(board, userInterface, playOption, winLogic, humanPlayerFactory, computerPlayerFactory, playLogic, scannerWrapper);
    }

    @Test
    public void testGameLoop() {
        //given
        when(playOption.playOption()).thenReturn(2);

        //when
        ticTacToe.loop();

        //then
        verify(userInterface, times(1)).startGame();
        verify(board).printBoard();
        verify(userInterface, times(1)).printTemplate();
        verify(playOption, times(1)).chooseGameType(2);
    }
}