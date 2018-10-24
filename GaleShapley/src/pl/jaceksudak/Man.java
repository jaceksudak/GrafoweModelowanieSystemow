package pl.jaceksudak;

import java.util.List;

public class Man extends Person {

    public Man(int id, List<Integer> preferenceList) {
        super(id, preferenceList);
    }

    public void setPartnerToNull() {
        this.currentPartner = null;
    }

    public Integer getCurrentBestPreference() {
        Integer bestPreference = this.preferenceList.get(0);
        this.preferenceList.remove(0);
        return bestPreference;
    }
}
