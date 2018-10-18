package pl.jaceksudak;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Vertex {
    private String name;
    private Integer number;
    private Map<Vertex, Integer> edges;
    private Map<Integer, Integer> prePopulatedEdges;
    private Integer distance;


    public Vertex(String name, Integer number, Map<Integer, Integer> edges) {
        this.name = name;
        this.number = number;
        this.edges = new HashMap<>();
        this.prePopulatedEdges = edges;
        this.distance = Integer.MAX_VALUE;
    }

    public void postPopulateEdges(Set<Vertex> vertices) {
        edges = prePopulatedEdges.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> findVertex(vertices, e.getKey()), Map.Entry::getValue));
    }

    private Vertex findVertex(Set<Vertex> vertices, int number) {
        return vertices.stream()
                .filter(v -> v.getNumber() == number)
                .findFirst().get();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Map<Vertex, Integer> getEdges() {
        return edges;
    }

    public void setEdges(Map<Vertex, Integer> edges) {
        this.edges = edges;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Integer, Integer> getPrePopulatedEdges() {
        return prePopulatedEdges;
    }

    public void setPrePopulatedEdges(Map<Integer, Integer> prePopulatedEdges) {
        this.prePopulatedEdges = prePopulatedEdges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name) &&
                Objects.equals(number, vertex.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        String edgesString = edges.entrySet().stream()
                .map(e -> e.getKey().name + " - " + e.getValue().toString())
                .collect(Collectors.joining("\n"));
        return "Vertex{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", edges = " + edgesString +
                ", prePopulatedEdges=" + prePopulatedEdges +
                ", distance=" + distance +
                '}';
    }
}
