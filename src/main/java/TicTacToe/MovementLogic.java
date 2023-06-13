package TicTacToe;

import java.util.List;

public class MovementLogic implements Player {
    private Board board = new Board();
    private ScannerWrapper scannerWrapper = new ScannerWrapper();
    private RandomWrapper randomWrapper = new RandomWrapper();

    public MovementLogic() {
    }

    public MovementLogic(Board board, ScannerWrapper scannerWrapper, RandomWrapper randomWrapper) {
        this.board = board;
        this.scannerWrapper = scannerWrapper;
        this.randomWrapper = randomWrapper;
    }

    @Override
    public Position doAMove(char symbol) {
        Position position = null;
        if (symbol == Figures.CROSS.getCharacter()) {
            List<Position> emptyFields = board.findFreePositions();
            if (emptyFields.size() > 0) {
                int randomIndex = randomWrapper.nextInt(emptyFields.size());
                position = emptyFields.get(randomIndex);
                UserInterface.computerMoveInformation(position.getRowNumber(),
                        position.getColumnNumber());
                return new Position(position.getRowNumber(),
                        position.getColumnNumber());

            }
        }
        if (symbol == Figures.CIRCLE.getCharacter()) {
            int rowNumber = scannerWrapper.input();
            int columnNumber = scannerWrapper.input();
            position = new Position(rowNumber, columnNumber);
        }
        return position;
    }

}
