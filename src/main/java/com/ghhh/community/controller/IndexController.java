package com.ghhh.community.controller;

import com.ghhh.community.mapper.UserMapper;
import com.ghhh.community.model.User;
import com.ghhh.community.service.QuestionService;
import com.ghhh.community.util.param.QuestionParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author galaxy
 * @date 19-8-8 - 下午4:38
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model)
    {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    User user = userMapper.getUserByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        List<QuestionParam> questionParamList = questionService.getQuestionAndUserList();
        model.addAttribute("questions",questionParamList);
        return "index";
    }
}
