package TicTacToe;

public interface PlayerFactory {
    Player createPlayer(Board board, Figures symbol);
}
