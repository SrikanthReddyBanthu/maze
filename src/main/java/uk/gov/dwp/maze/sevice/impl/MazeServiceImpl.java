package uk.gov.dwp.maze.sevice.impl;

import uk.gov.dwp.maze.coordinates.Direction;
import uk.gov.dwp.maze.coordinates.Position;
import uk.gov.dwp.maze.sevice.MazeService;

import java.util.ArrayList;
import java.util.List;

import static uk.gov.dwp.maze.constants.MazeConstants.MAZE_OPPOSIT_DIRECTIONS;
import static uk.gov.dwp.maze.constants.MazeConstants.X_COORDINATE_RULE;
import static uk.gov.dwp.maze.constants.MazeConstants.Y_COORDINATE_RULE;

public class MazeServiceImpl implements MazeService {

    @Override
    public Position getPosition(final Position[][] maze, final Position currentPosition, final Direction direction) {

        int row = currentPosition.getRow() + X_COORDINATE_RULE.get(direction);
        int column = currentPosition.getColumn() + Y_COORDINATE_RULE.get(direction);
        return maze[row][column];
    }

    @Override
    public List<Direction> getPossibleDirections(final Position[][] maze,
                                                 final Position currentPosition,
                                                 final Direction currentDirection) {

        List<Direction> directions = new ArrayList<>();

        for (Direction direction: Direction.values()) {
            if (isValidDirectionMove(maze, currentPosition, direction)) {
                directions.add(direction);
            }
        }

        if (directions.contains(currentDirection)) {
            directions.remove(MAZE_OPPOSIT_DIRECTIONS.get(currentDirection));
        }

        return directions;
    }

    private boolean isValidDirectionMove(final Position[][] maze,
                                         final Position currentPosition,
                                         final Direction direction) {

        int row = currentPosition.getRow() + X_COORDINATE_RULE.get(direction);
        int column = currentPosition.getColumn() + Y_COORDINATE_RULE.get(direction);
        if (row < 0 || column < 0 || row >= maze.length || column >= maze[0].length) {
            return false;
        }
        Position position = maze[row][column];
        return position.isValidMove();
    }
}
