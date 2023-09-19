package TicTacToe;

import lombok.AllArgsConstructor;

import java.util.stream.IntStream;

@AllArgsConstructor
public class WinLogic {
    private Board board;

    public GameStatus checkWin() {
        if (checkWin(Figure.CIRCLE)) {
            return GameStatus.O_WON;
        }
        if (checkWin(Figure.CROSS)) {
            return GameStatus.X_WON;
        }
        if (emptyFieldsPresent() == 0) {
            return GameStatus.DRAW;
        }
        return GameStatus.ONGOING;
    }

    private boolean checkWin(Figure symbol) {
        char symbolChar = symbol.getCharacter();
        for (int i = 0; i < board.getBoardCopy().length; i++) {
            if (checkSameSymbolInColumn(i, symbolChar) || checkSameSymbolInRow(i, symbolChar) ||
                    checkSameSymbolInDiagonal(symbolChar, true) || checkSameSymbolInDiagonal(symbolChar, false)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkSameSymbolInColumn(int columnNumber, char symbol) {
        return IntStream.range(0, board.getBoardCopy().length)
                .allMatch(i -> board.getBoardCopy()[i][columnNumber] == symbol);
    }

    private boolean checkSameSymbolInRow(int rowNumber, char symbol) {
        return IntStream.range(0, board.getBoardCopy().length)
                .allMatch(i -> board.getBoardCopy()[rowNumber][i] == symbol);
    }

    private boolean checkSameSymbolInDiagonal(char symbol, boolean isMainDiagonal) {
        for (int i = 0; i < board.getBoardCopy().length; i++) {
            int j = isMainDiagonal ? i : board.getBoardCopy().length - 1 - i;
            if (board.getBoardCopy()[i][j] != symbol) {
                return false;
            }
        }
        return true;
    }

    private int emptyFieldsPresent() {
        return (int) IntStream.range(0, board.getBoardCopy().length)
                .flatMap(i -> IntStream.range(0, board.getBoardCopy()[i].length)
                        .filter(j -> board.getBoardCopy()[i][j] == Figure.EMPTY.getCharacter()))
                .count();
    }
}
