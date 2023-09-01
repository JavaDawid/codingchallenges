package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComputerPlayerTest {
    @Mock
    Board board;
    @Mock
    RandomWrapper randomWrapper;
    ComputerPlayer computerPlayer;
    private static final char CIRCLE = Figures.CIRCLE.getCharacter();
    private static final char CROSS = Figures.CROSS.getCharacter();
    private static final char EMPTY = Figures.EMPTY.getCharacter();

    @BeforeEach
    public void mockClass() {
        computerPlayer = new ComputerPlayer(board, randomWrapper);
    }

    @Test
    public void shouldMarkMoveWhenFreePositionAvailable() {
        //czy w przypadku tej metody wystarczy, że przetestuję jedno zaznaczenie position
        // a może powinienem przetestować też i inne pola planszy?

        //given
        char[][] boardCopy = createBoard(EMPTY);
        List<Position> positions = changeArrayToList(boardCopy);
        Position position = new Position(0, 0);

        //when
        when(board.findFreePositions()).thenReturn(positions);
        when(randomWrapper.nextInt(positions.size())).thenReturn(0);
        computerPlayer.markMove(CIRCLE);

        //then
        assertEquals(9, board.findFreePositions().size());
        verify(board).markMove(position, CIRCLE);
    }

    @Test
    public void shouldNotMarkMoveWhenNoFreePositionsAvailable() {
        //given
        char[][] boardCopy = createBoard(CROSS);
        List<Position> positions = changeArrayToList(boardCopy);

        //when
        when(board.findFreePositions()).thenReturn(positions);
        computerPlayer.markMove(CIRCLE);
        //then
        assertEquals(0, board.findFreePositions().size());
    }

    private static char[][] createBoard(char symbol) {
        char[][] boardCopy = new char[3][3];
        for (int i = 0; i < boardCopy.length; i++) {
            for (int j = 0; j < boardCopy.length; j++) {
                boardCopy[i][j] = symbol;
            }
        }
        return boardCopy;
    }

    private static List<Position> changeArrayToList(char[][] boardCopy) {
        List<Position> freePosition = new ArrayList<>();
        for (int i = 0; i < boardCopy.length; i++) {
            for (int j = 0; j < boardCopy.length; j++) {
                if (boardCopy[i][j] == Figures.EMPTY.getCharacter()) {
                    freePosition.add(new Position(i, j));
                }
            }
        }
        return freePosition;
    }
}