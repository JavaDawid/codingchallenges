package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private char[][] board = new char[3][3];

    public List<Position> freePositions;

    public Board() {
        fillBoardEmptyPlace();
    }

    public char[][] getBoardCopy() {
        char[][] copyBoard = new char[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }
        return copyBoard;
    }

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
                if (board[i][j] == Figures.EMPTY.getCharacter()) {
                    boardWithEmptyField.add(new Position(i, j));
                }
            }
        }
        return boardWithEmptyField;
    }

    public void markPosition(Position position, char symbol) {
        Position move = new Position(position.getRowNumber(), position.getColumnNumber());
        boolean positionIsFree = checkMoveWithFreePositionOnBoard(move);
        if (!positionIsFree) {
            throw new RuntimeException("Pozycja jest zajęta");
        }
        board[position.getRowNumber()][position.getColumnNumber()] = symbol;
    }

    private boolean checkMoveWithFreePositionOnBoard(Position move) {
        freePositions = findFreePositions();
        return freePositions.contains(move);
    }

    private void fillBoardEmptyPlace() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = Figures.EMPTY.getCharacter();
            }
        }
    }
}
