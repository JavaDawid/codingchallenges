package TicTacToe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
        when(randomWrapper.nextInt(Mockito.anyInt())).thenReturn(1);
        //when
        Position result = movementLogic.doAMove(board.CROSS);

        //then
        assertEquals(position2, result);
        verify(board, atLeastOnce()).findFreePositions();
    }

    @Test
    public void userShouldDoAMove() {
        //given
        int inputRow = 2;
        int inputColumn = 1;
        when(scannerWrapper.input()).thenReturn(inputRow, inputColumn);

        //when
        Position result = movementLogic.doAMove(board.CIRCLE);

        //then
        assertEquals(new Position(inputRow, inputColumn), result);
    }
    //does not check the size array, only check the correct flow of information
}
