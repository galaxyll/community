package com.ghhh.community.controller;

import com.ghhh.community.mapper.UserMapper;
import com.ghhh.community.model.User;
import com.ghhh.community.util.param.AccessTokenParam;
import com.ghhh.community.util.param.GithubUserParam;
import com.ghhh.community.util.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


/**
 * @author galaxy
 * @date 19-8-7 - 下午2:25
 */

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    /**
     * 授权成功回调的Url
     */
    @Value("${github.client.redirectUri}")
    private String redirectUri ;
    /**
     * 分配的客户端id
     */
    @Value("${github.client.clientId}")
    private String clientId ;
    /**
     * 分配的客户端秘钥
     */
    @Value("${github.client.clientSecret}")
    private String clientSecret ;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code, @RequestParam("state") String state,
                           HttpServletRequest request, HttpServletResponse response)
    {
        AccessTokenParam accessTokenParam = new AccessTokenParam();
        accessTokenParam.setCode(code);
        accessTokenParam.setRedirect_uri(redirectUri);
        accessTokenParam.setState(state);
        accessTokenParam.setClient_id(clientId);
        accessTokenParam.setClient_secret(clientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenParam);
        GithubUserParam githubUser = githubProvider.getGithubUserInfo(accessToken);
        if (githubUser!=null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setName(githubUser.getLogin());
            user.setToken(token);
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insertUser(user);
            response.addCookie(new Cookie("token",token));
            return "redirect:/";
        }else {
            return "redirect:/";
        }
    }
}
