package com.example.controller;

import com.example.entity.Permission;
import com.example.entity.ResponseResult;
import com.example.service.PermissionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2020年06月01日 17:09
 */
@RestController()
@RequestMapping("permission")
public class PermissionController {
    final
    PermissionService permissionService;

    final
    ResponseResult responseResult;

    public PermissionController(PermissionService permissionService, ResponseResult responseResult) {
        this.permissionService = permissionService;
        this.responseResult = responseResult;
    }

    @PostMapping("add")
    ResponseResult addPermission(@RequestBody Permission permission) {
        boolean insert = permissionService.insert(permission.getPermission_name(), permission.getFunctions());

        responseResult.setData(insert);
        return responseResult;
    }

    @PostMapping("delete")
    ResponseResult deletePermission(@RequestBody Permission permission) {
        boolean delete = permissionService.delete(permission.getPermission_name());

        responseResult.setData(delete);
        return responseResult;
    }

    @PostMapping("update")
    ResponseResult updatePermission(@RequestBody Permission permission) {
        boolean update = permissionService.update(permission.getPermission_name(), permission.getFunctions());

        responseResult.setData(update);
        return responseResult;
    }

    @PostMapping("query")
    ResponseResult queryPermission(@RequestBody Permission permission) {
        Permission permissions = permissionService.select(permission.getPermission_name());

        responseResult.setData(permissions);
        return responseResult;
    }

    @PostMapping("queryAll")
    ResponseResult queryAllPermission() {
        List<Permission> permissions = permissionService.selectAll();

        responseResult.setData(permissions);
        return responseResult;
    }
}
