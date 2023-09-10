package TicTacToe;

public class Main {
    public static void main(String[] args) {
        final Board board = new Board();
        final WinLogic winLogic = new WinLogic(board);
        final ScannerWrapper scannerWrapper = new ScannerWrapper();
        final RandomWrapper randomWrapper = new RandomWrapper();
        final HumanPlayerFactory humanPlayerFactory = new HumanPlayerFactory(scannerWrapper);
        final ComputerPlayerFactory computerPlayerFactory = new ComputerPlayerFactory(randomWrapper);
        TicTacToe ticTacToe = new TicTacToe(board, humanPlayerFactory, computerPlayerFactory, scannerWrapper,
                winLogic);
        ticTacToe.startGame();
    }
}
