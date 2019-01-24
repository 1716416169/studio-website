package cn.cks.studiowebsite.dao.pojo;
/*
CREATE TABLE `Img` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `path` char(100) NOT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/

public class Img {
    private int id;
    private String path;
    private String text;
    private String k;

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Img{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", text='" + text + '\'' +
                ", k='" + k + '\'' +
                '}';
    }
}
