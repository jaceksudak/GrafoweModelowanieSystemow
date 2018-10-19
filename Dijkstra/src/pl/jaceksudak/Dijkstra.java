package pl.jaceksudak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Dijkstra {

    private Scanner scanner;
    private GraphReader graphReader;
    private GraphPrinter graphPrinter;
    private GraphSolver graphSolver;

    private Dijkstra(String inPath, String outPath) throws FileNotFoundException {
        this.scanner = new Scanner(new File(inPath));
        this.graphReader = new GraphReader(scanner);
        this.graphPrinter = new GraphPrinter(new PrintStream(new File(outPath)));
        this.graphSolver = new GraphSolver();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Dijkstra dijkstra = new Dijkstra("input", "my.out");
        dijkstra.run();
    }

    private void run() {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            Graph graph = graphReader.read();
            graphSolver.setGraph(graph);
            int tasks = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < tasks; j++) {
                graphReader.readTask(graph);
                graphSolver.solve();
                graphPrinter.printSolution(graph);
                graph.reset();
            }
        }
    }
}
