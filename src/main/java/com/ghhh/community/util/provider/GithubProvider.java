package com.ghhh.community.util.provider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ghhh.community.util.param.AccessTokenParam;
import com.ghhh.community.util.param.GithubUserParam;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.RequestBody;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author galaxy
 * @date 19-8-7 - 下午3:23
 */
@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenParam accessTokenParam)
    {
        MediaType mediaType
                = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenParam),mediaType);
        System.out.println();
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .addHeader("Accept"," application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return JSON.parseObject(response.body().string()).getString("access_token");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUserParam getGithubUserInfo(String token)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+token)
                .addHeader("Accept"," application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            GithubUserParam githubUserParam = JSONObject.parseObject(response.body().string(),GithubUserParam.class);
            return githubUserParam;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
