package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;

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

    private TicTacToe ticTacToe;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        ticTacToe = new TicTacToe(board, winLogic, movementLogic, userInterface);
    }

    @Test
    public void testGameLoopContinuesWhileGameNotWon() {
        when(winLogic.isGameContinues()).thenReturn(true, true, false);
        when(movementLogic.doAMove(anyChar())).thenReturn(position);
        when(position.getRowNumber()).thenReturn(0);
        when(position.getColumnNumber()).thenReturn(0);

        ticTacToe.loop();

        verify(userInterface, times(1)).startGame();
        verify(board, times(1)).fillBoardEmptyPlace();
        verify(board, times(2)).printBoard();
        verify(userInterface, times(1)).printTemplate();
    }

    @Test
    public void testGameLoopWhenGameWonImmediately() {
        when(winLogic.isGameContinues()).thenReturn(false);

        ticTacToe.loop();

        verify(userInterface, never()).startGame();
        verify(board, never()).fillBoardEmptyPlace();
        verify(board, never()).printBoard();
        verify(userInterface, never()).printTemplate();
    }

    @Test
    public void testPlayWhenGameWonImmediately() {
        when(winLogic.isGameContinues()).thenReturn(false);
        when(winLogic.isWin()).thenReturn(true);

        ticTacToe.play(board);

        verify(movementLogic, never()).doAMove(anyChar());
    }

    @Test
    public void testPlayAlternatesBetweenPlayers() {
        when(winLogic.isGameContinues()).thenReturn(true, true, true, true, false);
        when(winLogic.isWin()).thenReturn(false, false, false, false);
        when(movementLogic.doAMove(anyChar())).thenReturn(position);
        when(position.getRowNumber()).thenReturn(0);
        when(position.getColumnNumber()).thenReturn(0);

        ticTacToe.play(board);

        verify(movementLogic, times(2)).doAMove(board.CIRCLE);
        verify(movementLogic, times(2)).doAMove(board.CROSS);
    }

    @Test
    public void testMoveGameLogicVerifiesAndSavesMoveOnBoard() {
        when(movementLogic.doAMove(anyChar())).thenReturn(position);
        when(position.getRowNumber()).thenReturn(0);
        when(position.getColumnNumber()).thenReturn(0);

        ticTacToe.moveGameLogic(board, board.CIRCLE);

        verify(movementLogic).doAMove(board.CIRCLE);
        verify(board).verificationMoveAndSaveOnBoard(0, 0, board.CIRCLE);
    }

    @Test
    public void testMoveGameLogicWhenUserMoveIsInvalid() {
        position = new Position(0, 1);
        when(movementLogic.doAMove(anyChar())).thenReturn(position);

        ticTacToe.moveGameLogic(board, board.CIRCLE);

        verify(movementLogic).doAMove(board.CIRCLE);
        verify(board).verificationMoveAndSaveOnBoard(anyInt(), anyInt(), anyChar());
    }
}
