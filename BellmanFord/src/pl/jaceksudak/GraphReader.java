package pl.jaceksudak;

import java.util.Scanner;

public class GraphReader {

    private Scanner scanner;

    public GraphReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Graph readGraph() {
        int size = scanner.nextInt();
        Graph graph = new Graph(size);
        readEdges(graph, size);
        return graph;
    }

    private void readEdges(Graph graph, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int weight = scanner.nextInt();
                if (weight != 0) {
                    Edge edge = new Edge(weight, i, j);
                    graph.addEdge(edge);
                }
            }
        }
    }

}
