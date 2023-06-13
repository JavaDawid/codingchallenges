package TicTacToe;

import java.util.Objects;

public class Position {
    private final int rowNumber;
    private final int columnNumber;

    public Position(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return rowNumber == position.rowNumber && columnNumber == position.columnNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowNumber, columnNumber);
    }

    @Override
    public String toString() {
        return "Position{" +
                "rowNumber=" + rowNumber +
                ", columnNumber=" + columnNumber +
                '}';
    }
}
