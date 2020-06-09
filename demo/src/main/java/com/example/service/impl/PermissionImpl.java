package com.example.service.impl;

import com.example.dao.PermissionDao;
import com.example.entity.Permission;
import com.example.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2020年06月01日 17:26
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PermissionImpl implements PermissionService {

    final PermissionDao permissionDao;

    public PermissionImpl(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Override
    public boolean insert(String permission, String functions) {

        return permissionDao.insert(permission, functions) == 1;
    }

    @Override
    public boolean delete(String permission) {
        return permissionDao.delete(permission) == 1;
    }

    @Override
    public boolean update(String permission, String functions) {
        return permissionDao.update(permission, functions) == 1;
    }

    @Override
    public List<Permission> selectAll() {
        return permissionDao.selectAll();
    }

    @Override
    public Permission select(String permission) {
        return permissionDao.select(permission);
    }


}
