package TicTacToe;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.InputMismatchException;

@AllArgsConstructor
public class PlayOption {
    private final ScannerWrapper scannerWrapper;
    private final PlayLogic playLogic;

    public void chooseGameType(int option) {
        switch (option) {
            case 1:
                playLogic.humanVsHuman();
                break;
            case 2:
                playLogic.humanVsComputer();
                break;
            case 3:
                playLogic.computerVsComputer();
                break;
            default:
                    throw new IllegalArgumentException("Niepoprawna wartość. Wprowadź liczbę od 1 do 3");

        }
    }

    public int playOption() {
        try {
            UserInterface.GAME_VERSION();
            return scannerWrapper.input();
        } catch (InputMismatchException e) {
            System.err.println("Niepoprawna wartość. Wprowadź liczbę od 1 do 3");
            return scannerWrapper.input();
        }
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
