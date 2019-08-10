package com.ghhh.community.service.impl;

import com.ghhh.community.mapper.QuestionMapper;
import com.ghhh.community.mapper.UserMapper;
import com.ghhh.community.model.Question;
import com.ghhh.community.model.User;
import com.ghhh.community.service.QuestionService;
import com.ghhh.community.util.param.QuestionParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

/**
 * @author galaxy
 * @date 19-8-10 - 下午1:29
 */
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<QuestionParam> getQuestionAndUserList() {
        List<Question> questionList = questionMapper.getQuestionList();
        List<QuestionParam> questionParamList = new LinkedList<>();
        for (Question question : questionList) {
            User user = userMapper.getUserById(question.getCreator());
            QuestionParam questionParam = new QuestionParam();
            BeanUtils.copyProperties(question, questionParam);
            questionParam.setUser(user);
            questionParamList.add(questionParam);
        }
        return questionParamList;
    }
}
