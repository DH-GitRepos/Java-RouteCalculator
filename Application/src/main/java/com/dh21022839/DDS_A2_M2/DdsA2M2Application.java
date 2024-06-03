package com.dh21022839.DDS_A2_M2;

import com.dh21022839.DDS_A2_M2.dto.RequestedPathDTO;
import com.dh21022839.DDS_A2_M2.mapping.Graph;
import com.dh21022839.DDS_A2_M2.mapping.Node;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;

import static com.dh21022839.DDS_A2_M2.util.utilities.getEdgeValue;
import static com.dh21022839.DDS_A2_M2.dijkstra.RouteCalculator.shortestPath;

@SpringBootApplication
public class DdsA2M2Application {

	public static void main(String[] args) {

		SpringApplication.run(DdsA2M2Application.class, args);

		// Create nodes for the graph
		Node nodeA = new Node("A", -13.5, 9.5);
		Node nodeB = new Node("B", 1.0, 6.0);
		Node nodeC = new Node("C", 10.5, 3.5);
		Node nodeD = new Node("D", -3.5, 0.5);
		Node nodeE = new Node("E", 4.0, -3.0);
		Node nodeF = new Node("F", 5.5, -10.0);

		Graph graph = new Graph();
		graph.updateGraph(nodeA, Map.of(nodeB, getEdgeValue(nodeA, nodeB), nodeD, getEdgeValue(nodeA, nodeD)));
		graph.updateGraph(nodeB, Map.of(nodeA, getEdgeValue(nodeB, nodeA), nodeC, getEdgeValue(nodeB, nodeC), nodeD, getEdgeValue(nodeB, nodeD), nodeE, getEdgeValue(nodeB, nodeE)));
		graph.updateGraph(nodeC, Map.of(nodeB, getEdgeValue(nodeC, nodeB), nodeE, getEdgeValue(nodeC, nodeE), nodeF, getEdgeValue(nodeC, nodeF)));
		graph.updateGraph(nodeD, Map.of(nodeA, getEdgeValue(nodeD, nodeA), nodeB, getEdgeValue(nodeD, nodeB), nodeE, getEdgeValue(nodeD, nodeE)));
		graph.updateGraph(nodeE, Map.of(nodeB, getEdgeValue(nodeE, nodeB), nodeC, getEdgeValue(nodeE, nodeC), nodeD, getEdgeValue(nodeE, nodeD), nodeF, getEdgeValue(nodeE, nodeF)));
		graph.updateGraph(nodeF, Map.of(nodeC, getEdgeValue(nodeF, nodeC), nodeE, getEdgeValue(nodeF, nodeE)));

		// Call the shortestPath method with the graph and starting node
		RequestedPathDTO shortestPath = shortestPath(graph.getGraph(), nodeA);

		// retrieve results from DTO
		Map<Node, List<Node>> paths = shortestPath.getPaths();
		Map<Node, Double> distances = shortestPath.getDistances();

		// Print the shortest paths from nodeA to all other nodes
		for (Node node : paths.keySet()) {
			System.out.println("Shortest path from A to " + node.getName() + ": " + paths.get(node) + " (distance: " + distances.get(node) + ")");
		}

	}

}
