package TicTacToe;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Board {
    @Getter(AccessLevel.PROTECTED)
    private final char[][] board = new char[3][3];

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
        System.out.println("       0     1     2   ");
        System.out.println("    +-----+-----+-----+");

        for (int i = 0; i < 3; i++) {
            System.out.print(i + "   |  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "  ");
                if (j < 2) {
                    System.out.print("|  ");
                } else {
                    System.out.print("|");
                }
            }
            System.out.println();

            if (i < 2) {
                System.out.println("    +-----+-----+-----+");
            } else {
                System.out.println("    +-----+-----+-----+");
            }
        }
    }

    public List<Position> findFreePositions() {
        List<Position> boardWithEmptyField = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == Figure.EMPTY.getCharacter()) {
                    boardWithEmptyField.add(new Position(i, j));
                }
            }
        }
        return boardWithEmptyField;
    }

    public boolean isFreeAtPosition(Position position) {
        return board[position.getRowNumber()][position.getColumnNumber()] == Figure.EMPTY.getCharacter();
    }

    public void markMove(Position position, char symbol) {
        board[position.getRowNumber()][position.getColumnNumber()] = symbol;
    }

    private void fillBoardEmptyPlace() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = Figure.EMPTY.getCharacter();
            }
        }
    }
}
