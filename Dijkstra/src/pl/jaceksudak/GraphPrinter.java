package pl.jaceksudak;

import java.io.PrintStream;

public class GraphPrinter {

    private PrintStream out;

    public GraphPrinter(PrintStream out) {
        this.out = out;
    }

    public void printGraph(Graph graph) {
        for (Vertex vertex : graph.getVertices()) {
            out.println(vertex);
        }
        out.println("solution " + graph.getSolution());
        out.println("target " + graph.getTarget());
        out.print("\n");
    }

    public void printSolution(Graph graph) {
        out.println(graph.getSolution());
    }
}
