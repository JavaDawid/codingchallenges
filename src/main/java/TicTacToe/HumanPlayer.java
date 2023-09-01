package TicTacToe;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor
@AllArgsConstructor
public class HumanPlayer implements Player {
    private ScannerWrapper scannerWrapper;
    private Board board;
    private final List<Position> correctPositionsList = listWithCorrectMoves();

    @Override
    public void markMove(char symbol) {
        Position position;
        position = takePositionFromUser();
        if (!isCorrectPosition(position) || (!board.checkMoveWithFreePositionOnBoard(position))) {
            UserInterface.POSITION_IS_NOT_AVAILABLE();
        } else {
            board.markMove(position, symbol);

        }
    }


    private boolean isCorrectPosition(Position position) {
        return correctPositionsList.contains(position);
    }

    private Position takePositionFromUser() {
        do {
            try {
                int rowNumber = scannerWrapper.input();
                int columnNumber = scannerWrapper.input();
                return new Position(rowNumber, columnNumber);
            } catch (InputMismatchException e) {
                System.err.println(UserInterface.POSITION_IS_INCORRECT_WITH_GAME_RULES());
                scannerWrapper.cleaner();
            }
        } while (true);
    }

    /* zastanawiam się czy metoda listWithCorrectMoves powinna być w tej klasie
        czy może dla czytelności stworzyć nową klasę z tą metodą*/
    private List<Position> listWithCorrectMoves() {
        char[][] correctMovesBoard = new char[3][3];
        return IntStream.range(0, correctMovesBoard.length)
                .boxed()
                .flatMap(i -> IntStream.range(0, correctMovesBoard[i].length).mapToObj(j -> new Position(i, j)))
                .collect(Collectors.toList());
    }
}

