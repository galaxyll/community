package com.ghhh.community.mapper;

import com.ghhh.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title}," +
            "#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void insertQuestion( Question question);
}
