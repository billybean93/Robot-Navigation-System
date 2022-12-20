package com.group.project.robot.maze;

import com.group.project.robot.utiils.Node;
import java.util.List;

/**
 * The type Maze.
 */
public class Maze {

  /**
   * The Rows.
   */
  private final int rows;

  /**
   * The Cols.
   */
  private final int cols;

  /**
   * The Map.
   */
  private final String[] map;

  /**
   * The Robot row.
   */
  private int robotRow;

  /**
   * The Robot col.
   */
  private int robotCol;

  /**
   * The Steps.
   */
  private int steps;

  /**
   * Instantiates a new Maze.
   *
   * @param rows     the rows
   * @param cols     the cols
   * @param robotRow the robot row
   * @param robotCol the robot col
   * @param map      the map
   */
  public Maze(int rows, int cols, int robotRow, int robotCol, String[] map) {
    this.rows = rows;
    this.cols = cols;
    this.map = map;
    this.robotRow = robotRow;
    this.robotCol = robotCol;
    this.steps = 0;
    this.validateMazeCreation();
  }

  /**
   * Validate maze creation.
   */
  private void validateMazeCreation() {
    if (rows < 0 || rows > 1000) {
      throw new IllegalArgumentException("Row is invalid");
    }

    if (cols < 0 || cols > 1000) {
      throw new IllegalArgumentException("Col is invalid");
    }

    if (robotRow < 0 || robotRow > rows) {
      throw new IllegalArgumentException("Row of robot is invalid");
    }

    if (robotCol < 0 || robotCol > cols) {
      throw new IllegalArgumentException("Col of robot  is invalid");
    }
  }

  /**
   * Go string.
   *
   * @param direction the direction
   * @return the string
   */
  public String go(String direction) {
    if (!direction.equals("UP") &&
        !direction.equals("DOWN") &&
        !direction.equals("LEFT") &&
        !direction.equals("RIGHT")) {
      // invalid direction
      steps++;
      return "false";
    }
    int currentRow = robotRow;
    int currentCol = robotCol;
    switch (direction) {
      case "UP":
        currentRow--;
        System.out.printf("Step %d : UP%n", steps + 1);
        break;
      case "DOWN":
        currentRow++;
        System.out.printf("Step %d : DOWN%n", steps + 1);
        break;
      case "LEFT":
        currentCol--;
        System.out.printf("Step %d : LEFT%n", steps + 1);
        break;
      default:
        currentCol++;
        System.out.printf("Step %d : RIGHT%n", steps + 1);
        break;
    }

    // check the next position
    if (map[currentRow].charAt(currentCol) == 'X') {
      // Exit gate
      steps++;
      System.out.println("Steps to reach the Exit gate " + steps);
      return "win";
    } else if (map[currentRow].charAt(currentCol) == '.') {
      // Wall
      steps++;
      return "false";
    } else {
      // Space => update robot location
      steps++;
      robotRow = currentRow;
      robotCol = currentCol;
      return "true";
    }
  }

  /**
   * Gets rows.
   *
   * @return the rows
   */
  public int getRows() {
    return rows;
  }

  /**
   * Gets cols.
   *
   * @return the cols
   */
  public int getCols() {
    return cols;
  }

  /**
   * Draw.
   *
   * @param path    the path
   * @param visited the visited
   * @param delay   the delay
   */
  public void draw(List<Node> path, boolean[][] visited, long delay) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length(); j++) {
        int finalI = i;
        int finalJ = j;
        if (path != null && path.stream()
            .anyMatch(n -> n.getRow() == finalI && n.getCol() == finalJ)) {
          System.out.print('R');
        } else if (visited != null && visited[i][j]) {
          System.out.print('*');
        } else {
          System.out.print(map[i].charAt(j));
        }
      }
      System.out.println();
    }
    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Is valid location boolean.
   *
   * @param row the row
   * @param col the col
   * @return the boolean
   */
  public boolean isValidLocation(int row, int col) {
    return row >= 0 && row < this.getRows()
        && col >= 0 && col < this.getCols();
  }
}
