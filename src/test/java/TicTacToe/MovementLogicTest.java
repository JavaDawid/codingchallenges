package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MovementLogicTest {
    private Board board;
    private MovementLogic movementLogic;

    @BeforeEach
    void setUp() {
        board = Mockito.mock(Board.class);
    }

    @Test
    void testDoAMove() {
        String simulatedUserInput = "0\n2\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(in);
        TicTacToe.scanner = new Scanner(System.in);

        movementLogic = new MovementLogic(0, 0);
        MovementLogic userMove = movementLogic.doAMove();

        assertEquals(0, userMove.getRowNumber());
        assertEquals(2, userMove.getColumnNumber());
    }

    @Test
    void testComputerDoAMove() {
        List<int[]> emptyFields = new ArrayList<>(Arrays.asList(new int[]{2, 2}, new int[]{1, 1}));
        Mockito.when(board.checkBoardAndFindFreePosition()).thenReturn(emptyFields);

        movementLogic = new MovementLogic(0, 0);
        movementLogic.board = board;
        MovementLogic computerMove = movementLogic.computerDoAMove();

        assertTrue(computerMove.getRowNumber() == 2 && computerMove.getColumnNumber() == 2
                || computerMove.getRowNumber() == 1 && computerMove.getColumnNumber() == 1);
    }
}
