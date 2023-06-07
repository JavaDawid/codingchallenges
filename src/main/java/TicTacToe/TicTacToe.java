package TicTacToe;

public class TicTacToe {
    private WinLogic winLogic = new WinLogic();
    private Board board = new Board();
    private UserInterface userInterface = new UserInterface();
    private Player movementLogic = new MovementLogic();

    public TicTacToe(Board board, WinLogic winLogic, MovementLogic movementLogic, UserInterface userInterface) {
        this.board = board;
        this.winLogic = winLogic;
        this.movementLogic = movementLogic;
        this.userInterface = userInterface;
    }

    public TicTacToe() {
    }

    public void loop() {
        while (winLogic.isGameContinues()) {
            userInterface.startGame();
            board.fillBoardEmptyPlace();
            board.printBoard();
            userInterface.printTemplate();
            play(board);
        }
    }

    public void play(Board board) {
        int player = 1;
        while (!winLogic.isWin() && winLogic.isGameContinues()) {
            if (player == 1) {
                moveGameLogic(board, board.CIRCLE);
                board.printBoard();
                player = 2;
            } else {
                moveGameLogic(board, board.CROSS);
                board.printBoard();
                player = 1;
            }
            GameStatus status = winLogic.checkWin();
            System.out.println(status);
        }
    }

    public void moveGameLogic(Board board, char symbol) {
        Position userMove = movementLogic.doAMove(symbol);
        board.verificationMoveAndSaveOnBoard(userMove.getRowNumber(), userMove.getColumnNumber(), symbol);
    }
}
