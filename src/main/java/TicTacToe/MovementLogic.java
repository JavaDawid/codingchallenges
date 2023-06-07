package TicTacToe;

import java.util.List;

public class MovementLogic implements Player {
    private Board board = new Board();
    private ScannerWrapper scannerWrapper = new ScannerWrapper();
    private RandomWrapper randomWrapper = new RandomWrapper();


    public MovementLogic() {
    }

    @Override
    public Position doAMove(char symbol) {
        Position position = null;
        if (symbol == board.CROSS) {
            List<Position> emptyFields = board.findFreePositions();
            int randomIndex = randomWrapper.nextInt(emptyFields.size());
            position = emptyFields.get(randomIndex);
            UserInterface.computerMoveInformation(position.getRowNumber(), position.getColumnNumber());
            position = new Position(position.getRowNumber(), position.getColumnNumber());
            return position;
        }
        if (symbol == board.CIRCLE) {
            int rowNumber = scannerWrapper.input();
            int columnNumber = scannerWrapper.input();
            position = new Position(rowNumber, columnNumber);
        }
        return position;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ScannerWrapper getScannerWrapper() {
        return scannerWrapper;
    }

    public void setScannerWrapper(ScannerWrapper scannerWrapper) {
        this.scannerWrapper = scannerWrapper;
    }

    public RandomWrapper getRandomWrapper() {
        return randomWrapper;
    }

    public void setRandomWrapper(RandomWrapper randomWrapper) {
        this.randomWrapper = randomWrapper;
    }
}
