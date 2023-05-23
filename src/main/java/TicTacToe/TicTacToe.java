package TicTacToe;

public class TicTacToe {
    private boolean endGame = true;
    private WinLogic winLogic = new WinLogic();
    private Board board = new Board();
    private UserInterface userInterface = new UserInterface();
    private MovementLogic movementLogic = new MovementLogic();

    public TicTacToe(Board board, WinLogic winLogic, MovementLogic movementLogic, UserInterface userInterface) {
        this.board = board;
        this.winLogic = winLogic;
        this.movementLogic = movementLogic;
        this.userInterface = userInterface;
    }

    public TicTacToe() {
    }

    public void loop() {
        while (endGame) {
            userInterface.startGame();
            board.fillBoardEmptyPlace();
            board.printBoard();
            userInterface.printTemplate();
            play(board);
            endGame = false;
        }
    }

    private void play(Board board) {
        boolean win = false;
        int player = 1;
        while (!win) {
            if (player == 1) {
                moveGameLogic(board, Board.CIRCLE);
                board.printBoard();
                GameStatus gameStatus = winLogic.checkWin();
                System.out.println(gameStatus);
                player = 2;
            } else {
                moveGameLogic(board, Board.CROSS);
                board.printBoard();
                GameStatus gameStatus = winLogic.checkWin();
                System.out.println(gameStatus);
                player = 1;
            }
        }
    }

    private void moveGameLogic(Board board, char symbol) {
        Position userMove = movementLogic.doAMove(symbol);
        board.verificationMoveAndSaveOnBoard(userMove.getRowNumber(), userMove.getColumnNumber(), symbol);
    }

}
