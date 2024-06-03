package com.dh21022839.DDS_A2_M2.dijkstra;

import com.dh21022839.DDS_A2_M2.dto.RequestedPathDTO;
import com.dh21022839.DDS_A2_M2.mapping.Node;
import java.util.*;

public class RouteCalculator {

    // IMPLEMENTATION OF DIJKSTRA'S ALGORITHM
    // Method to calculate the shortest path from the starting node to all other nodes in the graph
    public static RequestedPathDTO shortestPath(Map<Node, Map<Node, Double>> graph, Node start) {
        // Create a set of unvisited nodes and initialize distances and paths for all nodes
        Set<Node> unvisited = new HashSet<>();
        Map<Node, Double> distances = new HashMap<>();
        Map<Node, List<Node>> paths = new HashMap<>();

        // Initialize unvisited set and distances map
        for (Node node : graph.keySet()) {
            unvisited.add(node);
            distances.put(node, Double.MAX_VALUE); // max possible value to represent infinity
        }

        // Set distance to starting node to 0 and initialize its path
        distances.put(start, 0.0);
        paths.put(start, new ArrayList<>());

        // Loop until all nodes have been visited
        while (!unvisited.isEmpty()) {
            // Find the unvisited node with the smallest distance
            Node currentNode = null;
            double smallestDistance = Double.MAX_VALUE;

            // Loop through
            for (Node node : unvisited) {
                if (distances.get(node) < smallestDistance) {
                    smallestDistance = distances.get(node);
                    currentNode = node;
                }
            }

            // Remove current node from unvisited set
            unvisited.remove(currentNode);

            // Loop through all the neighbors of the current node and update their distances and paths if necessary
            for (Node neighborNode : graph.get(currentNode).keySet()) {
                // Calculate the tentative distance from the starting node to the neighbor node through the current node
                double tentativeDistance = distances.get(currentNode) + graph.get(currentNode).get(neighborNode);

                // If the tentative distance is smaller than the current distance, update the distance and path for the neighbor node
                if (tentativeDistance < distances.get(neighborNode)) {
                    // Update distance and path
                    distances.put(neighborNode, tentativeDistance);
                    List<Node> newPath = new ArrayList<>(paths.get(currentNode));
                    newPath.add(currentNode);
                    paths.put(neighborNode, newPath);

                    // Add the neighbor node to the unvisited set
                    unvisited.add(neighborNode);
                }
            }
        }

        // Return the paths from the starting node to all other nodes
        return new RequestedPathDTO(
                distances,
                paths);
    }

}