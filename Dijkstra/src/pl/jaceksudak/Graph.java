package pl.jaceksudak;

import java.util.Set;

public class Graph {
    private Set<Vertex> vertices;
    private MyHeap<Vertex> unvisited;
    private Vertex target;


    public Graph(Set<Vertex> vertices) {
        this.vertices = vertices;
        this.unvisited = new MyHeap<>(new Vertex[20002]);
        for (Vertex vertex : vertices) {
            vertex.postPopulateEdges(vertices);
        }
    }

    public Set<Vertex> getVertices() {
        return vertices;
    }

    public void setTarget(String target) {
        this.target = vertices.stream()
                .filter(v -> v.getName().equals(target))
                .findFirst().get();
    }

    public MyHeap<Vertex> getUnvisited() {
        return unvisited;
    }

    public void setStart(String start) {
        Vertex startVertex = vertices.stream()
                .filter(v -> v.getName().equals(start))
                .findFirst().get();
        startVertex.setDistance(0);
        vertices.remove(startVertex);
        unvisited.addNode(startVertex);
        for (Vertex vertex : vertices) {
            unvisited.addNode(vertex);
        }
        vertices.add(startVertex);
    }

    public int getSolution() {
        return target.getDistance();
    }

    public void reset() {
        for (Vertex vertex : vertices) {
            vertex.setDistance(Integer.MAX_VALUE);
        }
        this.unvisited = new MyHeap<>(new Vertex[20002]);
        this.target = null;
    }

    public Vertex getFirstUnvisited() {
        return unvisited.extractRoot();
    }
}
