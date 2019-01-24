package cn.cks.studiowebsite.dao.pojo;
/*
CREATE TABLE `people` (
        `id` int(11) NOT NULL,
        `job` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
        `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
        `phone` int COLLATE utf8_unicode_ci DEFAULT NULL,
        `qq` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
        `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
        `introduce` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
*/
public class People{
    private Integer id;
    private String job;
    private String name;
    private String phone;
    private String qq;
    private String email;
    private String introduce;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "mapper{" +
                "id=" + id +
                ", job='" + job + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
