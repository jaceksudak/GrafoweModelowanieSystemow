package pl.jaceksudak;

import java.io.PrintStream;
import java.util.List;

public class GraphPrinter {

    private PrintStream out;

    public GraphPrinter(PrintStream out) {
        this.out = out;
    }

    public void printGraphDistances(Graph graph) {
        graph.getDistToVerticesPerTurn()
                .remove(0);
        graph.getDistToVerticesPerTurn()
                .forEach(this::printRowDistToVertices);
        out.print("\n");
    }

    private void printRowDistToVertices(List<Integer> distToVertices) {
        for (Integer i : distToVertices) {
            if (i.equals(Integer.MAX_VALUE)) {
                i = 0;
            }
            out.print(i + " ");
        }
        out.print("\n");
    }
}
