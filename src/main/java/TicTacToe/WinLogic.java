package TicTacToe;

public class WinLogic {
    private Board board;
    private boolean gameContinues = true;

    public WinLogic(Board board) {
        this.board = board;
    }

    public WinLogic() {
    }

    public GameStatus checkWin() {
        for (char symbol : new char[]{Figures.CIRCLE.getCharacter(), Figures.CROSS.getCharacter()}) {
            for (int i = 0; i < board.getBoard().length; i++) {
                if (checkSameSymbolInColumn(i, symbol) || checkSameSymbolInRow(i, symbol) ||
                        checkSameSymbolInDiagonal(symbol, true) || checkSameSymbolInDiagonal(symbol, false)) {
                    gameContinues = true;
                    return symbol == Figures.CIRCLE.getCharacter() ? GameStatus.O_WON : GameStatus.X_WON;
                }
            }
        }
        return noEmptyFields() ? GameStatus.DRAW : GameStatus.ONGOING;
    }

    private boolean checkSameSymbolInColumn(int columnNumber, char symbol) {
        for (int i = 0; i < board.getBoard().length; i++) {
            if (board.getBoard()[i][columnNumber] != symbol) {
                return false;
            }
        }
        return true;
    }

//    private boolean checkSameSymbolColumn(int columnNumber, char symbol) {
//        return board.getBoard()[0][columnNumber] != symbol ||
//                board.getBoard()[1][columnNumber] != symbol ||
//                board.getBoard()[2][columnNumber] != symbol;
//    }
    //do zaakceptowania bo nie wiem czy o to chodzi

    private boolean checkSameSymbolInRow(int rowNumber, char symbol) {
        for (int i = 0; i < board.getBoard().length; i++) {
            if (board.getBoard()[rowNumber][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSameSymbolInDiagonal(char symbol, boolean isMainDiagonal) {
        for (int i = 0; i < board.getBoard().length; i++) {
            int j = isMainDiagonal ? i : board.getBoard().length - 1 - i;
            if (board.getBoard()[i][j] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean noEmptyFields() {
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                if (board.getBoard()[i][j] == Figures.EMPTY.getCharacter()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isGameContinues() {
        return gameContinues;
    }

    public void setGameContinues(boolean gameContinues) {
        this.gameContinues = gameContinues;
    }

}
