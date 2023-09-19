package TicTacToe;

import lombok.AllArgsConstructor;

import java.util.InputMismatchException;

@AllArgsConstructor
public class HumanPlayer implements Player {
    private final Board board;
    private final Figure symbol;
    private final ScannerWrapper scannerWrapper;

    @Override
    public void makeMove() {
        Position position = takePositionFromUser();
        if (!board.isFreeAtPosition(position)) {
            throw new RuntimeException();
        }
        board.markMove(position, symbol.getCharacter());
    }

    private Position takePositionFromUser() {
        Position position = null;
        while (position == null) {
            try {
                int rowNumber = scannerWrapper.nextInt();
                int columnNumber = scannerWrapper.nextInt();
                position = new Position(rowNumber, columnNumber);
            } catch (InputMismatchException e) {
                System.err.println(UserInterface.POSITION_IS_INCORRECT_WITH_GAME_RULES);
                scannerWrapper.nextLine();
            }
        }
        return position;
    }
}

