package TicTacToe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.InputMismatchException;

@RequiredArgsConstructor
@Getter
public class TicTacToe {
    private final Board board;
    private final HumanPlayerFactory humanPlayerFactory;
    private final ComputerPlayerFactory computerPlayerFactory;
    private final ScannerWrapper scannerWrapper;
    private final WinLogic winLogic;
    private Player playerCircle;
    private Player playerCross;
    private PlayerFactory playerFactoryCircle;
    private PlayerFactory playerFactoryCross;

    public void startGame() {
        try {
            chooseGameType();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Wprowadzone dane nie zostały rozpoznane. Wprowadź liczbę od 1 do 3");
        }
    }


    public void chooseGameType() {
        int option = getGameTypFromUser();
        switch (option) {
            case 1:
                playerFactoryCircle = humanPlayerFactory;
                playerFactoryCross = humanPlayerFactory;
                break;
            case 2:
                playerFactoryCircle = humanPlayerFactory;
                playerFactoryCross = computerPlayerFactory;
                break;
            case 3:
                playerFactoryCircle = computerPlayerFactory;
                playerFactoryCross = computerPlayerFactory;
                break;
            default:
                throw new IllegalArgumentException("Niepoprawna wartość. Wprowadź liczbę od 1 do 3");
        }
        playerCircle = playerFactoryCircle.createPlayer(board, Figure.CIRCLE);
        playerCross = playerFactoryCross.createPlayer(board, Figure.CROSS);

        UserInterface.startGame();
        board.printBoard();
        UserInterface.printTemplate();
        GameLoop gameLoop = new GameLoop(board, winLogic, playerCircle, playerCross);
        gameLoop.loop();
    }

    public int getGameTypFromUser() {
        UserInterface.gameVersion();
        return scannerWrapper.nextInt();
    }

    @AllArgsConstructor
    @Getter

    public enum Option {
        ONE("HUMAN VS HUMAN"),
        TWO("HUMAN VS COMPUTER"),
        THREE("COMPUTER VS COMPUTER");
        private final String description;
    }
}
