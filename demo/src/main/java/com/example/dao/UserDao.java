package com.example.dao;

import com.example.entity.OperatingRecord;
import com.example.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2019-11-24 09:40:05
 */
@Repository
@Mapper
public interface UserDao {


    @Delete("delete from user_manage.user_table where user_name=#{user_name} ")
    int delete(String user_name);


    @Update("update user_manage.user_table set user_password=#{user_password} where user_name=#{user_name} ")
    int updateUserPassword(String user_name, String user_password);


    @Select("select * from user_manage.user_table where user_name=#{user_name} and user_password=#{user_password} and user_phone=#{user_phone}")
    User query(String user_name, String user_password, String user_phone);

    @Select("select * from user_manage.user_table where user_name=#{user_name} and user_password=#{user_password}")
    User login(String user_name, String user_password);

    @Select("select * from user_manage.user_table")
    List<User> queryAll();

    @Update("update user_manage.user_table set permission_name=#{permission_name} where user_name=#{user_name}")
    boolean updateUserPermission(String user_name, String permission_name);

    @Insert("insert into user_manage.operatingRecord_table (name,operate,source) values(#{data.name},#{data.operate},#{data.source})")
    void insertOperatingRecord(OperatingRecord data);

    @Insert("insert into user_manage.user_table (user_name,user_password,user_phone,permission_name,status) values(#{user.user_name},#{user.user_password},#{user.user_phone},#{user.permission_name},#{user.status})")
    int insert(@Param("user") User user);
}