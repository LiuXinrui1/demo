package com.example.controller;

import com.example.entity.ResponseResult;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2019-11-24 09:40:06
 */
@CrossOrigin
@RestController()
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    private final UserService userService;

    private final ResponseResult responseResult;

    public UserController(UserService userService, ResponseResult responseResult) {
        this.userService = userService;
        this.responseResult = responseResult;
    }

    /**
     * register
     *
     * @param user
     * @return
     */
    @PostMapping("register")
    public ResponseResult register(@RequestBody User user) {
        boolean insert = userService.insert(user);

        responseResult.setData(insert);
        return responseResult;
    }

    /**
     * @param user
     * @param httpSession
     * @return
     */
    @PostMapping("login")
    public ResponseResult login(@RequestBody User user, HttpSession httpSession) {

        User u = userService.login(user.getUser_name(), user.getUser_password());

        httpSession.setAttribute("user", u);

        responseResult.setData(user);
        return responseResult;
    }


    /**
     * update password
     *
     * @param user
     * @return
     */
    @PostMapping("updatePassword")
    public ResponseResult updatePassword(@RequestBody User user, HttpSession httpSession) {

        boolean b = false;
        if (httpSession.getAttribute("user") != null) {
            b = userService.updateUserPassword(user.getUser_name(), user.getUser_password());
        }

        responseResult.setData(b);
        return responseResult;
    }

    /**
     * delete User
     *
     * @param user
     * @return
     */
    @PostMapping("delete")
    public ResponseResult deleteUser(@RequestBody User user) {
        boolean delete = userService.delete(user.getUser_name());

        responseResult.setData(delete);
        return responseResult;
    }

    /**
     * update User_permission
     *
     * @param user
     * @return
     */
    @PostMapping("updatePermission")
    public ResponseResult updateUserPermission(@RequestBody User user) {
        boolean b = userService.updateUserPermission(user.getUser_name(), user.getPermission_name());

        responseResult.setData(b);
        return responseResult;
    }

    /**
     * queryAll
     *
     * @return
     */
    @GetMapping("queryAll")
    public ResponseResult queryAll() {
        List<User> users = userService.queryAll();

        responseResult.setData(users);
        return responseResult;
    }

    /**
     * operating record
     *
     * @param responseResult
     */
    @PostMapping("operateRecord")
    public void operatingRecord(@RequestBody ResponseResult responseResult) {
        userService.insertOperatingRecord(responseResult);
    }
}