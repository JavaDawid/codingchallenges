package TicTacToe;

public class WinLogic {

    public boolean checkWin() {
        char symbol;

        for (int i = 0; i < Board.board.length; i++) {
            symbol = Board.board[i][0];
            if (symbol != ' ' && symbol == Board.board[i][1] && symbol == Board.board[i][2]) {
                checkWhoWin(symbol);
                return true;
            }
            symbol = Board.board[0][i];
            if (symbol != ' ' && symbol == Board.board[1][i] && symbol == Board.board[2][i]) {
                checkWhoWin(symbol);
                return true;
            }
        }
        symbol = Board.board[0][0];
        if (symbol != ' ' && symbol == Board.board[1][1] && symbol == Board.board[2][2]) {
            checkWhoWin(symbol);
            return true;
        }
        symbol = Board.board[0][2];
        if (symbol != ' ' && symbol == Board.board[1][1] && symbol == Board.board[2][0]) {
            checkWhoWin(symbol);
            return true;
        }
        return false;
    }

    private void checkWhoWin(char symbol) {
        if (symbol == Board.CIRCLE) {
            UserInterface.userIsAWinner();
        } else if (symbol == Board.CROSS) {
            UserInterface.computerIsAWinner();
        }
    }
}
