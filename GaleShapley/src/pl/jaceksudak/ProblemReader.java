package pl.jaceksudak;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProblemReader {

    private Scanner scanner;

    public ProblemReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public MatchmakingArena readArena() {
        int size = scanner.nextInt();
        List<Woman> women = readWomen(size);
        List<Man> men = readMen(size);
        return new MatchmakingArena(men, women);
    }

    private List<Woman> readWomen(int size) {
        List<Woman> women = new ArrayList<>(size);
        for (int i = 1; i <= size; i++) {
            scanner.nextInt();
            List<Integer> preferenceList = new LinkedList<>();
            for (int j = 0; j < size; j++) {
                preferenceList.add(scanner.nextInt());
            }
            women.add(new Woman(i, preferenceList));
        }
        return women;
    }

    private List<Man> readMen(int size) {
        List<Man> men = new ArrayList<>(size);
        for (int i = 1; i <= size; i++) {
            scanner.nextInt();
            List<Integer> preferenceList = new LinkedList<>();
            for (int j = 0; j < size; j++) {
                preferenceList.add(scanner.nextInt());
            }
            men.add(new Man(i, preferenceList));
        }
        return men;
    }
}
