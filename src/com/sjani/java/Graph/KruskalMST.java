package com.sjani.java.Graph;


import java.util.*;
import com.sjani.java.Graph.Graph.*;

public class KruskalMST {

    public class EdgeComparator implements Comparator<Edge<Integer>> {
        @Override
        public int compare(Edge<Integer> edge1, Edge<Integer> edge2) {
            if (edge1.getWeight() <= edge2.getWeight()) {
                return -1;
            } else {
                return 1;
            }
        }
    }


    public void getMST (Graph<Integer> graph) {

        List<Edge<Integer>> allEdges = graph.getAllEdges();
        EdgeComparator edgeComparator = new EdgeComparator();
        //Sort edges on weight
        Collections.sort(allEdges, edgeComparator);

        //Make a Set and parent to itself
        DisjointSet djs = new DisjointSet();

        for (Vertex<Integer> vertex : graph.getAllVertices()) {
            djs.makeSet(vertex.getId());
        }

        // Result edges
        ArrayList<Edge> mst = new ArrayList<>();


        for (Edge<Integer> edge : allEdges) {
            long x = djs.find(edge.getSrc().getId());
            long y = djs.find(edge.getDest().getId());

            //check if edge creates a cycle
            if (x != y) {
                mst.add(edge);
                djs.union(x, y);
            }
        }
        System.out.println("KruskalMST:");
        graph.printGraph(mst);

    }

    public static void main(String[] args) {


        KruskalMST kruskalMST = new KruskalMST();
        Graph<Integer> graph = new Graph(false);


        graph.addEdge(0,1,10);
        graph.addEdge(0,2,6);
        graph.addEdge(0,3,5);
        graph.addEdge(1,3,15);
        graph.addEdge(2,3,4);

        kruskalMST.getMST(graph);

    }


}
