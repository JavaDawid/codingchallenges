package TicTacToe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HumanPlayerFactory implements PlayerFactory {
    private final ScannerWrapper scannerWrapper;

    @Override
    public Player createPlayer(Board board, Figure symbol) {
        return new HumanPlayer(board, symbol, scannerWrapper);
    }
}
