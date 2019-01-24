package cn.cks.studiowebsite.dao.pojo;

import java.util.List;

public class Peoplevo{
    private List<People> peopleList;
    private List<Integer> checks;

    public List<People> getPeopleList() {
        return peopleList;
    }

    public List<Integer> getChecks() {
        return checks;
    }

    public void setChecks(List<Integer> checks) {
        this.checks = checks;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }

    @Override
    public String toString() {
        return "Peoplevo{" +
                "peopleList=" + peopleList +
                ", checks=" + checks +
                '}';
    }
}
