package TicTacToe;

public class WinLogic {
    private Board board;

    public WinLogic(Board board) {
        this.board = board;
    }

    public GameStatus checkWin() {
        if (checkWin(Figures.CIRCLE)) {
            return GameStatus.O_WON;
        }
        if (checkWin(Figures.CROSS)) {
            return GameStatus.X_WON;
        }
        if (emptyFieldsPresent() == 0) {
            return GameStatus.DRAW;
        } else {
            return GameStatus.ONGOING;
        }
    }

    private boolean checkWin(Figures symbol) {
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
        for (int i = 0; i < board.getBoardCopy().length; i++) {
            if (board.getBoardCopy()[i][columnNumber] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSameSymbolInRow(int rowNumber, char symbol) {
        for (int i = 0; i < board.getBoardCopy().length; i++) {
            if (board.getBoardCopy()[rowNumber][i] != symbol) {
                return false;
            }
        }
        return true;
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
        int emptyFields = 0;
        for (int i = 0; i < board.getBoardCopy().length; i++) {
            for (int j = 0; j < board.getBoardCopy()[i].length; j++) {
                if (board.getBoardCopy()[i][j] == Figures.EMPTY.getCharacter()) {
                    emptyFields++;
                }
            }
        }
        return emptyFields;
    }
}
