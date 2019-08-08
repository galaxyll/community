package com.ghhh.community.util.param;

/**
 * @author galaxy
 * @date 19-8-8 - 上午8:32
 */
public class GithubUserParam {

    private Integer id;
    private String login;
    private String bio;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
