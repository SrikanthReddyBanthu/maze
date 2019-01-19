package uk.gov.dwp.maze.constants;

import uk.gov.dwp.maze.coordinates.Direction;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MazeConstants {

    public static final String FILE_NAME = "src/main/resources/maze1.txt";

    public static Map<Direction, Integer> X_COORDINATE_RULE = new HashMap<Direction, Integer>(){
        {
            put(Direction.LEFT, 0);
            put(Direction.RIGHT, 0);
            put(Direction.TOP, -1);
            put(Direction.BOTTOM, 1);
        }
    };

    public static Map<Direction, Integer> Y_COORDINATE_RULE = new HashMap<Direction, Integer>(){
        {
            put(Direction.LEFT, -1);
            put(Direction.RIGHT, 1);
            put(Direction.TOP, 0);
            put(Direction.BOTTOM, 0);
        }
    };


    public static Map<Direction, Direction> MAZE_OPPOSIT_DIRECTIONS = new LinkedHashMap<Direction, Direction>(){
        {
            put(Direction.LEFT, Direction.RIGHT);
            put(Direction.RIGHT, Direction.LEFT);
            put(Direction.TOP, Direction.BOTTOM);
            put(Direction.BOTTOM, Direction.TOP);
        }
    };



}
