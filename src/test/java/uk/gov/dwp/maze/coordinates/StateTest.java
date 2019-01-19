package uk.gov.dwp.maze.coordinates;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateTest {

    @Test
    public void shouldReturnOpenWhenCoordinateValueIsWhiteSpace() {
        State actualState = State.get(' ');

        assertEquals(actualState, State.OPEN);
    }

    @Test
    public void shouldReturnOpenWhenCoordinateValueIsX() {
        State actualState = State.get('X');

        assertEquals(actualState, State.WALL);
    }

    @Test
    public void shouldReturnOpenWhenCoordinateValueIsS() {
        State actualState = State.get('S');

        assertEquals(actualState, State.START);
    }

    @Test
    public void shouldReturnOpenWhenCoordinateValueIsF() {
        State actualState = State.get('F');

        assertEquals(actualState, State.EXIT);
    }

    @Test
    public void shouldReturnOpenWhenCoordinateValueIsInvalidChar() {
        State actualState = State.get('A');

        assertEquals(actualState, State.INVALID);
    }
}
