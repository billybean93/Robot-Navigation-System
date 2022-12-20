package com.group.project.robot.utiils;

/**
 * The enum Direction.
 */
public enum Direction {
  /**
   * Down direction.
   */
  DOWN("DOWN", 1, 0),
  /**
   * Right direction.
   */
  RIGHT("RIGHT", 0, 1),
  /**
   * Up direction.
   */
  UP("UP", -1, 0),
  /**
   * Left direction.
   */
  LEFT("LEFT", 0, -1);

  /**
   * The Direction.
   */
  private final String direction;

  /**
   * The Delta row.
   */
  private final int deltaRow;

  /**
   * The Delta col.
   */
  private final int deltaCol;

  /**
   * Instantiates a new Direction.
   *
   * @param direction the direction
   * @param deltaRow  the delta row
   * @param deltaCol  the delta col
   */
  Direction(String direction, int deltaRow, int deltaCol) {
    this.direction = direction;
    this.deltaRow = deltaRow;
    this.deltaCol = deltaCol;
  }

  /**
   * Gets direction.
   *
   * @return the direction
   */
  public String getDirection() {
    return direction;
  }

  /**
   * Gets delta x.
   *
   * @return the delta x
   */
  public int getDeltaRow() {
    return deltaRow;
  }

  /**
   * Gets delta y.
   *
   * @return the delta y
   */
  public int getDeltaCol() {
    return deltaCol;
  }
}
