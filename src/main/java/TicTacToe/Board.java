package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final char[][] board = new char[3][3];
    public  static char CROSS = 'X';
    public  static char CIRCLE = 'O';

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.print("\n");
            if (i < 2) {
                System.out.print("------");
            }
            System.out.print("\n");
        }
    }


    public List<int[]> checkBoardAndFindFreePosition() {
        List<int[]> boardWithEmptyField = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == ' ') {
                    boardWithEmptyField.add(new int[]{i, j});
                }
            }
        }
        return boardWithEmptyField;
    }

    public void saveUserMoveOnBoard(MovementLogic move) {
        board[move.getRowNumber()][move.getColumnNumber()] = CIRCLE;
    }

    public void saveComputerMoveOnBoard(MovementLogic move) {
        board[move.getRowNumber()][move.getColumnNumber()] = CROSS;
    }

    public void fillBoardEmptyPlace() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

}
