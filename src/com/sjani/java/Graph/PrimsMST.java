package com.sjani.java.Graph;

import java.util.*;

import com.sjani.java.Graph.Graph.*;
import com.sjani.java.Heap.BinaryHeap;
import com.sjani.java.Heap.Node;

public class PrimsMST {


    public void getMST(Graph<Integer> graph){

        BinaryHeap<Vertex<Integer>> minHeap = new BinaryHeap<Vertex<Integer>>(true);
        Map<Vertex<Integer>,Edge<Integer>> vertexToEdge = new HashMap<>();
        ArrayList<Edge> mst = new ArrayList<>();


        for (Vertex<Integer> v: graph.getAllVertices()) {
            minHeap.add(Integer.MAX_VALUE,v);
        }

        Vertex<Integer> startVertex = graph.getAllVertices().iterator().next();
        minHeap.decrease(startVertex, 0);

        while(!minHeap.isEmpty()){
            Node node = minHeap.poll();
            Vertex<Integer> current = (Vertex<Integer>) node.getItem();
            Edge<Integer> spanningTreeEdge = vertexToEdge.get(current);
            if(spanningTreeEdge != null) {
                mst.add(spanningTreeEdge);
            }
            for (Edge<Integer> edge: current.getEdges()) {
                Vertex<Integer> adjacent = getVertexForEdge(current, edge);
                if(minHeap.contains(adjacent) && minHeap.getWeight(adjacent) > edge.getWeight()){
                        minHeap.decrease(adjacent,edge.getWeight());
                        vertexToEdge.put(adjacent,edge);
                }
            }

        }

        System.out.println("Prim's MST:");
        graph.printGraph(mst);

    }

    private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e) {
        return e.getSrc().equals(v) ? e.getSrc() : e.getDest();
    }
        public static void main(String[] args) {


        PrimsMST primsMST = new PrimsMST();
        Graph<Integer> graph = new Graph(false);


        graph.addEdge(0,1,10);
        graph.addEdge(0,2,6);
        graph.addEdge(0,3,5);
        graph.addEdge(1,3,15);
        graph.addEdge(2,3,4);

        primsMST.getMST(graph);

    }

}
