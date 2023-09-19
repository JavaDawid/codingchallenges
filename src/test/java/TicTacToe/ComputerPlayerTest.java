package TicTacToe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComputerPlayerTest {
    @Mock
    private Board board;
    @Mock
    private RandomWrapper randomWrapper;
    @InjectMocks
    private ComputerPlayer computerPlayer;
    private static final char EMPTY = Figure.EMPTY.getCharacter();

    @Test
    public void shouldMarkMoveWhenFreePositionAvailable() {
        //given
        char[][] boardCopy = createBoard(EMPTY);
        List<Position> positions = changeArrayToList(boardCopy);
        Position position = new Position(0, 0);
        List<Position> freePositionAfterMove = board.findFreePositions();
        when(board.findFreePositions()).thenReturn(positions);
        when(randomWrapper.nextInt(positions.size())).thenReturn(0);

        //when
        computerPlayer.makeMove();

        //then
        assertFalse(freePositionAfterMove.contains(position));
        assertEquals(9, board.findFreePositions().size());
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
                if (boardCopy[i][j] == Figure.EMPTY.getCharacter()) {
                    freePosition.add(new Position(i, j));
                }
            }
        }
        return freePosition;
    }
}