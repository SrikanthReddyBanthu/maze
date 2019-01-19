package uk.gov.dwp.maze.data;

import uk.gov.dwp.maze.coordinates.Position;

public class MazeData {

    private Position[][] maze;
    private Position start;
    private Position end;

    public Position[][] getMaze() {
        return maze;
    }

    public void setMaze(Position[][] maze) {
        this.maze = maze;
    }

    public Position getStart() {
        return start;
    }

    public void setStart(Position start) {
        this.start = start;
    }

    public Position getEnd() {
        return end;
    }

    public void setEnd(Position end) {
        this.end = end;
    }
}
