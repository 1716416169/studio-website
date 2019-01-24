package cn.cks.studiowebsite.service;

import cn.cks.studiowebsite.dao.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.LinkedList;
import java.util.List;

@Mapper
public interface GmMapper {

    /* 人员操作*/
    @Select("select * from people")
    LinkedList<People> select();

    @Select("select * from people where id=#{id}")
    LinkedList<People> selectById(int id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into people(id,job,name,phone,qq,email,introduce) values(#{id},#{job},#{name},#{phone},#{qq},#{email},#{introduce})")
    void insertPeople(People people);

    void deleteByid(List<Integer> list);

    int demo(int demo);

    void updata(People people);

    /*图片操作*/
    @Insert("insert into img(path,k) values(#{path},#{k})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertImg(Img img);

    @Select("select * from img")
    List<Img> selectImg();

    @Update("update img set text=#{text} where id=#{id}")
    void updateImg(Img img);

    void deleteimgById(List<Integer> checks);

    List<Img> selectImgsById(List<Integer> list);



    /*动态图片操作*/
    @Insert("insert into imgdynamic(path,k) values(#{path},#{k})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertDynamicImg(Img img);

    @Update("update imgdynamic set text=#{text} where id=#{id}")
    void updateDynamicImgImg(Img img);

    void deleteDynamicimgById(List<Integer> checks);

    @Select("select * from imgdynamic")
    List<Img> selectDynamicImg();

    List<Img> selectDynamicimgById(List<Integer> list);



    /*更新文本页*/
    @Update("update studio_introduce set text=#{text} where id=1")
    void updatestudio_introduce(Studio_introduce studio_introduce);

    @Update("update studio_stu set text=#{text} where id=1")
    void updatestudio_Studio_stu(Studio_stu studio_stu);

    @Update("update studio_updir set text=#{text} where id=1")
    void updatestudio_studio_updir(Studio_updir studio_updir);



    /*查询文本页*/
    @Select("select * from studio_introduce")
    Studio_introduce selectStudio_introduce();

    @Select("select * from studio_stu")
    Studio_stu selectStudio_stu();

    @Select("select * from studio_updir")
    Studio_updir selectStudio_updir();
}
