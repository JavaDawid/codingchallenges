package TicTacToe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.InputMismatchException;

@RequiredArgsConstructor
public class TicTacToe {
    @NonNull
    private final Board board;
    @NonNull
    private final HumanPlayerFactory humanPlayerFactory;
    @NonNull
    private final ComputerPlayerFactory computerPlayerFactory;
    @NonNull
    private final ScannerWrapper scannerWrapper;
    @NonNull
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
        playerCircle = playerFactoryCircle.createPlayer(board, Figures.CIRCLE);
        playerCross = playerFactoryCross.createPlayer(board, Figures.CROSS);

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

    public Player getPlayerCircle() {
        return playerCircle;
    }

    public Player getPlayerCross() {
        return playerCross;
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
