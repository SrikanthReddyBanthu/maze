package uk.gov.dwp.maze.coordinates;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PositionTest {


    @Test
    public void shouldReturnFalseWhenNotStartStateOnCallingIsStart() {
        final Position position = new Position(10, 20, 'F');

        assertFalse(position.isStart());
    }

    @Test
    public void shouldReturnTrueWhenStartStateOnCallingIsStart() {
        final Position position = new Position(10, 20, 'S');

        assertTrue(position.isStart());
    }

    @Test
    public void shouldReturnFalseWhenNotExitStateOnCallingIsExit() {
        final Position position = new Position(10, 20, ' ');

        assertFalse(position.isExit());
    }

    @Test
    public void shouldReturnTrueWhenExitStateOnCallingIsExit() {
        final Position position = new Position(10, 20, 'F');

        assertTrue(position.isExit());
    }

    @Test
    public void shouldReturnTrueWhenOpenStateOnCallingIsValidMove() {
        final Position position = new Position(10, 20, ' ');

        assertTrue(position.isValidMove());
    }

    @Test
    public void shouldReturnTrueWhenExitStateOnCallingIsValidMove() {
        final Position position = new Position(10, 20, 'F');

        assertTrue(position.isValidMove());
    }

    @Test
    public void shouldReturnTrueWhenStartStateOnCallingIsValidMove() {
        final Position position = new Position(10, 20, 'S');

        assertTrue(position.isValidMove());
    }

    @Test
    public void shouldReturnFalseWhenWallStateOnCallingIsValidMove() {
        final Position position = new Position(10, 20, 'X');

        assertFalse(position.isValidMove());
    }

    @Test
    public void shouldReturnFalseWhenUnknownStateOnCallingIsValidMove() {
        final Position position = new Position(10, 20, 's');

        assertFalse(position.isValidMove());
    }

    @Test
    public void shouldReturnTrueWhenNotValidMoveOnCallingIsNotValidMove() {
        final Position position = new Position(10, 20, 's');

        assertTrue(position.isNotValidMove());
    }

    @Test
    public void shouldReturnFalseWhenValidMoveOnCallingIsNotValidMove() {
        final Position position = new Position(10, 20, 'F');

        assertFalse(position.isNotValidMove());
    }

}
