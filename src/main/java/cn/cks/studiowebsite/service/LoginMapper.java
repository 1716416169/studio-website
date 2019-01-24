package cn.cks.studiowebsite.service;

import cn.cks.studiowebsite.dao.pojo.Gm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("select * from gm where admin=#{gm.admin} and password=#{gm.password} and 1=1")
    public Gm select(@Param("gm") Gm gm);
}
