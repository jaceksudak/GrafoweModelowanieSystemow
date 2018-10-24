package pl.jaceksudak;

import java.util.List;

public class MatchmakingArena {

    private List<Man> men;
    private List<Woman> women;

    public MatchmakingArena(List<Man> men, List<Woman> women) {
        this.men = men;
        this.women = women;
    }

    public List<Man> getMen() {
        return men;
    }

    public List<Woman> getWomen() {
        return women;
    }
}
