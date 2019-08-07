package com.ghhh.community.controller;

import com.ghhh.community.util.param.AccessTokenParam;
import com.ghhh.community.util.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author galaxy
 * @date 19-8-7 - 下午2:25
 */

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code,@RequestParam("state") String state)
    {

        AccessTokenParam accessTokenParam = new AccessTokenParam();
        accessTokenParam.setCode(code);
        accessTokenParam.setRedirect_uri("http://localhost:8080/callback");
        accessTokenParam.setState(state);
        accessTokenParam.setClient_id("e11cb13c6975c2a8ba87");
        accessTokenParam.setClient_secret("5381889f198c59b9f6f0f256eb908c09eda6d8d3");
        githubProvider.getAccessToken(accessTokenParam);
        return "index";
    }
}
