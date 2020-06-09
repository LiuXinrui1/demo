package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.entity.OperatingRecord;
import com.example.entity.ResponseResult;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2019-11-24 09:40:06
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean delete(String user_name) {
        int delete = userDao.delete(user_name);
        return delete == 1;
    }

    @Override
    public boolean updateUserPassword(String user_name, String user_password) {
        int i = userDao.updateUserPassword(user_name, user_password);
        return i == 1;
    }

    @Override
    public User query(String user_name, String user_password, String user_phone) {
        return userDao.query(user_name, user_password, user_phone);
    }

    @Override
    public User login(String user_name, String user_password) {
        return userDao.login(user_name, user_password);
    }

    @Override
    public boolean updateUserPermission(String user_name, String permission_name) {
        return userDao.updateUserPermission(user_name, permission_name);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public void insertOperatingRecord(ResponseResult responseResult) {
        OperatingRecord data = (OperatingRecord) responseResult.getData();
        userDao.insertOperatingRecord(data);
    }

    @Override
    public boolean insert(User user) {
        int insert = userDao.insert(user);
        return insert == 1;
    }
}