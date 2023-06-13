package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final char[][] board = new char[3][3];
    public List<Position> freePositions;

    public char[][] getBoard() {
        return board;
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

    public void markPosition(int move, int move1, char symbol) {
        board[move][move1] = symbol;
    }

    public void verificationMoveAndSaveOnBoard(int x, int y, char symbol) {
        Position move = new Position(x, y);
        boolean positionIsFree = checkMoveWithFreePositionOnBoard(move);
        if (!positionIsFree) {
            throw new RuntimeException("Pozycja jest zajęta");
        }
        markPosition(move.getRowNumber(), move.getColumnNumber(), symbol);
    }

    private boolean checkMoveWithFreePositionOnBoard(Position move) {
        freePositions = findFreePositions();
        return freePositions.contains(move);
    }

    public void fillBoardEmptyPlace() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = Figures.EMPTY.getCharacter();
            }
        }
    }
//    public Board copy() {
//        Board copyBoard = new Board();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                copyBoard.markPosition(i, j, board[i][j]);
//            }
//        }
//        return copyBoard;
//    }

    //czekam na zatwierdzenie

}
