package com.group.project.robot.map;

import com.group.project.robot.utiils.Node;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Map loader.
 */
public class MapLoader {

  /**
   * Load from file string [ ].
   *
   * @param fileName the file name
   * @return the string [ ]
   * @throws IOException the io exception
   */
  public static String[] loadFromFile(String fileName) throws IOException {
    List<String> stringList = new ArrayList<>();
    URL url = MapLoader.class.getResource(fileName);
    assert url != null;
    File file = new File(url.getPath());
    BufferedReader br = new BufferedReader(new FileReader(file));
    String st;
    while ((st = br.readLine()) != null) {
      stringList.add(st);
    }
    return stringList.toArray(new String[0]);
  }

  /**
   * Map to nodes node [ ] [ ].
   *
   * @param map the map
   * @return the node [ ] [ ]
   */
  public static Node[][] mapToNodes(String[] map) {
    int rows = map.length;
    int cols = map[0].length();
    Node[][] nodes = new Node[rows][cols];
    for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
      for (int colIndex = 0; colIndex < cols; colIndex++) {
        Node node = new Node(rowIndex, colIndex);
        nodes[rowIndex][colIndex] = node;
      }
    }
    return nodes;
  }
}
