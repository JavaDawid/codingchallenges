package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

import static org.mockito.Mockito.*;

class TicTacToeTest {
    @Mock
    private Scanner scanner;
    @Mock
    private Board board;
    @Mock
    private WinLogic winLogic;
    @Mock
    private MovementLogic movementLogic;
    @Mock
    private UserInterface userInterface;
    private TicTacToe ticTacToe;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ticTacToe = new TicTacToe(scanner, board, winLogic, movementLogic, userInterface);
    }

    @Test
    void testLoop() {
        when(winLogic.checkWin()).thenReturn(false, true);
        when(movementLogic.computerDoAMove()).thenReturn(new MovementLogic(1, 1));
        when(movementLogic.doAMove()).thenReturn(new MovementLogic(0, 0));
        when(movementLogic.doAMove()).thenReturn(new MovementLogic(0, 0));

        ticTacToe.loop();

        verify(userInterface, times(1)).startGame();
        verify(board, times(1)).fillBoardEmptyPlace();
        verify(userInterface, times(1)).printTemplate();
    }
}
