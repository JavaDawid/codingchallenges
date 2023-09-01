package TicTacToe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TicTacToe {
    private final Board board;
    private final UserInterface userInterface;
    private final PlayOption playOption;
    private final WinLogic winLogic;
    private final HumanPlayerFactory humanPlayerFactory;
    private final ComputerPlayerFactory computerPlayerFactory;
    private final PlayLogic playLogic;
    private final ScannerWrapper scannerWrapper;

    public TicTacToe() {
        this.scannerWrapper = new ScannerWrapper();
        this.board = new Board();
        this.userInterface = new UserInterface();
        this.winLogic = new WinLogic(board);
        this.humanPlayerFactory = new HumanPlayerFactory();
        this.computerPlayerFactory = new ComputerPlayerFactory();
        this.playLogic = new PlayLogic(board, winLogic, humanPlayerFactory, computerPlayerFactory);
        this.playOption = new PlayOption(scannerWrapper, playLogic);
    }

    public void loop() {
        int option = playOption.playOption();
        userInterface.startGame();
        board.printBoard();
        userInterface.printTemplate();
        try {
            playOption.chooseGameType(option);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
