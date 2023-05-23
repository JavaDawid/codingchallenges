package TicTacToe;

public class WinLogic {


    public GameStatus checkWin() {
        for (char symbol : new char[]{Board.CIRCLE, Board.CROSS}) {
            for (int i = 0; i < Board.board.length; i++) {
                if (checkSameSymbolInColumn(i, symbol) || checkSameSymbolInRow(i, symbol) ||
                        checkSameSymbolInMainDiagonal(symbol) || checkSameSymbolInSecondaryDiagonal(symbol)) {
                    return symbol == Board.CIRCLE ? GameStatus.O_WON : GameStatus.X_WON;
                }
            }
        }
        if (noEmptyFields()) {
            return GameStatus.DRAW;
        }
        return GameStatus.ONGOING;
    }

    private boolean noEmptyFields() {
        for (int i = 0; i < Board.board.length; i++) {
            for (int j = 0; j < Board.board.length; j++) {
                if (Board.board[i][j] == Board.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkSameSymbolInColumn(int columnNumber, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (Board.board[i][columnNumber] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSameSymbolInRow(int rowNumber, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (Board.board[rowNumber][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSameSymbolInMainDiagonal(char symbol) {
        for (int i = 0; i < Board.board.length; i++) {
            if (Board.board[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSameSymbolInSecondaryDiagonal(char symbol) {
        for (int i = 0; i < Board.board.length; i++) {
            if (Board.board[i][2 - i] != symbol) {
                return false;
            }
        }
        return true;
    }
}
