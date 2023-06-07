package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public char[][] board = new char[3][3];
    public static final char CROSS = 'X'; //computer
    public static final char CIRCLE = 'O'; //user
    public static final char EMPTY = ' ';
    public List<Position> freePositions;

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


    public List<Position> findFreePositions() {
        List<Position> boardWithEmptyField = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == EMPTY) {
                    boardWithEmptyField.add(new Position(i, j));
                }
            }
        }
        return boardWithEmptyField;
    }

    public void markPosition(int move, int move1, char symbol) {
        board[move][move1] = symbol;
    }

    public void verificationMoveAndSaveOnBoard(int x, int y, char symbol) {
        Position move = new Position(x, y);
        boolean positionIsFree = checkMoveWithFreePositionOnBoard(move);
        if (!positionIsFree) {
            markPosition(move.getRowNumber(), move.getColumnNumber(), symbol);
        } else {
            throw new RuntimeException("Pozycja jest zajęta");
        }
    }

    private boolean checkMoveWithFreePositionOnBoard(Position move) {
        freePositions = findFreePositions();
        for (Position positions : freePositions) {
            if (positions.equals(move)) {
                freePositions.remove(move);
                return false;
            }
        }
        return true;
    }

    public void fillBoardEmptyPlace() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

}
