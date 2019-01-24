package cn.cks.studiowebsite.dao.pojo;

public class Studio_updir {
    private int id;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Studio_updir{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
