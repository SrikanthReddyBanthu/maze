package uk.gov.dwp.maze.parser;

import org.junit.Test;
import uk.gov.dwp.maze.coordinates.Position;
import uk.gov.dwp.maze.data.MazeData;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileParserTest {

    @Test
    public void shouldSetCorrectMazeWhenCallingParseMazeData() throws IOException {

        final FileParser fileParser = new FileParser();

        final MazeData mazeData = fileParser.parseMazeData();

        final Position[][] maze = mazeData.getMaze();
        assertEquals(maze.length, 15);
        final Position[] firstRow = maze[0];
        for (int i = 0; i < 15; i++) {
            assertEquals(firstRow[i].getCoordinateValue(), 'X');
        }
        assertEquals(maze[3][0].getCoordinateValue(), 'X');
        assertEquals(maze[3][1].getCoordinateValue(), ' ');
        assertEquals(maze[3][2].getCoordinateValue(), 'X');
        assertEquals(maze[3][3].getCoordinateValue(), 'S');
        Position[] lastRow = maze[14];
        assertEquals(lastRow.length, 15);
        assertEquals(lastRow[0].getCoordinateValue(), 'X');
        assertEquals(lastRow[1].getCoordinateValue(), 'F');
        for (int i = 2; i < 15; i++) {
            assertEquals(lastRow[i].getCoordinateValue(), 'X');
        }

    }

    @Test
    public void shouldSetCorrectStartAndEndPositionWhenCallingParseMazeData() throws IOException {

        final FileParser fileParser = new FileParser();

        final MazeData mazeData = fileParser.parseMazeData();

        final Position start = mazeData.getStart();
        final Position end = mazeData.getEnd();
        assertEquals(start.getRow(), 3);
        assertEquals(start.getColumn(), 3);
        assertEquals(start.getCoordinateValue(), 'S');
        assertEquals(end.getRow(), 14);
        assertEquals(end.getColumn(), 1);
        assertEquals(end.getCoordinateValue(), 'F');
    }
}
