package com.example.service;

import com.example.entity.ResponseResult;
import com.example.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2019-11-24 09:40:05
 */

public interface UserService {


    boolean delete(String user_phone);


    boolean updateUserPassword(String user_name, String user_password);


    User query(String user_name, String user_password, String user_phone);


    User login(String user_name, String user_password);

    boolean updateUserPermission(String user_name, String permission_name);

    List<User> queryAll();

    void insertOperatingRecord(ResponseResult responseResult);

    boolean insert(User user);
}