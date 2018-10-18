package pl.jaceksudak;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Graph {
    private Set<Vertex> vertices;
    private Set<Vertex> unvisited;
    private Vertex target;


    public Graph(Set<Vertex> vertices) {
        this.vertices = vertices;
        this.unvisited = new HashSet<>(vertices);
        for (Vertex vertex : vertices) {
            vertex.postPopulateEdges(vertices);
        }
    }

    public Set<Vertex> getVertices() {
        return vertices;
    }

    public Vertex getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = vertices.stream()
                .filter(v -> v.getName().equals(target))
                .findFirst().get();
    }

    public void setStart(String start) {
        Vertex startVertex = vertices.stream()
                .filter(v -> v.getName().equals(start))
                .findFirst().get();
        startVertex.setDistance(0);
    }

    public int getSolution() {
        return target.getDistance();
    }

    public void reset() {
        for (Vertex vertex : vertices) {
            vertex.setDistance(Integer.MAX_VALUE);
        }
        this.unvisited = new HashSet<>(vertices);
        this.target = null;
    }

    public Vertex getFirstUnvisited() {
        Vertex vertex = unvisited.stream()
                .min(new VertexComparator())
                .orElseThrow(() -> new IllegalStateException("unvisited nie ma min"));
        unvisited.remove(vertex);
        return vertex;
    }

    private class VertexComparator implements Comparator<Vertex> {
        @Override
        public int compare(Vertex o1, Vertex o2) {
            if (o1.getDistance().equals(o2.getDistance())) {
                return o1.getNumber().compareTo(o2.getNumber());
            } else {
                return o1.getDistance().compareTo(o2.getDistance());
            }
        }
    }
}
