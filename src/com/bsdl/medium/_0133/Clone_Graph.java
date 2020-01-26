package com.bsdl.medium._0133;

import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }  
}
*/


class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }  
}


class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Deque<Node> que = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        que.offer(node);
        while(!que.isEmpty()) {
            Node vertex = que.poll();
            for(Node n: vertex.neighbors) {
                if(!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    que.offer(n);
                }
                map.get(vertex).neighbors.add(map.get(n));
            }
        }
        return newNode;
    }
}