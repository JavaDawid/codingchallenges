package TicTacToe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameLoopTest {
    @Mock
    private Board board;
    @Mock
    private WinLogic winLogic;
    private Player playerCircle;
    private Player playerCross;
    @Mock
    private Player activePlayer;
    @InjectMocks
    private GameLoop gameLoop;

    @Test
    public void shouldChangePlayer() {
        //given
        Player activePlayerCircle = playerCircle;
        Player activePlayerCross = playerCross;

        //when
        Player changePlayerFromCircle = gameLoop.changeActivePlayer(playerCircle, playerCross, activePlayerCircle);
        Player changePlayerFromCross = gameLoop.changeActivePlayer(playerCircle, playerCross, activePlayerCross);

        //then
        assertEquals(activePlayerCircle, changePlayerFromCircle);
        assertEquals(activePlayerCross, changePlayerFromCross);
    }

    @Test
    public void shouldTestLoopGameStatusOngoing() {
        //given
        when(winLogic.checkWin())
                .thenReturn(GameStatus.ONGOING)
                .thenReturn(GameStatus.O_WON);

        //when
        gameLoop.loop();

        //then
        verify(winLogic, times(2)).checkWin();
    }
}