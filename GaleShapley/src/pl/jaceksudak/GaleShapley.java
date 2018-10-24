package pl.jaceksudak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class GaleShapley {

    private Scanner scanner;
    private ProblemReader problemReader;
    private ProblemPrinter problemPrinter;

    private GaleShapley(String inPath, String outPath) throws FileNotFoundException {
        this.scanner = new Scanner(new File(inPath));
        this.problemReader = new ProblemReader(scanner);
        this.problemPrinter = new ProblemPrinter(new PrintStream(new File (outPath)));
    }

    public static void main(String[] args) throws FileNotFoundException {
        GaleShapley galeShapley = new GaleShapley("big_in", "my.out");
        galeShapley.run();
    }

    private void run() {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            MatchmakingArena matchmakingArena = problemReader.readArena();
            Matchmaker matchmaker = new Matchmaker(matchmakingArena);
            matchmaker.solve();
            problemPrinter.printSolution(matchmakingArena);
        }
    }

}
