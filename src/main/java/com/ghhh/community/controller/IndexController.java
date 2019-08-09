package com.ghhh.community.controller;

import com.ghhh.community.mapper.UserMapper;
import com.ghhh.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author galaxy
 * @date 19-8-8 - 下午4:38
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String index(HttpServletRequest request)
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
        return "index";
    }
}
