package TicTacToe;

import java.util.List;
import java.util.Random;

public class MovementLogic implements Player {
    private Board board = new Board();
    private ScannerWrapper scannerWrapper = new ScannerWrapper();
    private Random random = new Random();

    public MovementLogic(Board board, ScannerWrapper scannerWrapper, Random random) {
        this.board = board;
        this.scannerWrapper = scannerWrapper;
        this.random = random;
    }

    public MovementLogic() {
    }

    @Override
    public Position doAMove(char symbol) {
        Position position = null;
        if (symbol == Board.CROSS) {
            List<Position> emptyFields = board.checkBoardAndFindFreePosition();
            int randomIndex = random.nextInt(emptyFields.size());
            position = emptyFields.get(randomIndex);
            UserInterface.computerMoveInformation(position.getRowNumber(), position.getColumnNumber());
            position = new Position(position.getRowNumber(), position.getColumnNumber());
            return position;
        }
        if (symbol == Board.CIRCLE) {
            int rowNumber = scannerWrapper.input();
            int columnNumber = scannerWrapper.input();
            position = new Position(rowNumber, columnNumber);
        }
        return position;
    }
}
