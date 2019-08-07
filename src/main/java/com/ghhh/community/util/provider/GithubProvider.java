package com.ghhh.community.util.provider;

import com.alibaba.fastjson.JSON;
import com.ghhh.community.util.param.AccessTokenParam;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.RequestBody;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

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
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        request.headers("Accept: application/json");
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
//            Map<String,String> map = (Map<String, String>) JSON.parse(string);
//            System.out.println(map.get("access_token"));

            System.out.println(string);
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
