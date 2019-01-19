package uk.gov.dwp.maze.sevice.impl;

import org.junit.Test;
import uk.gov.dwp.maze.coordinates.Direction;
import uk.gov.dwp.maze.coordinates.Position;
import uk.gov.dwp.maze.data.MazeData;
import uk.gov.dwp.maze.parser.FileParser;
import uk.gov.dwp.maze.sevice.MazeService;

import java.io.IOException;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


public class MazeServiceImplTest {

    private MazeService mazeService = new MazeServiceImpl();
    private final FileParser fileParser = new FileParser();

    @Test
    public void shouldReturnCorrectPositionOnCallingGetPositionWhenDirectionLeft() throws IOException {
        final MazeData mazeData = fileParser.parseMazeData();
        final Position currentPosition = new Position(3, 3,' ');

        Position position = mazeService.getPosition(mazeData.getMaze(), currentPosition, Direction.LEFT);
        assertEquals(position.getRow(), 3);
        assertEquals(position.getColumn(), 2);
    }

    @Test
    public void shouldReturnCorrectPositionOnCallingGetPositionWhenDirectionRight() throws IOException {
        final MazeData mazeData = fileParser.parseMazeData();
        final Position currentPosition = new Position(3, 3,' ');

        Position position = mazeService.getPosition(mazeData.getMaze(), currentPosition, Direction.RIGHT);
        assertEquals(position.getRow(), 3);
        assertEquals(position.getColumn(), 4);
    }

    @Test
    public void shouldReturnCorrectPositionOnCallingGetPositionWhenDirectionTop() throws IOException {
        final MazeData mazeData = fileParser.parseMazeData();
        final Position currentPosition = new Position(3, 3,' ');

        Position position = mazeService.getPosition(mazeData.getMaze(), currentPosition, Direction.TOP);
        assertEquals(position.getRow(), 2);
        assertEquals(position.getColumn(), 3);
    }

    @Test
    public void shouldReturnCorrectPositionOnCallingGetPositionWhenDirectionBottom() throws IOException {
        final MazeData mazeData = fileParser.parseMazeData();
        final Position currentPosition = new Position(3, 3,' ');

        Position position = mazeService.getPosition(mazeData.getMaze(), currentPosition, Direction.BOTTOM);
        assertEquals(position.getRow(), 4);
        assertEquals(position.getColumn(), 3);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowExceptionOnCallingGetPositionWhenInvalidDirection() throws IOException {
        final MazeData mazeData = fileParser.parseMazeData();
        final Position currentPosition = new Position(0, 0,' ');

        mazeService.getPosition(mazeData.getMaze(), currentPosition, Direction.TOP);
    }

    @Test
    public void shouldReturnCorrectDirectionOnCallingGetPossibleDirectionsWhenBottomDirection() throws IOException {
        final MazeData mazeData = fileParser.parseMazeData();
        final Position currentPosition = new Position(3, 3,' ');

        List<Direction> directions = mazeService.getPossibleDirections(mazeData.getMaze(), currentPosition, Direction.BOTTOM);

        assertThat(directions).hasSize(1);
        assertThat(directions.get(0)).isEqualTo(Direction.RIGHT);
    }

    @Test
    public void shouldNotReturnLeftDirectionOnCallingGetPossibleDirectionsWhenRightAndLeftDirectionsAreValid() throws IOException {
        final MazeData mazeData = fileParser.parseMazeData();
        final Position currentPosition = new Position(3, 5,' ');

        List<Direction> directions = mazeService.getPossibleDirections(mazeData.getMaze(), currentPosition, Direction.RIGHT);

        assertThat(directions).hasSize(1);
        assertThat(directions.get(0)).isEqualTo(Direction.RIGHT);
    }

    @Test
    public void shouldReturnCorrectDirectionOnCallingGetPossibleDirectionsWhenTopDirectionTopRow() throws IOException {
        final MazeData mazeData = fileParser.parseMazeData();
        final Position currentPosition = new Position(0, 3,' ');

        List<Direction> directions = mazeService.getPossibleDirections(mazeData.getMaze(), currentPosition, Direction.TOP);

        assertThat(directions).hasSize(1);
        assertThat(directions.get(0)).isEqualTo(Direction.BOTTOM);
    }

    @Test
    public void shouldReturnCorrectDirectionOnCallingGetPossibleDirectionsWhenBottomDirectionBottomRow() throws IOException {
        final MazeData mazeData = fileParser.parseMazeData();
        final Position currentPosition = new Position(14, 1,' ');

        List<Direction> directions = mazeService.getPossibleDirections(mazeData.getMaze(), currentPosition, Direction.BOTTOM);

        assertThat(directions).hasSize(1);
        assertThat(directions.get(0)).isEqualTo(Direction.TOP);
    }

    @Test
    public void shouldReturnCorrectDirectionOnCallingGetPossibleDirectionsWhenLeftValid() throws IOException {
        final MazeData mazeData = fileParser.parseMazeData();
        final Position currentPosition = new Position(1, 14,' ');

        List<Direction> directions = mazeService.getPossibleDirections(mazeData.getMaze(), currentPosition, Direction.RIGHT);

        assertThat(directions).hasSize(1);
        assertThat(directions.get(0)).isEqualTo(Direction.LEFT);
    }

    @Test
    public void shouldReturnMultipleDirectionsOnCallingGetPossibleDirectionsWhenLeftValid() throws IOException {
        final MazeData mazeData = fileParser.parseMazeData();
        final Position currentPosition = new Position(1, 13,' ');

        List<Direction> directions = mazeService.getPossibleDirections(mazeData.getMaze(), currentPosition, Direction.TOP);

        assertThat(directions).hasSize(2);
        assertThat(directions.get(0)).isEqualTo(Direction.LEFT);
        assertThat(directions.get(1)).isEqualTo(Direction.BOTTOM);
    }

}