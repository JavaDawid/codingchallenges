package TicTacToe;

import java.util.List;
import java.util.Random;

public class MovementLogic {
    private int rowNumber;
    private int columnNumber;
    public Board board = new Board();

    public MovementLogic(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public MovementLogic() {
    }

    public MovementLogic computerDoAMove() {
        Random random = new Random();
        List<int[]> emptyFields = board.checkBoardAndFindFreePosition();
        int randomIndex = random.nextInt(emptyFields.size());
        int[] computerPosition = emptyFields.get(randomIndex);
        UserInterface.computerMoveInformation(computerPosition[0], computerPosition[1]);
        return new MovementLogic(computerPosition[0], computerPosition[1]);
    }

    public MovementLogic doAMove() {
        MovementLogic userMove;
        userMove = verificationUserMoveWithBoard();
        return userMove;
    }

    private MovementLogic verificationUserMoveWithBoard() {
        boolean isValidMove;
        MovementLogic userMove;
        do {
            userMove = takeDateFromUserToDoAMove();
            int x = userMove.getRowNumber();
            int y = userMove.getColumnNumber();
            isValidMove = board.getBoard()[x][y] != Board.CROSS && board.getBoard()[x][y] != Board.CIRCLE;
            if (!isValidMove) {
                UserInterface.mistakeFromIdenticalMove(userMove);
            }
        }
        while (!isValidMove);
        return userMove;
    }

    private MovementLogic takeDateFromUserToDoAMove() {
        int x = TicTacToe.scanner.nextInt();
        int y = TicTacToe.scanner.nextInt();
        return new MovementLogic(x, y);
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }
}
