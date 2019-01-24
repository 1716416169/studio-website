package cn.cks.studiowebsite.dao.pojo;

/*
CREATE TABLE `Gm` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `admin` varchar(45) DEFAULT NULL,
        `password` varchar(45) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
*/

public class Gm {
    private int id;
    private String admin;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Gm{" +
                "id=" + id +
                ", admin='" + admin + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
