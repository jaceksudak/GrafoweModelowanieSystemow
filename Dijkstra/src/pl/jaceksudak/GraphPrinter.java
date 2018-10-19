package pl.jaceksudak;

import java.io.PrintStream;

public class GraphPrinter {

    private PrintStream out;

    public GraphPrinter(PrintStream out) {
        this.out = out;
    }

    public void printSolution(Graph graph) {
        out.println(graph.getSolution());
    }
}
