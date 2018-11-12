package pl.jaceksudak;

public class Edge {
    private int weight;
    private int sourceVertex;
    private int destVertex;

    public Edge(int weight, int sourceVertex, int destVertex) {
        this.weight = weight;
        this.sourceVertex = sourceVertex;
        this.destVertex = destVertex;
    }

    public int getWeight() {
        return weight;
    }

    public int getSourceVertex() {
        return sourceVertex;
    }

    public int getDestVertex() {
        return destVertex;
    }
}
