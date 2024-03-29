package com.ghhh.community.model;

import lombok.Data;

/**
 * @author galaxy
 * @date 19-8-9 - 上午9:59
 */
@Data
public class Question {

    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
}
