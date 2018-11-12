package pl.jaceksudak;

import java.util.List;

public class GraphSolver {

    private Graph graph;

    public GraphSolver(Graph graph) {
        this.graph = graph;
    }

    public void solveGraph() {
        for (int i = 0; i < graph.getSize() - 1; i++) {
            relaxEdges();
        }
    }

    private void relaxEdges() {
        List<Integer> newDistToVertices = graph.getCopyOfLastDistToVertices();
        for (Edge edge : graph.getEdges()) {
            int du = newDistToVertices.get(edge.getSourceVertex());
            int dv = newDistToVertices.get(edge.getDestVertex());
            int weight = edge.getWeight();
            if ((du != Integer.MAX_VALUE) && (du + weight < dv)) {
                newDistToVertices.set(edge.getDestVertex(), du + weight);
            }
        }
        graph.getDistToVerticesPerTurn().add(newDistToVertices);
    }
}
