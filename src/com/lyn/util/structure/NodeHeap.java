package com.lyn.util.structure;


import java.util.HashMap;

//改写堆
public class NodeHeap {
    private static Node[] nodes;
    private static HashMap<Node, Integer> ditanceMap;//堆
    private HashMap<Node, Integer> heapIndexMap;//堆索引
    private int size;

    public NodeHeap(int size) {
        nodes = new Node[size];
        heapIndexMap = new HashMap<>();
        ditanceMap = new HashMap<>();
        this.size = 0;
    }

    public static void heapify(int root, int heapSize) {
        int left = root * 2 + 1;

        // while (left < heapSize){
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addOrUpdateOrIgnore(Node head, int distance) {
        if (inHeap(head)) {
            ditanceMap.put(head, Math.min(ditanceMap.get(head), distance));//ditanceMap.get(head)表示该节点之前的距离 distance表示该节点现在的新距离
            insertHeapify(head, heapIndexMap.get(head));
        }
        if (!isEntered(head)) {
            nodes[size] = head;
            heapIndexMap.put(head, size);
            heapIndexMap.put(head, distance);
            insertHeapify(head, size++);
        }
    }

    private void insertHeapify(Node head, Integer index) {
        while (ditanceMap.get(nodes[index]) < ditanceMap.get(nodes[index - 1]) / 2) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;

        }
    }

    public boolean isEntered(Node node) {

        return heapIndexMap.containsKey(node);
    }

    //节点进来过 并且在堆上
    public boolean inHeap(Node node) {

        return isEntered(node) && heapIndexMap.get(node) != -1;
    }

    public void swap(int index1, int index2) {
        heapIndexMap.put(nodes[index1], index2);
        heapIndexMap.put(nodes[index2], index1);
        Node temp = nodes[index1];
        nodes[index1] = nodes[index2];
        nodes[index2] = temp;
    }

    public NodeRecord pop() {
        NodeRecord nodeRecord = new NodeRecord(nodes[0], ditanceMap.get(nodes[0]));
        swap(0, size - 1);
        heapIndexMap.put(nodes[size - 1], -1);
        ditanceMap.remove(nodes[size - 1]);
        nodes[size - 1] = null;
        heapify(0, --size);

        return nodeRecord;
    }
}
