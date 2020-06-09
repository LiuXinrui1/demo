package com.example.service;

import com.example.entity.Permission;

import java.util.List;

public interface PermissionService {
    boolean insert(String permission, String functions);

    boolean delete(String permission);

    boolean update(String permission, String functions);

    List<Permission> selectAll();

    Permission select(String permission);

}
