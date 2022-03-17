package com.lyn.util.structure;

/*
 * 前缀树节点
 * */
public class TrieNode {
    public int pass;
    public int end;
    public TrieNode[] nexts;//HashMap<Node,Integer>

    public TrieNode() {
        pass = 0;
        end = 0;
        nexts = new TrieNode[26];
    }
}
