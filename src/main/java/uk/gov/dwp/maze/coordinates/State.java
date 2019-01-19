package uk.gov.dwp.maze.coordinates;

public enum State {

    OPEN("Open"), WALL("Wall"), START("Start"), EXIT("Exit"), INVALID("Invalid");

    private String value;

    State(String value) {
     this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static State get(final char coordinateValue) {
        if (coordinateValue == ' ')
            return OPEN;
        else if (coordinateValue == 'X')
            return WALL;
        else if (coordinateValue == 'S')
            return START;
        else if (coordinateValue == 'F')
            return EXIT;
        else
            return INVALID;
    }

}