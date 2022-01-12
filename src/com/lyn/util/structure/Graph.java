package com.lyn.util.structure;

import java.util.HashMap;
import java.util.HashSet;
//图
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
