package TicTacToe;

public class ComputerPlayerFactory implements PlayerFactory {
    @Override
    public Player createPlayer(Board board) {
        return new ComputerPlayer(board, new RandomWrapper());
    }
}
