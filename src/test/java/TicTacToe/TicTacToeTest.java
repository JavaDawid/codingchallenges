package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TicTacToeTest {

    @Mock
    private Board board;

    @Mock
    private WinLogic winLogic;

    @Mock
    private MovementLogic movementLogic;

    @Mock
    private UserInterface userInterface;

    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        game = new TicTacToe(board, winLogic, movementLogic, userInterface);
    }

    @Test
    public void testLoop() {
        //given
        Position position = new Position(0, 0);
        Mockito.when(movementLogic.doAMove(Mockito.anyChar())).thenReturn(position);

        //when
        game.loop();

        //then
        Mockito.verify(userInterface, Mockito.times(1)).startGame();
        Mockito.verify(board, Mockito.times(1)).fillBoardEmptyPlace();
        Mockito.verify(board, Mockito.times(1)).printBoard();
        Mockito.verify(userInterface, Mockito.times(1)).printTemplate();
    }
}
