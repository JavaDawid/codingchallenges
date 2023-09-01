package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayLogicTest {
    @Mock
    Board board;
    @Mock
    WinLogic winLogic;
    @Mock
    HumanPlayerFactory humanPlayerFactory;
    @Mock
    ComputerPlayerFactory computerPlayerFactory;
    @Mock
    Player human;
    @Mock
    Player computer;
    PlayLogic playLogic;
    private static final char CIRCLE = Figures.CIRCLE.getCharacter();
    private static final char CROSS = Figures.CROSS.getCharacter();

    @BeforeEach
    public void setUp() {
        playLogic = new PlayLogic(board, winLogic, humanPlayerFactory, computerPlayerFactory);
    }

    @Test
    public void shouldComputerWinInTestHumanVsComputer() {
        //given
        when(humanPlayerFactory.createPlayer(board)).thenReturn(human);
        when(computerPlayerFactory.createPlayer(board)).thenReturn(computer);
        when(winLogic.checkWin())
                .thenReturn(GameStatus.ONGOING)
                .thenReturn(GameStatus.ONGOING)
                .thenReturn(GameStatus.ONGOING)
                .thenReturn(GameStatus.X_WON);

        //nie rozumiem dlaczego mimo wywołania ONGOING 3razy zostaje wyświetlony 2 razy. Podczas grania działa poprawnie

        //when
        playLogic.humanVsComputer();

        //then
        verify(humanPlayerFactory, times(1)).createPlayer(board);
        verify(computerPlayerFactory, times(1)).createPlayer(board);
        verify(human, times(2)).markMove(CIRCLE);
        verify(computer, times(1)).markMove(CROSS);
    }

    @Test
    public void shouldHumanWinInTestHumanVsComputer() {
        //given
        when(humanPlayerFactory.createPlayer(board)).thenReturn(human);
        when(computerPlayerFactory.createPlayer(board)).thenReturn(computer);
        when(winLogic.checkWin())
                .thenReturn(GameStatus.ONGOING)
                .thenReturn(GameStatus.ONGOING)
                .thenReturn(GameStatus.ONGOING)
                .thenReturn(GameStatus.ONGOING)
                .thenReturn(GameStatus.O_WON);

        //when
        playLogic.humanVsComputer();

        //then
        verify(humanPlayerFactory, times(1)).createPlayer(board);
        verify(computerPlayerFactory, times(1)).createPlayer(board);
        verify(human, times(2)).markMove(CIRCLE);
        verify(computer, times(2)).markMove(CROSS);
    }

}