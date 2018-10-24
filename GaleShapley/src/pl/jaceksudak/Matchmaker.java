package pl.jaceksudak;

public class Matchmaker {

    private MatchmakingArena matchmakingArena;

    public Matchmaker(MatchmakingArena matchmakingArena) {
        this.matchmakingArena = matchmakingArena;
    }

    public void solve() {
        while (existsManWithoutWoman()) {
            for (Man man : matchmakingArena.getMen()) {
                if (man.getCurrentPartner() == null) {
                    startProposing(man);
                }
            }
        }
    }

    private void startProposing(Man man) {
        while(true) {
            Integer currentBestPreference = man.getCurrentBestPreference();
            Woman preferedWoman = matchmakingArena.getWomen().get(currentBestPreference - 1);
            Integer preferedWomanPartnerId = preferedWoman.getCurrentPartner();
            if ( preferedWomanPartnerId == null) {
                preferedWoman.setPartnerTo(man.getId());
                man.setCurrentPartner(preferedWoman.getId());
                break;
            }
            if (preferedWoman.currentPartnerIsLessAttractiveThan(man.getId())) {
                Man preferedWomanParner = matchmakingArena.getMen().get(preferedWomanPartnerId - 1);
                preferedWomanParner.setPartnerToNull();
                preferedWoman.setPartnerTo(man.getId());
                man.setCurrentPartner(preferedWoman.getId());
                break;
            }
        }
    }

    private boolean existsManWithoutWoman() {
        for (Man man : matchmakingArena.getMen()) {
            if (man.getCurrentPartner() == null) {
                return true;
            }
        }
        return false;
    }
}
