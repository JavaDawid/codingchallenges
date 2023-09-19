package TicTacToe;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ComputerPlayer implements Player {
    private final Board board;
    private final RandomWrapper randomWrapper;
    private final Figure symbol;

    @Override
    public void makeMove() {
        Position position;
        List<Position> emptyFields = board.findFreePositions();
        if (emptyFields.size() == 0) {
            throw new RuntimeException("Brak wolnych miejsc na planszy. Remis");
        }
        int randomIndex = randomWrapper.nextInt(emptyFields.size());
        position = emptyFields.get(randomIndex);
        board.markMove(position, symbol.getCharacter());
        UserInterface.computerMoveInformation(position.getRowNumber(),
                position.getColumnNumber());

    }
}
