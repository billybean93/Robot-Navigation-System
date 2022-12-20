package com.group.project.robot.strategy;

/**
 * The interface Search strategy.
 *
 * Strategy is a behavioral design pattern that lets you define a family of algorithms (search in our case),
 * put each of them into a separate class, and make their objects interchangeable.
 *
 * @param <SEARCH_SPACE> the generic type parameter of Search space (Ex: Graph, Grid and so on)
 * @param <NODE>         the generic type parameter of Search space element (Ex: Node, Tier and so on)
 */
public interface SearchStrategy<SEARCH_SPACE, NODE> {

  /**
   * Navigate.
   *
   * @param searchSpace      the search space
   * @param startNode        the start node
   */
  void search(SEARCH_SPACE searchSpace, NODE startNode);
}
