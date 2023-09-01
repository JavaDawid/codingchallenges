package TicTacToe;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return IntStream.range(0, board.length)
                .boxed()
                .flatMap(i -> IntStream.range(0, board[i].length).mapToObj(j -> new Position(i, j)))
                .filter(position -> board[position.getRowNumber()][position.getColumnNumber()] == Figures.EMPTY.getCharacter())
                .collect(Collectors.toList());
    }

    public boolean checkMoveWithFreePositionOnBoard(Position move) {
        List<Position> freePositions = findFreePositions();
        return freePositions.stream().anyMatch(position -> position.equals(move));
    }

    public void markMove(Position position, char symbol) {
        board[position.getRowNumber()][position.getColumnNumber()] = symbol;
    }

    private void fillBoardEmptyPlace() {
        IntStream.range(0, board.length)
                .forEach(i -> IntStream.range(0, board[i].length)
                        .forEach(j -> board[i][j] = Figures.EMPTY.getCharacter()));
    }
}
