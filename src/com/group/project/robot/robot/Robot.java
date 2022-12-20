package com.group.project.robot.robot;

import com.group.project.robot.map.MapLoader;
import com.group.project.robot.maze.Maze;
import com.group.project.robot.strategy.SearchStrategy;
import com.group.project.robot.utiils.Node;
import java.io.IOException;

/**
 * <h1>Robot.</h1>
 * Robot will use Search strategy to find the path to exit.
 * @see SearchStrategy
 * @see Maze
 * @see Node
 */
public class Robot {

  /**
   * The Map file.
   */
  private final String mapFile;

  /**
   * The Search strategy.
   */
  private final SearchStrategy<Maze, Node> searchStrategy;

  /**
   * Instantiates a new Robot.
   *
   * @param mapFile        the map file
   * @param searchStrategy the search strategy
   */
  public Robot(String mapFile, SearchStrategy<Maze, Node> searchStrategy) {
    this.mapFile = mapFile;
    this.searchStrategy = searchStrategy;
  }

  /**
   * Navigate.
   */
  public void navigate() {

    // A maze is generated (your robot will NOT know anything about this)
    String[] map = loadMapFromFile();
    final int  mazeRow = map.length;
    final int mazeCol = map[0].length();
    Maze maze = new Maze(mazeRow, mazeCol, 1, 1, map);

    // The location of your robot is assigned (your robot will NOT know anything about this)
    Node startNode = new Node(1, 1);
    startNode.setStart(true);

    // The robot must try to make this counter as small as possible when it reaches the Exit gate
    this.searchStrategy.search(maze, startNode);
  }

  /**
   * Load map from file string [ ].
   *
   * @return the string [ ]
   */
  private String[] loadMapFromFile() {
    String[] map = new String[0];
    try {
      map = MapLoader.loadFromFile(this.mapFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return map;
  }

}
