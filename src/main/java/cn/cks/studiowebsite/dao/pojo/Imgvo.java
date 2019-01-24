package cn.cks.studiowebsite.dao.pojo;

import java.util.List;

public class Imgvo {
    private List<Img> imgeList;
    private List<Integer> checks;

    public List<Img> getImgeList() {
        return imgeList;
    }

    public void setImgeList(List<Img> imgeList) {
        this.imgeList = imgeList;
    }

    public List<Integer> getChecks() {
        return checks;
    }

    public void setChecks(List<Integer> checks) {
        this.checks = checks;
    }

    @Override
    public String toString() {
        return "Imgvo{" +
                "imgeList=" + imgeList +
                ", checks=" + checks +
                '}';
    }
}
