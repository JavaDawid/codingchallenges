package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    private boolean endGame = true;
    public static Scanner scanner = new Scanner(System.in);
    private WinLogic winLogic = new WinLogic();
    private Board board = new Board();
    private UserInterface userInterface = new UserInterface();
    private MovementLogic movementLogic = new MovementLogic();

    public TicTacToe(Scanner scanner, Board board, WinLogic winLogic, MovementLogic movementLogic, UserInterface userInterface) {
        this.scanner = scanner;
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
                win = userGameLogic(board);
                board.printBoard();
                player = 2;
            } else {
                win = computerGameLogic(board);
                board.printBoard();
                player = 1;
            }
        }
    }

    private boolean computerGameLogic(Board board) {
        boolean win;
        MovementLogic computerMove = movementLogic.computerDoAMove();
        board.saveComputerMoveOnBoard(computerMove);
        win = winLogic.checkWin();
        return win;
    }

    private boolean userGameLogic(Board board) {
        boolean win;
        MovementLogic userMoveAfterIncorrectInput;
        try {
            MovementLogic userMove = movementLogic.doAMove();
            board.saveUserMoveOnBoard(userMove);
            win = winLogic.checkWin();
            return win;
        } catch (ArrayIndexOutOfBoundsException e) {
            UserInterface.movementOffTheBoard(movementLogic);
            userMoveAfterIncorrectInput = movementLogic.doAMove();
            board.saveUserMoveOnBoard(userMoveAfterIncorrectInput);
            win = winLogic.checkWin();
        }
        return win;
    }
}
