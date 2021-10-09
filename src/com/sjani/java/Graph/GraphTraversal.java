package com.sjani.java.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphTraversal {

    public static void main(String args[])
    {
        int V = 4, E = 3;
        Graph g = new Graph(false);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.print("DFS: \n");
        DFS(g);
        System.out.print("BFS: \n");
        BFS(g);
    }

    public static void DFS(Graph<Integer> graph){
        Set<Long> visited = new HashSet<>();
        for(Vertex<Integer> vertex : graph.getAllVertices()){
            if(!visited.contains(vertex.getId())){
                dfsHelper(vertex, visited);
            }
        }
        System.out.print("\n");
    }

    private static void dfsHelper(Vertex<Integer> vertex, Set<Long> visited) {
        visited.add(vertex.getId());
        System.out.print(vertex.getId()+" ");
        for(Vertex<Integer> v : vertex.getAdjecentVertices()){
            if(!visited.contains(v.getId())){
                dfsHelper(v, visited);
            }
        }
    }

    public static void BFS(Graph<Integer> graph){
        Set<Long> visited = new HashSet<>();
        Queue<Vertex<Integer>> q = new LinkedList<>();

        for(Vertex<Integer> vertex : graph.getAllVertices()){
            if(!visited.contains(vertex.getId())){
                q.add(vertex);
                visited.add(vertex.getId());
                while(q.size() != 0){
                    Vertex<Integer> vert = q.poll();
                    System.out.print(vert.getId()+" ");
                    for(Vertex<Integer> v : vert.getAdjecentVertices()){
                        if(!visited.contains(v.getId())){
                            q.add(v);
                            visited.add(v.getId());
                        }
                    }
                }
            }
        }
        System.out.print("\n");
    }
}
