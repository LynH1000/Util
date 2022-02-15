package com.lyn.util;

import com.lyn.util.structure.Edge;
import com.lyn.util.structure.Graph;
import com.lyn.util.structure.Node;

import java.util.*;

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

    //宽度优先
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next :
                    cur.nexts) {
                if (set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }

    }

    //广度优先
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    break;
                }
            }
        }
    }

    public static List<Node> sortedToplogy(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) ;
            }
        }

        return result;
    }

    public static HashMap<Node, Integer> dijkstra(Node head) {

        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        HashSet<Node> selectNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnSelectedNode(distanceMap, selectNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge :
                    minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                }
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
            }
            selectNodes.add(minNode);
            minNode = getMinDistanceAndUnSelectedNode(distanceMap, selectNodes);
        }
        return distanceMap;


    }


    private static Node getMinDistanceAndUnSelectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!selectNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
