package cn.cks.studiowebsite.dao.pojo;
/*

CREATE TABLE `Studio_introduce` (
        `id` int(11) NOT NULL,
        `text` char(100) NOT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/

public class Studio_introduce {
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
        return "Studio_introduce{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
