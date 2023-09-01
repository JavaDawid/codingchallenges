package TicTacToe;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ComputerPlayer implements Player {
    private Board board;
    private RandomWrapper randomWrapper;

    @Override
    public void markMove(char symbol) {
        Position position;
        List<Position> emptyFields = board.findFreePositions();
        if (emptyFields.size() > 0) {
            int randomIndex = randomWrapper.nextInt(emptyFields.size());
            position = emptyFields.get(randomIndex);
            board.markMove(position, symbol);
            UserInterface.COMPUTER_MOVE_INFORMATION(position.getRowNumber(),
                    position.getColumnNumber());
        }
    }
}
