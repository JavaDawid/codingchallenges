package TicTacToe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovementLogicTest {
    @Mock
    private Board board;
    @Mock
    private ScannerWrapper scannerWrapper;
    @Mock
    private RandomWrapper randomWrapper;

    @InjectMocks
    private MovementLogic movementLogic;

    @Test
    public void computerShouldDoAMove() {
        //given
        Position position1 = new Position(2, 1);
        Position position2 = new Position(0, 1);
        List<Position> positions = Arrays.asList(position1, position2);

        when(board.findFreePositions()).thenReturn(positions);
        when(randomWrapper.nextInt(anyInt())).thenReturn(0);
        //when
        Position result = movementLogic.doAMove(Figures.CROSS.getCharacter());

        //then
        assertEquals(position1, result);
    }

    @Test
    public void userShouldDoAMove() {
        //given
        Position position1 = new Position(0, 0);
        when(scannerWrapper.input()).thenReturn(position1.getRowNumber(), position1.getColumnNumber());

        //when
        Position result = movementLogic.doAMove(Figures.CIRCLE.getCharacter());

        //then
        assertEquals(position1, result);
    }
}
