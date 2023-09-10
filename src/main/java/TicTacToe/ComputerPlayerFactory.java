package TicTacToe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ComputerPlayerFactory implements PlayerFactory {
    private final RandomWrapper randomWrapper;

    @Override
    public Player createPlayer(Board board, Figures symbol) {
        return new ComputerPlayer(board, randomWrapper, symbol);
    }
}
