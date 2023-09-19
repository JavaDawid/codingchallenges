package TicTacToe;

public interface PlayerFactory {
    Player createPlayer(Board board, Figure symbol);
}
