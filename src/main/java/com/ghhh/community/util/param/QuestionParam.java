package com.ghhh.community.util.param;

import com.ghhh.community.model.Question;
import com.ghhh.community.model.User;
import lombok.Data;

/**
 * @author galaxy
 * @date 19-8-10 - 下午1:23
 */
@Data
public class QuestionParam {
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
    private User user;
}
