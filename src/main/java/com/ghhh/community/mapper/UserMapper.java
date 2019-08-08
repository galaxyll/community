package com.ghhh.community.mapper;

import com.ghhh.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


/**
 * @author galaxy
 * @date 19-8-8 - 下午3:27
 */
@Component
@Mapper
public interface UserMapper {

    /**
     * 向数据库中插入用户信息
     * @param user 要插入的用户数据模型对象
     */
    @Insert("insert into user(account_id,name,token,gmt_create,gmt_modified) values(#{accountId},#{name},#{token}," +
            "#{gmtCreate},#{gmtModified})")
    void insertUser(User user);
}
