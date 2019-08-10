package com.ghhh.community.mapper;

import com.ghhh.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * @author galaxy
 * @date 19-8-8 - 下午3:27
 */
@Repository
@Mapper
public interface UserMapper {

    /**
     * 向数据库中插入用户信息
     * @param user 要插入的用户数据模型对象
     */
    @Insert("insert into user(account_id,name,token,gmt_create,gmt_modified,avatar_url) values(#{accountId},#{name}," +
            "#{token}," +
            "#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insertUser(User user);

    @Select("select * from user where token=#{token}")
    User getUserByToken(String token);

    @Select("select * from user where id=#{id}")
    User getUserById(Integer id);
}
