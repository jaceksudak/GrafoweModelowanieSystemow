package pl.jaceksudak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class BellmanFord {

    private Scanner scanner;
    private GraphReader graphReader;
    private GraphPrinter graphPrinter;

    private BellmanFord(String inPath, String outPath) throws FileNotFoundException {
        this.scanner = new Scanner(new File(inPath));
        this.graphReader = new GraphReader(scanner);
        this.graphPrinter = new GraphPrinter(new PrintStream(new File (outPath)));
    }

    public static void main(String[] args) throws FileNotFoundException {
        BellmanFord bellmanFord = new BellmanFord("in", "my.out");
        bellmanFord.run();
    }

    private void run() {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            Graph graph = graphReader.readGraph();
            GraphSolver graphSolver = new GraphSolver(graph);
            graphSolver.solveGraph();
            graphPrinter.printGraphDistances(graph);
        }
    }
}
