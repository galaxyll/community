package com.ghhh.community.model;

import lombok.Data;

/**
 * @author galaxy
 * @date 19-8-8 - 下午3:29
 */
@Data
public class User {

    private Integer id;
    private String accountId;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
