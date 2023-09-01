package TicTacToe;

public class HumanPlayerFactory implements PlayerFactory {
    @Override
    public Player createPlayer(Board board) {
        return new HumanPlayer(new ScannerWrapper(), board);
    }
}
