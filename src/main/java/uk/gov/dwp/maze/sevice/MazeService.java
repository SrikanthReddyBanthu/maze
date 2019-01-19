package uk.gov.dwp.maze.sevice;

import uk.gov.dwp.maze.coordinates.Direction;
import uk.gov.dwp.maze.coordinates.Position;

import java.util.List;

public interface MazeService {

    Position getPosition(final Position[][] maze, final Position currentPosition, final Direction direction);
    List<Direction> getPossibleDirections(final Position[][] maze, final Position currentPosition, final Direction currentDirection);
}
