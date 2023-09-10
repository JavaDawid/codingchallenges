package TicTacToe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameLoop {
    private final Board board;
    private final WinLogic winLogic;
    private final Player playerCircle;
    private final Player playerCross;

    public void loop() {
        GameStatus status = winLogic.checkWin();
        Player activePlayer = playerCircle;
        while (status == GameStatus.ONGOING) {
            try {
                activePlayer.makeMove();
                status = gameStatus();
                activePlayer = changeActivePlayer(playerCircle, playerCross, activePlayer);
            } catch (RuntimeException e) {
                UserInterface.printer(UserInterface.POSITION_IS_NOT_AVAILABLE);
            }
        }
    }

    public Player changeActivePlayer(Player playerCircle, Player playerCross, Player activePlayer) {
        if (activePlayer == playerCircle) {
            return playerCross;
        } else {
            return playerCircle;
        }
    }

    private GameStatus gameStatus() {
        board.printBoard();
        GameStatus status = winLogic.checkWin();
        UserInterface.printer(String.valueOf(status));
        return status;
    }

}
