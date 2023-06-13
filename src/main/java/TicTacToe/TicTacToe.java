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
        userInterface.startGame();
        board.fillBoardEmptyPlace();
        board.printBoard();
        userInterface.printTemplate();
        play();
    }

    public void play() {
        int player = 1;
        while (!winLogic.isGameContinues()) {
            if (player == 1) {
                moveGameLogic(board, Figures.CIRCLE.getCharacter());
                player = 2;
            } else {
                moveGameLogic(board, Figures.CROSS.getCharacter());
                player = 1;
            }
            board.printBoard();
            GameStatus status = winLogic.checkWin();
            System.out.println(status);
        }
    }

    public void moveGameLogic(Board board, char symbol) {
        Position userMove = movementLogic.doAMove(symbol);
        board.verificationMoveAndSaveOnBoard(userMove.getRowNumber(), userMove.getColumnNumber(), symbol);
    }
}
