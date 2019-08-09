package com.ghhh.community.util.param;

import lombok.Data;
import lombok.ToString;

/**
 * @author galaxy
 * @date 19-8-8 - 上午8:32
 */
@Data
@ToString
public class GithubUserParam {

    private Integer id;
    private String login;
    private String bio;
    private String avatar_url;

}
