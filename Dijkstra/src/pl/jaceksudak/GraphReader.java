package pl.jaceksudak;

import java.util.*;

public class GraphReader {

    private Scanner scanner;

    public GraphReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Graph read() {
        int size = scanner.nextInt();
        Set<Vertex> vertices = readVertices(size);
        return new Graph(vertices);
    }

    private Set<Vertex> readVertices(int size) {
        Set<Vertex> vertices = new HashSet<>();
        for (int i = 1; i <= size; i++) {
            vertices.add(readVertex(i));
        }
        return vertices;
    }

    private Vertex readVertex(int i) {
        scanner.nextLine();
        String name = scanner.nextLine();
        int numberOfEdges = scanner.nextInt();
        Map<Integer, Integer> edges = new HashMap<>();
        for (int j = 1; j <= numberOfEdges; j++) {
            edges.put(scanner.nextInt(), scanner.nextInt());
        }
        return new Vertex(name, i, edges);
    }

    public void readTask(Graph graph) {
        String[] line = scanner.nextLine().split(" ");
        graph.setStart(line[0]);
        graph.setTarget(line[1]);
    }
}
