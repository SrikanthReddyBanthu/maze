package uk.gov.dwp.maze.coordinates;

public class Position {

    private int row;
    private int column;
    private char coordinateValue;
    private State coordinateState;

    public Position(final int row, final int column, final char coordinateValue) {
        this.row = row;
        this.column = column;
        this.coordinateValue = coordinateValue;
        coordinateState = State.get(coordinateValue);
    }

    public boolean isStart() {
        return coordinateState == State.START;
    }

    public boolean isExit() {
        return coordinateState == State.EXIT;
    }

    public boolean isValidMove() {
        return coordinateState == State.OPEN
                || coordinateState == State.EXIT
                || coordinateState == State.START;
    }

    public boolean isNotValidMove() {
        return !isValidMove();
    }

    public char getCoordinateValue() {
        return coordinateValue;
    }

    public State getCoordinateState() {
        return coordinateState;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
