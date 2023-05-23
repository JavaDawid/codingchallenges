package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class MovementLogicTest {

    @InjectMocks
    private Board board;

    @Mock
    private ScannerWrapper scannerWrapper;

    @Mock
    private Random random;

    private MovementLogic movementLogic;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        movementLogic = new MovementLogic(board, scannerWrapper, random);
    }

    @Test
    public void testDoAMove() {
        //given
        char symbol = Board.CROSS;
        Position expectedPosition = new Position(1, 1);
        when(board.checkBoardAndFindFreePosition()).thenReturn(Arrays.asList(new Position(0, 0), expectedPosition));
        when(random.nextInt(Mockito.anyInt())).thenReturn(1); // Always return the last index

        //when
        Position actualPosition = movementLogic.doAMove(symbol);

        //then
        assertEquals(expectedPosition, actualPosition, "The selected position should be the last position in the list of free positions");
    }
}
