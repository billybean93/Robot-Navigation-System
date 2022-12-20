package com.group.project.robot.strategy.impl;

import com.group.project.robot.maze.Maze;
import com.group.project.robot.strategy.SearchStrategy;
import com.group.project.robot.utiils.Direction;
import com.group.project.robot.utiils.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The type Depth first search strategy.
 * Main logic:
 * <pre>
 * // Returns true if target is reachable
 * bool findExits(nodeStart)
 *     if explore(node, path) is true
 *         return true
 *     return false
 *
 * bool explore(node, path)
 *     if (node is exit)
 *         return true;
 *
 *     foreach direction d of Directions
 *         childNode = action(d)
 *         if explore(childNode, path)
 *             return true
 *     return false
 * </pre>
 */
public class DepthFirstSearchStrategy
    implements SearchStrategy<Maze, Node> {

  /**
   * The Delay.
   */
  int delay = 1000;

  /**
   * The Maze.
   */
  private Maze maze;

  /**
   * The Visited.
   */
  private boolean[][] visited;

  /**
   * Navigate.
   *
   * @param maze      the maze
   * @param startNode the start node
   */
  public void search(Maze maze, Node startNode) {
    this.maze = maze;
    this.visited = new boolean[maze.getRows()][maze.getCols()];
    this.maze.draw(List.of(),this.visited, delay);
    final List<Node> paths = this.findExits(startNode);
    System.out.println(Arrays.toString(paths.toArray()));
  }

  /**
   * Find exits list.
   *
   * @param nodeStart the node start
   * @return the list
   */
  private List<Node> findExits(Node nodeStart) {
    // Initialize state
    List<Node> path = new ArrayList<>();

    // Explore search space
    if (explore(nodeStart, path)) {
      return path;
    }
    // Yield empty path if failed to search for solution
    return Collections.emptyList();
  }

  /**
   * Explore boolean.
   *
   * @param node the node
   * @param path the path
   * @return the boolean
   */
  private boolean explore(
      Node node, List<Node> path) {
    final int row = node.getRow();
    final int col = node.getCol();

    // Stop explore and yield false if node is blocked (by a wall),
    // Not in valid search space
    if (!this.maze.isValidLocation(row, col)
        || node.isBlocked()
        || this.visited[row][col]) {
      return false;
    }

    // Add to solution path and mark node as visited
    path.add(node);
    this.visited[row][col] = true;

    // if the exit is found stop explore and yield true
    if (node.isExit()) {
      return true;
    }

    // Expand to explore for each direction (UP, RIGHT, LEFT, DOWN)
    for (Direction direction : Direction.values()) {

      // Get state from maze and visualize
      // Anytime your robot calls to the go() method of Maze, a counter is increased
      String result = this.maze.go(direction.getDirection());
      // this.maze.draw(path, this.visited, delay);

      // Handle state and create new child node
      Node newNode = new Node(row + direction.getDeltaRow(), col + direction.getDeltaCol())
          .setParent(node)
          .setExit(result.equals("win"))
          .setBlocked(result.equals("false"));

      // if the exit is found stop explore and yield true
      // For the case: Find multiple path to exit point
      // => Eliminate this block
      if (newNode.isExit()) {
        return true;
      }

      // Explore the new child node
      if (explore(newNode, path)) {
        return true;
      }
    }

    // Remove path when all direction is explored (go backward)
    // And yield false
    path.remove(path.size() - 1);
    return false;
  }
}
