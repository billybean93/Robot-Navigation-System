package com.group.project.robot.utiils;

/**
 * The type Node.
 */
public class Node {

  /**
   * The Row.
   */
  private final int row;

  /**
   * The Col.
   */
  private final int col;

  /**
   * The Blocked.
   */
  private boolean blocked = false;

  /**
   * The Exit.
   */
  private boolean exit = false;

  /**
   * The Start.
   */
  private boolean start = false;

  /**
   * The Parent.
   */
  private Node parent = null;

  /**
   * Instantiates a new Node.
   *
   * @param row the row
   * @param col the col
   */
  public Node(int row, int col) {
    this.row = row;
    this.col = col;
  }

  /**
   * Equals boolean.
   *
   * @param obj the obj
   * @return the boolean
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Node other = (Node) obj;
    if (row != other.row) {
      return false;
    }
    return col == other.col;
  }

  /**
   * Gets row.
   *
   * @return the row
   */
  public int getRow() {
    return row;
  }

  /**
   * Gets col.
   *
   * @return the col
   */
  public int getCol() {
    return col;
  }

  /**
   * Is blocked boolean.
   *
   * @return the boolean
   */
  public boolean isBlocked() {
    return blocked;
  }

  /**
   * Is exit boolean.
   *
   * @return the boolean
   */
  public boolean isExit() {
    return exit;
  }

  /**
   * Is start boolean.
   *
   * @return the boolean
   */
  public boolean isStart() {
    return start;
  }

  /**
   * Sets start.
   *
   * @param start the start
   */
  public void setStart(boolean start) {
    this.start = start;
  }


  /**
   * Sets blocked.
   *
   * @param blocked the blocked
   * @return the blocked
   */
  public Node setBlocked(boolean blocked) {
    this.blocked = blocked;
    return this;
  }

  /**
   * Sets exit.
   *
   * @param exit the exit
   * @return the exit
   */
  public Node setExit(boolean exit) {
    this.exit = exit;
    return this;
  }

  /**
   * Sets parent.
   *
   * @param parent the parent
   * @return the parent
   */
  public Node setParent(Node parent) {
    this.parent = parent;
    return this;
  }

  /**
   * To string string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "Node{" +
        "row=" + row +
        ", col=" + col +
        '}';
  }
}
