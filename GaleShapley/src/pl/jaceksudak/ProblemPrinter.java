package pl.jaceksudak;

import java.io.PrintStream;

public class ProblemPrinter {

    private PrintStream out;

    public ProblemPrinter(PrintStream out) {
        this.out = out;
    }

    public void printSolution(MatchmakingArena arena) {
        for (Man man : arena.getMen()) {
            out.println(man.getId() + " " + man.getCurrentPartner());
        }
    }
}
