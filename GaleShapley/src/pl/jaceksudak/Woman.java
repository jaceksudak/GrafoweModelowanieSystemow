package pl.jaceksudak;

import java.util.List;

public class Woman extends Person {

    public Woman(int id, List<Integer> preferenceList) {
        super(id, preferenceList);
    }

    public void setPartnerTo(Integer i) {
        this.currentPartner = i;
    }

    public boolean currentPartnerIsLessAttractiveThan(Integer id) {
        return preferenceList.indexOf(currentPartner) > preferenceList.indexOf(id);
    }
}
