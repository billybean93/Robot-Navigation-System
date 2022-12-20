package com.group.project.robot;

import com.group.project.robot.robot.Robot;
import com.group.project.robot.strategy.impl.DepthFirstSearchStrategy;
import com.group.project.robot.strategy.impl.IterativeDeepeningSearchStrategy;

/**
 * The type Main.
 */
public class Main {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {

    // The files of map inside ./src/com/group/project/robot/map
    // There are three available map layouts: "map_01.txt", "map_02.txt", "map_03.txt"
    String mapFile = "map_02.txt";

    long startTime = System.currentTimeMillis();
    // An instance of your Robot class is created
    Robot robot = new Robot(mapFile, new DepthFirstSearchStrategy());

    // The navigate() method of the Robot instance will be called
    robot.navigate();
    long endTime   = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.printf("Elapsed time : %d ms %n", totalTime);

    startTime = System.currentTimeMillis();
    // An instance of your Robot class is created
    robot = new Robot(mapFile, new IterativeDeepeningSearchStrategy());

    // The navigate() method of the Robot instance will be called
    robot.navigate();
    endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    System.out.printf("Elapsed time : %d ms %n", totalTime);

  }
}
