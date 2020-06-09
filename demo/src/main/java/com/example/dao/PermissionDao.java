package com.example.dao;

import com.example.entity.Permission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2020年06月01日 17:27
 */
@Repository
@Mapper
public interface PermissionDao {
    @Insert("insert into user_manage.permission_table (permission_name,functions) values(#{permission},#{functions})")
    int insert(String permission, String functions);

    @Delete("delete from user_manage.permission_table where permission_name=#{permission_name} ")
    int delete(String permission);

    @Update("update user_manage.permission_table set functions=#{functions} where permission_name=#{permission_name} ")
    int update(String permission, String functions);

    @Select("select * from user_manage.permission_table")
    List<Permission> selectAll();

    @Select("select * from user_manage.permission_table where permission_name=#{permission}")
    Permission select(String permission);
}
