package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WinLogicTest {

    @Mock
    private Board board;

    private WinLogic winLogic;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        winLogic = new WinLogic(board);
    }

    @Test
    public void testCheckWin() {
        //given
        char[][] boardData = {
                {'X', ' ', ' '},
                {' ', 'X', ' '},
                {' ', ' ', 'X'}
        };
        when(board.getBoard()).thenReturn(boardData);

        //when
        GameStatus status = winLogic.checkWin();

        //then
        assertEquals(GameStatus.X_WON, status);
    }
}
