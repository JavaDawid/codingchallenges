package TicTacToe;

public class TicTacToe {
    private WinLogic winLogic;
    private Board board;
    private UserInterface userInterface;
    private Player movementLogic;

    public TicTacToe(Board board, WinLogic winLogic, MovementLogic movementLogic, UserInterface userInterface) {
        this.board = board;
        this.winLogic = winLogic;
        this.movementLogic = movementLogic;
        this.userInterface = userInterface;
    }

    public TicTacToe() {
        this.board = new Board();
        this.winLogic = new WinLogic(this.board);
        this.movementLogic = new MovementLogic(this.board, new ScannerWrapper(), new RandomWrapper());
        this.userInterface = new UserInterface();
    }

    public void loop() {
        userInterface.startGame();
        board.printBoard();
        userInterface.printTemplate();
        play();
    }

    public void play() {
        int player = 1;
        do {
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
        } while (winLogic.checkWin() == GameStatus.ONGOING);
    }

    public void moveGameLogic(Board board, char symbol) {
        Position userMove = movementLogic.doAMove(symbol);
        board.markPosition(userMove, symbol);
    }
}
