package pl.jaceksudak;

public class GraphSolver {

    private Graph graph;


    public GraphSolver() {
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void solve() {
        for (int i = 0; i < graph.getVertices().size(); i++) {
            Vertex vertex = graph.getFirstUnvisited();
            relax(vertex);
        }
    }

    private void relax(Vertex analyzedVertex) {
        analyzedVertex.getEdges()
                .forEach((vertex, distance) -> {
                    Integer currentDistance = vertex.getDistance();
                    Integer possibleNewDistance = analyzedVertex.getDistance() + distance;
                    if (currentDistance > possibleNewDistance) {
                        vertex.setDistance(possibleNewDistance);
                        graph.getUnvisited().shiftUp(vertex.getHeapPosition());
                    }
                });
    }
}
