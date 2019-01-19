package uk.gov.dwp.maze;

import uk.gov.dwp.maze.coordinates.Direction;
import uk.gov.dwp.maze.coordinates.Position;
import uk.gov.dwp.maze.data.MazeData;
import uk.gov.dwp.maze.parser.FileParser;
import uk.gov.dwp.maze.sevice.MazeService;
import uk.gov.dwp.maze.sevice.impl.MazeServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Explorer {

    private final FileParser fileParser = new FileParser();
    private final MazeService mazeService = new MazeServiceImpl();

    public void startApplication() throws IOException {
        final MazeData mazeData = fileParser.parseMazeData();
        final Position[][] positions = mazeData.getMaze();
        final Scanner scanner = new Scanner(System.in);

        Direction currentDirection = Direction.TOP;
        Position currentPosition = mazeData.getStart();
        printMaze(positions, currentPosition);
        printMove(currentDirection, currentPosition);
        List<Direction> nextDirections = new ArrayList<>();
        nextDirections.add(currentDirection);

        do {

            try {
                if (nextDirections.size() > 1) {
                    printMaze(positions, currentPosition);
                    System.out.println("\nFound multiple routes. Possible directions are:");
                    nextDirections.stream().forEach(System.out::println);

                    System.out.println("\nPlease choose one of options below. Input value should be number");
                    for (int i = 0; i < nextDirections.size(); i++) {
                        System.out.println(i + 1 + ". Move " + nextDirections.get(i));
                    }
                    System.out.println("5. Find Possible moves");
                    System.out.println("6. Find coordinates");
                    System.out.println("7. Exit");
                    Integer input = Integer.valueOf(scanner.next());

                    switch (input) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            if (input > nextDirections.size()) {
                                System.out.println("Invalid Input, please try again.");
                                break;
                            }
                            final Direction direction = nextDirections.get(input - 1);
                            final Position nextMove = mazeService.getPosition(positions, currentPosition, direction);
                            if (nextMove.isNotValidMove()) {
                                System.out.println("Move is not valid to direction: " + currentDirection.getValue() + ". Coordinates -> X: " + nextMove.getRow() + " Y:" + nextMove.getColumn());
                            } else {
                                System.out.println("Changed to new position x:" + nextMove.getRow() + ", y:" + nextMove.getColumn());
                                currentDirection = direction;
                                currentPosition = nextMove;
                                printMove(currentDirection, currentPosition);
                            }
                            break;
                        case 5:
                            printPossibleDirections(positions, currentDirection, currentPosition);
                            break;
                        case 6:
                            findAndPrintStateByCoordinates(positions, scanner);
                            break;
                        case 7: System.exit(0);
                    }

                } else {
                    final Position nextMove = mazeService.getPosition(positions, currentPosition, nextDirections.get(0));
                    if (nextMove.isNotValidMove()) {
                        System.out.println("Move is not valid to direction: " + currentDirection.getValue() + ". Coordinates -> X: " + nextMove.getRow() + " Y:" + nextMove.getColumn());
                    } else {
                        currentDirection = nextDirections.get(0);
                        currentPosition = nextMove;
                        printMove(currentDirection, currentPosition);
                    }
                }

                if (currentPosition.isExit()) {
                    printMaze(positions, currentPosition);
                    System.out.println("\nGame over. You have successfully finished game!!!");
                    System.exit(0);
                }
                nextDirections = mazeService.getPossibleDirections(positions, currentPosition, currentDirection);
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input provided. Please try again");
            } catch (Exception e) {
                System.out.println("Exception while processing application. Message:" + e.getMessage());
                System.exit(0);
            }

        } while(true);
    }

    private void printPossibleDirections(Position[][] positions, Direction currentDirection, Position currentPosition) {
        final List<Direction> possibleDirections = mazeService.getPossibleDirections(positions, currentPosition, currentDirection);
        printMaze(positions, currentPosition);
        if (possibleDirections.size() > 0) {
            System.out.println("Possible directions");
            possibleDirections.stream().forEach(System.out::println);
        } else {
            System.out.println("Sorry there is no possible direction to move");
        }
    }

    private void findAndPrintStateByCoordinates(final Position[][] positions, final Scanner scanner) {
        System.out.println("Enter x axis co-ordinate:");
        Integer xAxisPosition = Integer.valueOf(scanner.next());
        System.out.println("Enter y axis co-ordinate:");
        Integer yAxisPosition = Integer.valueOf(scanner.next());
        String state = positions[yAxisPosition][xAxisPosition].getCoordinateState().getValue();
        System.out.println("Current state at with given co-ordinates is " + state);
    }

    private void printMove(final Direction direction, final Position position) {
        System.out.println("Current direction: " + direction.getValue() + ". Moving to coordinates -> X: " + position.getRow() + " Y:" + position.getColumn());
    }

    private void printMaze(final Position[][] maze, final Position currentPosition) {
        System.out.println("\nMAZE\n----\n");
        for (int x=0; x < maze.length; x++) {
            for (int y = 0; y < maze[x].length; y++) {
                if (currentPosition.getRow() == x && currentPosition.getColumn() == y) {
                    System.out.print("*");
                } else {
                    System.out.print(maze[x][y].getCoordinateValue());
                }
            }
            System.out.println();
        }
    }

}
