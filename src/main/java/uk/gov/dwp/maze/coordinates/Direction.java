package uk.gov.dwp.maze.coordinates;

public enum  Direction {
    LEFT("Left"), RIGHT("Right"), TOP("Top"), BOTTOM("Bottom");

    private String value;

    Direction(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
