package com.lyn.util;

import com.lyn.util.structure.Edge;
import com.lyn.util.structure.Graph;
import com.lyn.util.structure.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GraphGenerator {

    /*
     * 生成图结构
     * matrix所有的边
     * N*3的矩阵
     * 【weight,from,to】
     * */
    public static Graph creatGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            if (graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }

    public static void bfs(Node node){
        if (node == null) {
            return;
        }
        Queue<Node>queue=new LinkedList<>();
        HashSet<Node>set=new HashSet<>();
        queue.add(node);
        set.add(node);

    }
}
