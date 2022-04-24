package com.lyn.util.structure;

public class NodeRecord {
    public int distance;
    public Node node;

    public NodeRecord(Node node, int distance) {
        this.distance = distance;
        this.node = node;
    }

}
