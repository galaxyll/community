package com.ghhh.community.service;

import com.ghhh.community.util.param.QuestionParam;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QPDecoderStream;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author galaxy
 * @date 19-8-10 - 下午1:26
 */
@Service
public interface QuestionService {

    List<QuestionParam> getQuestionAndUserList();
}
