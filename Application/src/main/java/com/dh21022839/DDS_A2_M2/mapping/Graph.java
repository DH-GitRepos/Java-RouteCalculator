package com.dh21022839.DDS_A2_M2.mapping;

import lombok.Getter;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Graph
{
    private final Map<Node, Map<Node, Double>> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }

    public void updateGraph(Node node, Map<Node, Double> map)
    {
        this.graph.put(node, map);
    }

}
