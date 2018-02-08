package com.gutongxue.wxapp.dao;

import com.gutongxue.wxapp.domain.JokeDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface JokeMapper {
    @Results({
            @Result(property = "id" , column = "id"),
            @Result(property = "content" , column = "joke_content"),
            @Result(property = "source" , column = "joke_source"),
            @Result(property = "createTime" , column = "gmt_create"),
            @Result(property = "modifiedTime" , column = "gmt_modified")
    })
    @Select("select * from gtx_base_joke where joke_status = 1 order by gmt_modified desc")
    List<JokeDO> listJoke();

    @Select("select count(*) from gtx_base_joke where joke_status = 1")
    int countJoke();

    @Select("select count(*) from gtx_base_joke where joke_content = #{0}")
    int countJokeByDescription(String content);

    @Insert("insert into `gtx_base_joke` (`user_openid`,`gmt_create`,`gmt_modified`,`joke_content`,`joke_source`,`joke_status`)\n" +
            " values(#{joke.openid},#{joke.createTime},#{joke.modifiedTime},#{joke.content},#{joke.source},#{joke.status})")
    void insertJoke(@Param("joke") JokeDO jokeDO);

    @Delete("delete from gtx_base_joke where id = #{0}")
    void deleteJoke(int id);

    @Update("update gtx_base_joke set joke_status = #{1} , gmt_modified = #{2} where id = #{0}")
    void updateJokeStatus(int id,int status,String now);
}
