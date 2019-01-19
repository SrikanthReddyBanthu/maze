package uk.gov.dwp.maze.parser;

import uk.gov.dwp.maze.coordinates.Position;
import uk.gov.dwp.maze.data.MazeData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static uk.gov.dwp.maze.constants.MazeConstants.FILE_NAME;

public class FileParser {


    public MazeData parseMazeData() throws IOException {

        final MazeData mazeData = new MazeData();
        final List<String> lines;

        try (Stream<String> stream = Files.lines(Paths.get(FILE_NAME))) {
            lines = stream.collect(Collectors.toList());
        }

        Position[][] maze = new Position[lines.size()][lines.get(0).length()];

        for (int y = 0; y < lines.size() ; y++) {
            char[] chars = lines.get(y).toCharArray();
            maze[y] = constructRow(chars, y, mazeData);
        }
        mazeData.setMaze(maze);
        return mazeData;
    }

    private Position[] constructRow(final char[] chars, final int row, final MazeData mazeData) {

        final Position[] maze = new Position[chars.length];

        for (int i = 0; i < chars.length; i++) {

            Position position = new Position(row, i, chars[i]);
            maze[i] = position;

            if (position.isExit()) {
                mazeData.setEnd(position);
            } else if (position.isStart()) {
                mazeData.setStart(position);
            }
        }

        return maze;
    }
}
