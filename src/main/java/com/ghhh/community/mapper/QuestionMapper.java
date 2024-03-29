package com.ghhh.community.mapper;

import com.ghhh.community.model.Question;
import com.ghhh.community.util.param.QuestionParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title}," +
            "#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void insertQuestion( Question question);

    @Select("select * from question ")
    List<Question> getQuestionList();
}
