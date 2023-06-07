package TicTacToe;

public class WinLogic {
    private Board board;
    private boolean win = false;
    private boolean gameContinues = true;

    public WinLogic(Board board) {
        this.board = board;
    }

    public WinLogic() {
    }

    public GameStatus checkWin() {
        for (char symbol : new char[]{board.CIRCLE, board.CROSS}) {
            for (int i = 0; i < board.board.length; i++) {
                if (checkSameSymbolInColumn(i, symbol) || checkSameSymbolInRow(i, symbol) ||
                        checkSameSymbolInMainDiagonal(symbol) || checkSameSymbolInSecondaryDiagonal(symbol)) {
                    win = true;
                    gameContinues = false;
                    return symbol == board.CIRCLE ? GameStatus.O_WON : GameStatus.X_WON;
                }
            }
        }
        return noEmptyFields() ? GameStatus.DRAW : GameStatus.ONGOING;
    }

    private boolean checkSameSymbolInColumn(int columnNumber, char symbol) {
        for (int i = 0; i < board.board.length; i++) {
            if (board.board[i][columnNumber] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSameSymbolInRow(int rowNumber, char symbol) {
        for (int i = 0; i < board.board.length; i++) {
            if (board.board[rowNumber][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSameSymbolInMainDiagonal(char symbol) {
        for (int i = 0; i < board.board.length; i++) {
            if (board.board[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSameSymbolInSecondaryDiagonal(char symbol) {
        for (int i = 0; i < board.board.length; i++) {
            if (board.board[i][2 - i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean noEmptyFields() {
        for (int i = 0; i < board.board.length; i++) {
            for (int j = 0; j < board.board[i].length; j++) {
                if (board.board[i][j] == board.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWin() {
        return win;
    }

    public boolean isGameContinues() {
        return gameContinues;
    }

    public void setGameContinues(boolean gameContinues) {
        this.gameContinues = gameContinues;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
