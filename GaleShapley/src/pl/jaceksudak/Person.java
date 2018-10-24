package pl.jaceksudak;

import java.util.List;

public class Person {

    protected Integer id;
    protected List<Integer> preferenceList;
    protected Integer currentPartner;

    Person(int id, List<Integer> preferenceList) {
        this.id = id;
        this.preferenceList = preferenceList;
        this.currentPartner = null;
    }

    public List<Integer> getPreferenceList() {
        return preferenceList;
    }

    public Integer getCurrentPartner() {
        return currentPartner;
    }

    public void setCurrentPartner(Integer currentPartner) {
        this.currentPartner = currentPartner;
    }

    public Integer getId() {
        return id;
    }
}
