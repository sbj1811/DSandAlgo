package com.sjani.java.Graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DisjointSet {

    private Map<Long, Node> map = new HashMap<>();

    public void printSet(){
        System.out.println(getPrintSet());
    }

    public String getPrintSet() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<Long, Node>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Long, Node> entry = iter.next();
            sb.append(entry.getKey());
            sb.append('=').append(" data: ");
            sb.append(entry.getValue().data);
            sb.append(", parent: ");
            sb.append(entry.getValue().parent.data);
            sb.append(", rank: ");
            sb.append(entry.getValue().rank);
            sb.append("\n");
        }
        return sb.toString();

    }

    public void makeSet(long data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }

    public long find(long x) {
        return find(map.get(x)).data;
    }

    private Node find(Node x) {
        Node parent = x.parent;
        if (parent == x) {
            return x;
        } else {
            x.parent = find(x.parent);
            return x.parent;
        }
    }

    public void union(long x, long y) {
        Node xRep = map.get(x);
        Node yRep = map.get(y);

        Node p1 = find(xRep);
        Node p2 = find(yRep);

        if (p1.data == p2.data) return;
        if (p1.rank >= p2.rank) {
            p1.rank = (p1.rank == p2.rank) ? p1.rank + 1 : p1.rank;
            p2.parent = p1;
        } else {
            p1.parent = p2;
        }
    }

    class Node {
        long data;
        Node parent;
        int rank;
    }

}
