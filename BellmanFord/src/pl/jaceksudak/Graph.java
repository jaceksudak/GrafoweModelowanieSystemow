package pl.jaceksudak;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int size;
    private List<List<Integer>> distToVerticesPerTurn;
    private List<Edge> edges;

    public Graph(int size) {
        this.size = size;
        this.edges = new LinkedList<>();
        this.distToVerticesPerTurn = new LinkedList<>();
        List<Integer> distToVertices = new ArrayList<>(size);
        distToVertices.add(0);
        for (int i = 1; i < size; i++) {
            distToVertices.add(Integer.MAX_VALUE);
        }
        this.distToVerticesPerTurn.add(distToVertices);
    }

    public int getSize() {
        return size;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    public List<List<Integer>> getDistToVerticesPerTurn() {
        return distToVerticesPerTurn;
    }

    public List<Integer> getCopyOfLastDistToVertices() {
        return new ArrayList<>(distToVerticesPerTurn.get(distToVerticesPerTurn.size() - 1));
    }
}
