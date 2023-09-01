package TicTacToe;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlayLogic {
    @NonNull
    private final Board board;
    @NonNull
    private final WinLogic winLogic;
    @NonNull
    private final HumanPlayerFactory humanPlayerFactory;
    @NonNull
    private final ComputerPlayerFactory computerPlayerFactory;

    private GameStatus status;

    //po napisaniu testów tak myślę, że mógłbym te trzy metody połączyć w jedną i przenieść tą klasę do PlayOption
    // dobry pomysł?
    public void humanVsHuman() {
        Player playerCircle = createHumanPlayer();
        Player playerCross = createHumanPlayer();
        logic(playerCircle, playerCross);
    }

    public void humanVsComputer() {
        Player playerCircle = createHumanPlayer();
        Player playerAICross = createComputerPlayer();
        logic(playerCircle, playerAICross);
    }

    public void computerVsComputer() {
        Player playerCircle = createComputerPlayer();
        Player playerCross = createComputerPlayer();
        logic(playerCircle, playerCross);
    }

    private void logic(Player playerCircle, Player playerCross) {
        do {
            playerCircle.markMove(Figures.CIRCLE.getCharacter());
            status = gameStatus();
            if (status == GameStatus.ONGOING) {
                playerCross.markMove(Figures.CROSS.getCharacter());
                gameStatus();
            }
        } while (winLogic.checkWin() == GameStatus.ONGOING);
    }

    private Player createHumanPlayer() {
        return humanPlayerFactory.createPlayer(board);
    }

    private Player createComputerPlayer() {
        return computerPlayerFactory.createPlayer(board);
    }

    private GameStatus gameStatus() {
        board.printBoard();
        GameStatus status = winLogic.checkWin();
        System.out.println(status);
        return status;
    }
}
