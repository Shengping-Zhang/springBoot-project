package com.ping.mapper.two;

import com.ping.bean.UserEntity;
import com.ping.bean.UserParam;
import com.ping.mapper.UserSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zsp
 * @version $Id UserTwoMapper.java, v 1.0 2019-06-06 16:48 zsp Vl $$
 */
public interface UserTwoMapper {
    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = String.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> findAll();

    @Select("SELECT * FROM users WHERE id=#{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = String.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity findOne(Long id);

    @Insert("INSERT INTO users(userName, passWord, user_sex)VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(UserEntity user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

    @SelectProvider(type = UserSql.class, method = "getList")
    List<UserEntity> getList(UserParam userParam);

    @SelectProvider(type = UserSql.class, method = "getCount")
    int getCount(UserParam userParam);

}
