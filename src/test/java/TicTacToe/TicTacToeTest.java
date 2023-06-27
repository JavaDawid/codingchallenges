package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class TicTacToeTest {

    @Mock
    private WinLogic winLogic;
    @Mock
    private Board board;
    @Mock
    private UserInterface userInterface;
    @Mock
    private MovementLogic movementLogic;
    @Mock
    private Position position;
    @InjectMocks
    private TicTacToe ticTacToe;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        ticTacToe = new TicTacToe(board, winLogic, movementLogic, userInterface);
    }

    @Test
    public void testGameLoop() {
        //given
        when(winLogic.checkWin()).thenReturn(GameStatus.ONGOING,GameStatus.ONGOING,GameStatus.DRAW);
        when(movementLogic.doMove(Figures.CIRCLE.getCharacter())).thenReturn(position);
        when(movementLogic.doMove(Figures.CROSS.getCharacter())).thenReturn(position);
        when(position.getRowNumber()).thenReturn(0).thenReturn(1);
        when(position.getColumnNumber()).thenReturn(0).thenReturn(1);

        //when
        ticTacToe.loop();

        //then
        InOrder inOrder = inOrder(movementLogic);
        inOrder.verify(movementLogic).doMove(Figures.CIRCLE.getCharacter());
        inOrder.verify(movementLogic).doMove(Figures.CROSS.getCharacter());
    }
}