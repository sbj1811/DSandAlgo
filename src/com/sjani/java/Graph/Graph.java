package com.sjani.java.Graph;

import java.util.*;

public class Graph<T> {

    boolean isDirected = false;
    private Map<Long, Vertex<T>> Vertices;
    private List<Edge<T>> edges;

    public Graph(boolean isDirected) {
        Vertices = new HashMap<Long, Vertex<T>>();
        edges = new ArrayList<Edge<T>>();
        this.isDirected = isDirected;
    }

    public static void main(String[] args) {
        int V = 4, E = 3;
        Graph graph = new Graph(false);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 2);


        if (graph.isCycle())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }

    public List<Edge<T>> getAllEdges() {
        return edges;
    }

    public Collection<Vertex<T>> getAllVertices() {
        return Vertices.values();
    }

    public void addEdge(long id1, long id2) {
        addEdge(id1, id2, 0);
    }

    public void addEdge(long src, long dest, int weight) {
        Vertex<T> v1;
        Vertex<T> v2;
        if (Vertices.containsKey(src)) {
            v1 = Vertices.get(src);
        } else {
            v1 = new Vertex<>(src);
            Vertices.put(src, v1);
        }
        if (Vertices.containsKey(dest)) {
            v2 = Vertices.get(dest);
        } else {
            v2 = new Vertex<>(dest);
            Vertices.put(dest, v2);
        }

        Edge<T> edge = new Edge<T>(v1, v2, weight);
        edges.add(edge);
        v1.addAdjecentVertices(edge, v2);
        if (!isDirected) {
            v2.addAdjecentVertices(edge, v1);
        }

    }

    public boolean isCycle() {
        DisjointSet djs = new DisjointSet();

        for (Vertex<T> v : Vertices.values()) {
            djs.makeSet(v.getId());
        }

        for (Edge<T> e : edges) {
            long x = djs.find(e.getSrc().getId());
            long y = djs.find(e.getDest().getId());
            if (x == y) return true;
            djs.union(x, y);
        }
        return false;
    }

    public Vertex<T> getVertex(long id){
        return Vertices.get(id);
    }

    public void printGraph(ArrayList<Edge> edgeList) {
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            System.out.println(i + " : " + edge.getSrc().id +
                    " -- " + edge.getDest().id +
                    " : " + edge.getWeight());
        }
    }
}

class Vertex<T> implements Comparable<Vertex<T>> {
    long id;
    private T data;
    private List<Edge<T>> edges = new ArrayList<>();
    private List<Vertex<T>> adjecentVertices = new ArrayList<>();

    Vertex(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge<T>> edges) {
        this.edges = edges;
    }

    public List<Vertex<T>> getAdjecentVertices() {
        return adjecentVertices;
    }

    public void addAdjecentVertices(Edge<T> e, Vertex<T> v) {
        this.edges.add(e);
        this.adjecentVertices.add(v);
    }

    @Override
    public int compareTo(Vertex<T> o) {
        return (int) (this.getId() - o.getId());
    }
}

class Edge<T> {
    private Vertex<T> src, dest;
    private int weight;

    Edge(Vertex<T> src, Vertex<T> dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    Edge(Vertex<T> src, Vertex<T> dest) {
        this.src = src;
        this.dest = dest;
    }

    Vertex<T> getSrc() {
        return src;
    }

    void setSrc(Vertex<T> src) {
        this.src = src;
    }

    Vertex<T> getDest() {
        return dest;
    }

    void setDest(Vertex<T> dest) {
        this.dest = dest;
    }

    int getWeight() {
        return weight;
    }

    void setWeight(int weight) {
        this.weight = weight;
    }


}
